package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
