package com.abdelhakimrafik.violationservice.queries.mappers;

import com.abdelhakimrafik.commonapi.dtos.ViolationDTO;
import com.abdelhakimrafik.violationservice.queries.entities.Violation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ViolationMapper {
    ViolationDTO violationToViolationDTO(Violation violation);
}
