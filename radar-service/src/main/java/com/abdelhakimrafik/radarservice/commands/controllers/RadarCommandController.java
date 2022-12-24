package com.abdelhakimrafik.radarservice.commands.controllers;

import com.abdelhakimrafik.commonapi.exceptions.RequestException;
import com.abdelhakimrafik.commonapi.queries.RadarQuery;
import com.abdelhakimrafik.radarservice.commands.services.RadarCommandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
@RequestMapping("/cmd")
@AllArgsConstructor
public class RadarCommandController {
    private RadarCommandService radarService;

    @PostMapping
    public CompletableFuture<String> createRadar(@RequestBody RadarQuery.CreateRadar query) {
        return this.radarService.createRadar(query);
    }

    @PutMapping
    public CompletableFuture<String> updateRadar(@RequestBody RadarQuery.UpdateRadar query) {
        return this.radarService.updateRadar(query);
    }

    @PutMapping("/status")
    public CompletableFuture<String> updateRadarStatus(@RequestBody RadarQuery.UpdateRadarStatus query) {
        return this.radarService.updateRadarStatus(query);
    }

    @DeleteMapping
    public CompletableFuture<String> deleteRadar(@RequestBody RadarQuery.DeleteRadar query) {
        return this.radarService.deleteRadar(query);
    }

    @PostMapping("/overSpeed")
    public CompletableFuture<String> newOverSpeed(@RequestBody RadarQuery.OverSpeedDetected query){
        return this.radarService.overSpeed(query);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<String> requestExceptionHandler(RequestException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
