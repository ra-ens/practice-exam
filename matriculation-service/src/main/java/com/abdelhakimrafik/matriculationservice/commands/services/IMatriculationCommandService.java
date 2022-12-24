package com.abdelhakimrafik.matriculationservice.commands.services;

import com.abdelhakimrafik.commonapi.queries.MatriculationQuery;

import java.util.concurrent.CompletableFuture;

public interface IMatriculationCommandService {
    CompletableFuture<String> createVehicle(MatriculationQuery.CreateVehicle query);
    CompletableFuture<String> newOwner(MatriculationQuery.NewOwner query);
}
