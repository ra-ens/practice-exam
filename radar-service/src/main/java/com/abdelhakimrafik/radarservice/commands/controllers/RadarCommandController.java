package com.abdelhakimrafik.radarservice.commands.controllers;

import com.abdelhakimrafik.commonapi.exceptions.RequestException;
import com.abdelhakimrafik.commonapi.queries.radar.CreateRadarRequest;
import com.abdelhakimrafik.commonapi.queries.radar.DeleteRadarRequest;
import com.abdelhakimrafik.commonapi.queries.radar.UpdateRadarRequest;
import com.abdelhakimrafik.radarservice.commands.services.RadarCommandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/cmd")
public class RadarCommandController {
    private RadarCommandService radarService;

    @PostMapping
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequest request) {
        return this.radarService.createRadar(request);
    }

    @PutMapping
    public CompletableFuture<String> updateRadar(@RequestBody UpdateRadarRequest request) {
        return this.radarService.updateRadar(request);
    }

    @DeleteMapping
    public CompletableFuture<String> deleteRadar(@RequestBody DeleteRadarRequest request) {
        return this.radarService.deleteRadar(request);
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
