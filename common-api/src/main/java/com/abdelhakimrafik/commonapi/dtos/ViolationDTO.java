package com.abdelhakimrafik.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class ViolationDTO {
    private String id;
    private String radar;
    private String vehicle;
    private Date date;
    private int speed;
    private int maxSpeed;
    private double amount;
}
