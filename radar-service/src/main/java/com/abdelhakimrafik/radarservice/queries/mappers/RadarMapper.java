package com.abdelhakimrafik.radarservice.queries.mappers;

import com.abdelhakimrafik.commonapi.dtos.radar.RadarDTO;
import com.abdelhakimrafik.radarservice.queries.entities.Radar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RadarMapper {
    RadarDTO radarToRadarDTO(Radar radar);
}
