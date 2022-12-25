package com.abdelhakimrafik.violationservice.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Violation {
    @Id
    private String id;
    private String radarId;
    private String vehicleId;
    private String vehicleMatriculation;
    private Date date;
    private int speed;
    private int maxSpeed;
    private double amount;
}
