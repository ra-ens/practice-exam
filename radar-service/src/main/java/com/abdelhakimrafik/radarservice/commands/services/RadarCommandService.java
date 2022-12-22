package com.abdelhakimrafik.radarservice.commands.services;

import com.abdelhakimrafik.commonapi.commands.radar.CreateRadarCommand;
import com.abdelhakimrafik.commonapi.commands.radar.DeleteRadarCommand;
import com.abdelhakimrafik.commonapi.commands.radar.UpdateRadarCommand;
import com.abdelhakimrafik.commonapi.queries.radar.CreateRadarRequest;
import com.abdelhakimrafik.commonapi.queries.radar.DeleteRadarRequest;
import com.abdelhakimrafik.commonapi.queries.radar.UpdateRadarRequest;
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
    public CompletableFuture<String> createRadar(CreateRadarRequest request) {
        return gateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                request.getMaxSpeed(),
                request.getLongitude(),
                request.getLatitude()
        ));
    }

    @Override
    public CompletableFuture<String> updateRadar(UpdateRadarRequest request) {
        return gateway.send(new UpdateRadarCommand(
                request.getId(),
                request.getMaxSpeed(),
                request.getLongitude(),
                request.getLatitude()
        ));
    }

    @Override
    public CompletableFuture<String> deleteRadar(DeleteRadarRequest request) {
        return gateway.send(new DeleteRadarCommand(request.getId()));
    }
}
