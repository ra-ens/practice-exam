package com.abdelhakimrafik.radarservice.queries.services;

import com.abdelhakimrafik.commonapi.dtos.radar.OverSpeedDTO;
import com.abdelhakimrafik.commonapi.dtos.radar.RadarDTO;
import com.abdelhakimrafik.commonapi.queries.OverSpeedQuery;
import com.abdelhakimrafik.commonapi.queries.RadarQuery;
import com.abdelhakimrafik.radarservice.queries.entities.OverSpeed;
import com.abdelhakimrafik.radarservice.queries.entities.Radar;
import com.abdelhakimrafik.radarservice.queries.mappers.OverSpeedMapper;
import com.abdelhakimrafik.radarservice.queries.mappers.RadarMapper;
import com.abdelhakimrafik.radarservice.queries.repositories.OverSpeedRepository;
import com.abdelhakimrafik.radarservice.queries.repositories.RadarRepository;
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

    @QueryHandler
    public List<RadarDTO> getAllRadars(RadarQuery.GetAll query) {
        return radarRepository.findAll().stream().map(radar -> radarMapper.radarToRadarDTO(radar)).collect(Collectors.toList());
    }

    @QueryHandler
    public RadarDTO getRadarById(RadarQuery.GetById query) {
        Radar radar = radarRepository.findById(query.getId()).get();
        return radarMapper.radarToRadarDTO(radar);
    }
}
