package com.abdelhakimrafik.radarservice.queries.controllers;

import com.abdelhakimrafik.commonapi.dtos.RadarDTO;
import com.abdelhakimrafik.commonapi.queries.radar.GetRadarRequest;
import com.abdelhakimrafik.commonapi.queries.radar.GetRadarsRequest;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/query")
public class RadarQueryController {

    private QueryGateway gateway;

    @GetMapping
    public CompletableFuture<List<RadarDTO>> getRadarList() {
        return gateway.query(new GetRadarsRequest(), ResponseTypes.multipleInstancesOf(RadarDTO.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<RadarDTO> getRadarById(@PathVariable String id) {
        return gateway.query(new GetRadarRequest(id), ResponseTypes.instanceOf(RadarDTO.class));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
