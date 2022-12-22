package com.abdelhakimrafik.radarservice.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private int maxSpeed;
    private double longitude;
    private double latitude;
}
