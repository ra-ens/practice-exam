package com.abdelhakimrafik.matriculationservice.queries.repositories;

import com.abdelhakimrafik.matriculationservice.queries.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
