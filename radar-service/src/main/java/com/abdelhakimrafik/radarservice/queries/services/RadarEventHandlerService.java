package com.abdelhakimrafik.radarservice.queries.services;

import com.abdelhakimrafik.commonapi.dtos.EventDataResponseDTO;
import com.abdelhakimrafik.commonapi.dtos.OverSpeedDTO;
import com.abdelhakimrafik.commonapi.events.RadarEvent;
import com.abdelhakimrafik.commonapi.queries.OverSpeedQuery;
import com.abdelhakimrafik.radarservice.queries.entities.OverSpeed;
import com.abdelhakimrafik.radarservice.queries.entities.Radar;
import com.abdelhakimrafik.commonapi.enums.RadarStatus;
import com.abdelhakimrafik.radarservice.queries.mappers.OverSpeedMapper;
import com.abdelhakimrafik.radarservice.queries.repositories.OverSpeedRepository;
import com.abdelhakimrafik.radarservice.queries.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class RadarEventHandlerService {

    @Autowired
    private RadarRepository radarRepository;
    @Autowired
    private OverSpeedRepository overSpeedRepository;
    @Autowired
    private OverSpeedMapper overSpeedMapper;
    @Autowired
    private QueryUpdateEmitter updateEmitter;

    @EventHandler
    public void onRadarCreated(RadarEvent.Created event) {
        Radar radar = Radar.builder()
                .id(event.getId())
                .maxSpeed(event.getMaxSpeed())
                .longitude(event.getLongitude())
                .latitude(event.getLatitude())
                .status(RadarStatus.ENABLED)
                .build();
        radarRepository.save(radar);
    }

    @EventHandler
    public void onRadarUpdated(RadarEvent.Updated event) {
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("Radar not found"));
        if(event.getMaxSpeed() != 0) radar.setMaxSpeed(event.getMaxSpeed());
        if(event.getLongitude() != 0) radar.setLongitude(event.getLongitude());
        if(event.getLatitude() != 0) radar.setLatitude(event.getLatitude());
        radarRepository.save(radar);
    }

    @EventHandler
    public void onRadarStatusUpdated(RadarEvent.StatusUpdated event) {
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("Radar not found"));
        radar.setStatus(event.getStatus());
        radarRepository.save(radar);
    }

    @EventHandler
    public void onRadarDeleted(RadarEvent.Deleted event) {
        radarRepository.deleteById(event.getId());
    }

    @EventHandler
    public void onOverSpeedDetected(RadarEvent.OverSpeedDetected event, @Timestamp Instant timestamp) {
        Radar radar = radarRepository.findById(event.getRadar()).orElseThrow(() -> new RuntimeException("Radar not found"));
        OverSpeed overSpeed = OverSpeed.builder()
                .id(UUID.randomUUID().toString())
                .vehicleMatriculation(event.getVehicleMatriculation())
                .speed(event.getSpeed())
                .timeStamp(timestamp)
                .radar(radar)
                .build();

        //* save over speed
        overSpeed = overSpeedRepository.save(overSpeed);

        OverSpeedDTO overSpeedDTO = overSpeedMapper.overSpeedToOverSpeedDTO(overSpeed);
        EventDataResponseDTO eventDataResponseDTO = new EventDataResponseDTO(
                event.getClass().getSimpleName(),
                overSpeedDTO
        );

        //* dispatch event
        updateEmitter.emit(OverSpeedQuery.WatchSubscribe.class, (query) -> true, eventDataResponseDTO);
    }

}
