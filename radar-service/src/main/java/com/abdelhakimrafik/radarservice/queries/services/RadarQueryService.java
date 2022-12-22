package com.abdelhakimrafik.radarservice.queries.services;

import com.abdelhakimrafik.commonapi.dtos.RadarDTO;
import com.abdelhakimrafik.commonapi.events.radar.RadarCreatedEvent;
import com.abdelhakimrafik.commonapi.queries.radar.GetRadarRequest;
import com.abdelhakimrafik.commonapi.queries.radar.GetRadarsRequest;
import com.abdelhakimrafik.radarservice.queries.entities.Radar;
import com.abdelhakimrafik.radarservice.queries.mappers.RadarMapper;
import com.abdelhakimrafik.radarservice.queries.repositories.RadarRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RadarQueryService {

    @Autowired
    private RadarRepository radarRepository;
    @Autowired
    private RadarMapper radarMapper;

    @EventSourcingHandler
    public void onRadarCreated(RadarCreatedEvent event) {
        Radar radar = Radar.builder()
                .id(event.getId())
                .maxSpeed(event.getMaxSpeed())
                .longitude(event.getLongitude())
                .latitude(event.getLatitude())
                .build();
        radarRepository.save(radar);
    }

    @QueryHandler
    public RadarDTO getRadarById(GetRadarRequest request) {
        Radar radar = radarRepository.findById(request.getId()).get();
        return radarMapper.radarToRadarDTO(radar);
    }

    @QueryHandler
    public List<RadarDTO> getRadarList(GetRadarsRequest request) {
        List<Radar> list = radarRepository.findAll();
        return list.stream().map(radar -> radarMapper.radarToRadarDTO(radar)).collect(Collectors.toList());
    }
}
