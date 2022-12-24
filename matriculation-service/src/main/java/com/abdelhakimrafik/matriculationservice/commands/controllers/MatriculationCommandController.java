package com.abdelhakimrafik.matriculationservice.commands.controllers;

import com.abdelhakimrafik.commonapi.queries.MatriculationQuery;
import com.abdelhakimrafik.matriculationservice.commands.services.MatriculationCommandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
@RequestMapping("/cmd")
@AllArgsConstructor
public class MatriculationCommandController {

    private MatriculationCommandService matriculationCommandService;

    @PostMapping("vehicle")
    public CompletableFuture<String> createVehicle(@RequestBody MatriculationQuery.CreateVehicle query) {
        return matriculationCommandService.createVehicle(query);
    }

    @PostMapping("owner")
    public CompletableFuture<String> newOwner(@RequestBody MatriculationQuery.NewOwner query) {
        return matriculationCommandService.newOwner(query);
    }
}
