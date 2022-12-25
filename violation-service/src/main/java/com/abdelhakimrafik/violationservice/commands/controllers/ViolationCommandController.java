package com.abdelhakimrafik.violationservice.commands.controllers;

import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin("*")
@RequestMapping("/cmd")
@AllArgsConstructor
public class ViolationCommandController {

    private EventStore eventStore;

    @GetMapping("/events/{violationId}")
    public Stream overSpeedEvent(@PathVariable String violationId) {
        return eventStore.readEvents(violationId).asStream();
    }
}
