package com.abdelhakimrafik.radarservice.commands.services;

import com.abdelhakimrafik.commonapi.queries.radar.CreateRadarRequest;
import com.abdelhakimrafik.commonapi.queries.radar.DeleteRadarRequest;
import com.abdelhakimrafik.commonapi.queries.radar.UpdateRadarRequest;

import java.util.concurrent.CompletableFuture;

public interface IRadarCommandService {

    CompletableFuture<String> createRadar(CreateRadarRequest request);
    CompletableFuture<String> updateRadar(UpdateRadarRequest request);
    CompletableFuture<String> deleteRadar(DeleteRadarRequest request);
}
