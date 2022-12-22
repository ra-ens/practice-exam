package com.abdelhakimrafik.radarservice.commands.aggregates;

import com.abdelhakimrafik.commonapi.commands.radar.CreateRadarCommand;
import com.abdelhakimrafik.commonapi.events.radar.RadarCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class RadarAggregate {
    @AggregateIdentifier
    private String radarId;
    private int maxSpeed;
    private double longitude;
    private double latitude;

    public RadarAggregate() {} // required by Axon


    @CommandHandler
    public RadarAggregate(CreateRadarCommand command) {
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getMaxSpeed(),
                command.getLongitude(),
                command.getLatitude()
        ));

        System.out.println(">>> CMD" + command.getId());
    }

    @EventSourcingHandler
    public void onCreateRadar(RadarCreatedEvent event) {
        this.radarId = event.getId();
        this.maxSpeed = event.getMaxSpeed();
        this.longitude = event.getLongitude();
        this.latitude = event.getLatitude();

        System.out.println(">>> EVENT CMD" + event.getId());
    }

}
