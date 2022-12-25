package com.abdelhakimrafik.radarservice.queries.services;

import com.abdelhakimrafik.commonapi.dtos.EventDataResponseDTO;
import com.abdelhakimrafik.commonapi.dtos.OverSpeedDTO;
import com.abdelhakimrafik.commonapi.queries.OverSpeedQuery;
import com.abdelhakimrafik.radarservice.queries.entities.OverSpeed;
import com.abdelhakimrafik.radarservice.queries.mappers.OverSpeedMapper;
import com.abdelhakimrafik.radarservice.queries.repositories.OverSpeedRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OverSpeedQueryService {

    @Autowired
    private OverSpeedRepository overSpeedRepository;
    @Autowired
    private OverSpeedMapper overSpeedMapper;

    @QueryHandler
    public List<OverSpeedDTO> getAllOverSpeeds(OverSpeedQuery.GetAll query) {
        List<OverSpeed> list = overSpeedRepository.findAll();
        return list.stream().map(overSpeed -> overSpeedMapper.overSpeedToOverSpeedDTO(overSpeed)).collect(Collectors.toList());
    }

    @QueryHandler
    public List<OverSpeedDTO> getOverSpeedsByVehicleMatriculation(OverSpeedQuery.GetByVehicleMatriculation query) {
        List<OverSpeed> list = overSpeedRepository.findByVehicleMatriculation(query.getMatriculation());
        return list.stream().map(overSpeed -> overSpeedMapper.overSpeedToOverSpeedDTO(overSpeed)).collect(Collectors.toList());
    }

    @QueryHandler
    public List<EventDataResponseDTO> handle(OverSpeedQuery.WatchSubscribe query) {
        return new ArrayList<>();
    }
}
