package com.abdelhakimrafik.matriculationservice.queries.mappers;

import com.abdelhakimrafik.commonapi.dtos.radar.VehicleDTO;
import com.abdelhakimrafik.matriculationservice.queries.entities.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    VehicleDTO vehicleToVehicleDTO(Vehicle vehicle);
}
