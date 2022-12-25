package com.abdelhakimrafik.violationservice.commands.services;

import com.abdelhakimrafik.commonapi.events.MatriculationEvent;
import com.abdelhakimrafik.commonapi.events.RadarEvent;
import com.abdelhakimrafik.violationservice.commands.repositories.OwnerRepository;
import com.abdelhakimrafik.violationservice.commands.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViolationCommandEventHandler {

    private CommandGateway commandGateway;
    private EventStore eventStore;
    private VehicleRepository vehicleRepository;
    private OwnerRepository ownerRepository;

//    @EventHandler
//    public void onOverSpeed(RadarEvent.OverSpeedDetected event) {
//        event.
//    }

    @EventHandler
    public void onVehicleCreated(MatriculationEvent.VehicleCreated event) {
        System.out.println(">>> new Vehicle created" + event.getMatriculation());
    }

}
