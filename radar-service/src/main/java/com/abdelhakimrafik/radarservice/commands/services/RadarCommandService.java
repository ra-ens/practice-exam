package com.abdelhakimrafik.radarservice.commands.services;

import com.abdelhakimrafik.commonapi.commands.RadarCommand;
import com.abdelhakimrafik.commonapi.queries.RadarQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class RadarCommandService implements IRadarCommandService {
    @Autowired
    private CommandGateway gateway;

    @Override
    public CompletableFuture<String> createRadar(RadarQuery.CreateRadar query) {
        return gateway.send(new RadarCommand.CreateRadar(
                UUID.randomUUID().toString(),
                query.getMaxSpeed(),
                query.getLongitude(),
                query.getLatitude(),
                query.getStatus()
        ));
    }

    @Override
    public CompletableFuture<String> updateRadar(RadarQuery.UpdateRadar query) {
        return gateway.send(new RadarCommand.UpdateRadar(
                query.getId(),
                query.getMaxSpeed(),
                query.getLongitude(),
                query.getLatitude(),
                query.getStatus()
        ));
    }

    @Override
    public CompletableFuture<String> updateRadarStatus(RadarQuery.UpdateRadarStatus query) {
        return gateway.send(new RadarCommand.UpdateRadarStatus(query.getId(), query.getStatus()));
    }

    @Override
    public CompletableFuture<String> deleteRadar(RadarQuery.DeleteRadar query) {
        return gateway.send(new RadarCommand.DeleteRadar(query.getId()));
    }

    @Override
    public CompletableFuture<String> overSpeed(RadarQuery.OverSpeedDetected query) {
        return gateway.send(new RadarCommand.OverSpeedDetected(
                query.getRadar(),
                query.getVehicleMatriculation(),
                query.getSpeed()
        ));
    }
}
