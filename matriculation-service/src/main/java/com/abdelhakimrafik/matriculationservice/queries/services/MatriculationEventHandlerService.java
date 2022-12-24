package com.abdelhakimrafik.matriculationservice.queries.services;

import com.abdelhakimrafik.commonapi.events.MatriculationEvent;
import com.abdelhakimrafik.matriculationservice.queries.entities.Owner;
import com.abdelhakimrafik.matriculationservice.queries.entities.Vehicle;
import com.abdelhakimrafik.matriculationservice.queries.repositories.OwnerRepository;
import com.abdelhakimrafik.matriculationservice.queries.repositories.VehicleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class MatriculationEventHandlerService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @EventHandler
    public void onVehicleCreated(MatriculationEvent.VehicleCreated event) {
        Owner owner = ownerRepository.findById(event.getOwner()).orElseThrow(() -> new RuntimeException("Owner not found"));
        Vehicle vehicle = Vehicle.builder()
                .id(event.getId())
                .owner(owner)
                .matriculation(event.getMatriculation())
                .mark(event.getMark())
                .model(event.getModel())
                .fiscalPower(event.getFiscalPower())
                .build();
        vehicleRepository.save(vehicle);
    }

    @EventHandler
    public void onOwnerAdded(MatriculationEvent.OwnerAdded event) {
        Owner owner = Owner.builder()
                .id(event.getId())
                .name(event.getName())
                .birthday(event.getBirthday())
                .email(event.getEmail())
                .build();
        ownerRepository.save(owner);
    }
}
