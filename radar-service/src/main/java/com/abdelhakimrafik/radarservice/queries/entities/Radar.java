package com.abdelhakimrafik.radarservice.queries.entities;

import com.abdelhakimrafik.commonapi.enums.RadarStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private int maxSpeed;
    private double longitude;
    private double latitude;
    private RadarStatus status;

    @OneToMany(mappedBy = "radar")
    private List<OverSpeed> overSpeedList;
}
