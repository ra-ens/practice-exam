package com.abdelhakimrafik.violationservice.commands.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
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
