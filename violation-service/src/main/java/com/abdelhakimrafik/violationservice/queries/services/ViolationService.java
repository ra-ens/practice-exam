package com.abdelhakimrafik.violationservice.queries.services;

import com.abdelhakimrafik.commonapi.dtos.ViolationDTO;
import com.abdelhakimrafik.commonapi.queries.ViolationQuery;
import com.abdelhakimrafik.violationservice.queries.mappers.ViolationMapper;
import com.abdelhakimrafik.violationservice.queries.repositories.ViolationRepository;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ViolationService {

    private ViolationRepository violationRepository;
    private ViolationMapper violationMapper;

    @QueryHandler
    public Page<ViolationDTO> getAllViolations(ViolationQuery.GetAll query) {
        return violationRepository.findAll(PageRequest.of(query.getPage(), query.getSize()))
                .map(violation -> violationMapper.violationToViolationDTO(violation));
    }

    @QueryHandler
    public Page<ViolationDTO> getByMatriculation(ViolationQuery.GetByMatriculation query) {
        return violationRepository.findAllByVehicleMatriculation(query.getMatriculation(), PageRequest.of(query.getPage(), query.getSize()))
                .map(violation -> violationMapper.violationToViolationDTO(violation));
    }
}
