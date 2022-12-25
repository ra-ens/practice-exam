package com.abdelhakimrafik.matriculationservice.queries.mappers;

import com.abdelhakimrafik.commonapi.dtos.OwnerDTO;
import com.abdelhakimrafik.matriculationservice.queries.entities.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {
    OwnerDTO ownerToOwnerDTO(Owner owner);
}
