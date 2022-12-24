package com.abdelhakimrafik.matriculationservice.queries.repositories;

import com.abdelhakimrafik.matriculationservice.queries.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
