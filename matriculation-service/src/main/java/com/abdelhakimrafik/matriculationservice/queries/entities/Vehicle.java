package com.abdelhakimrafik.matriculationservice.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    private String matriculation;
    private String mark;
    private String model;
    private int fiscalPower;

    @ManyToOne
    private Owner owner;
}
