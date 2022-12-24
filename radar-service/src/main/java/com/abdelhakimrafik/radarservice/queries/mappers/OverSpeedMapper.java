package com.abdelhakimrafik.radarservice.queries.mappers;

import com.abdelhakimrafik.commonapi.dtos.radar.OverSpeedDTO;
import com.abdelhakimrafik.radarservice.queries.entities.OverSpeed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OverSpeedMapper {
    OverSpeedDTO overSpeedToOverSpeedDTO(OverSpeed overSpeed);
}
