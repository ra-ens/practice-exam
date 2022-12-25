package com.abdelhakimrafik.violationservice.queries.controllers;

import com.abdelhakimrafik.commonapi.queries.ViolationQuery;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin("*")
@RequestMapping("/query")
@AllArgsConstructor
public class ViolationController {

    private QueryGateway gateway;

    @GetMapping
    public CompletableFuture<Page> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return gateway.query(new ViolationQuery.GetAll(page, size), ResponseTypes.instanceOf(Page.class));
    }

    @GetMapping("/bymatriculation/{matriculation}")
    public CompletableFuture<Page> getByMatriculation(
            @PathVariable String matriculation,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        return gateway.query(new ViolationQuery.GetByMatriculation(page, size, matriculation), ResponseTypes.instanceOf(Page.class));
    }
}
