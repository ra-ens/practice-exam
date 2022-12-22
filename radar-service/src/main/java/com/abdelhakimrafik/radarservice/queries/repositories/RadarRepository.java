package com.abdelhakimrafik.radarservice.queries.repositories;

import com.abdelhakimrafik.radarservice.queries.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
