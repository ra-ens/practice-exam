package com.abdelhakimrafik.commonapi.dtos;

import com.abdelhakimrafik.commonapi.enums.RadarStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RadarDTO {
    private String id;
    private int maxSpeed;
    private double longitude;
    private double latitude;
    private RadarStatus radarStatus;
}
