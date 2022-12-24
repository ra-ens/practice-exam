package com.abdelhakimrafik.matriculationservice.queries.services;

import com.abdelhakimrafik.commonapi.dtos.radar.OwnerDTO;
import com.abdelhakimrafik.commonapi.dtos.radar.VehicleDTO;
import com.abdelhakimrafik.commonapi.queries.MatriculationQuery;
import com.abdelhakimrafik.matriculationservice.queries.mappers.OwnerMapper;
import com.abdelhakimrafik.matriculationservice.queries.mappers.VehicleMapper;
import com.abdelhakimrafik.matriculationservice.queries.repositories.OwnerRepository;
import com.abdelhakimrafik.matriculationservice.queries.repositories.VehicleRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MatriculationQueryService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private OwnerMapper ownerMapper;

    @QueryHandler
    public List<VehicleDTO> getVehicleList(MatriculationQuery.GetAllVehicles query) {
        return vehicleRepository.findAll().stream().map(vehicle -> vehicleMapper.vehicleToVehicleDTO(vehicle)).collect(Collectors.toList());
    }

    @QueryHandler
    public List<OwnerDTO> getOwnerList(MatriculationQuery.GetAllOwners query) {
        return ownerRepository.findAll().stream().map(owner -> ownerMapper.ownerToOwnerDTO(owner)).collect(Collectors.toList());
    }
}
