package com.abdelhakimrafik.violationservice.commands.repositories;

import com.abdelhakimrafik.violationservice.commands.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
