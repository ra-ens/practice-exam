package com.abdelhakimrafik.violationservice.queries.repositories;

import com.abdelhakimrafik.violationservice.queries.entities.Violation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ViolationRepository extends JpaRepository<Violation, String> {
    Page<Violation> findAllByVehicleMatriculation(String matriculation, Pageable pageable);
}
