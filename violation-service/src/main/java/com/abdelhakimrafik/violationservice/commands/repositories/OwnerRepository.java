package com.abdelhakimrafik.violationservice.commands.repositories;

import com.abdelhakimrafik.violationservice.commands.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
