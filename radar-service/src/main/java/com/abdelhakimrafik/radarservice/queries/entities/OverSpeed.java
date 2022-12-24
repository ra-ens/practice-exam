package com.abdelhakimrafik.radarservice.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class OverSpeed {
    @Id
    private String id;
    private Instant timeStamp;
    private String vehicleMatriculation;
    private int speed;

    @ManyToOne
    private Radar radar;
}
