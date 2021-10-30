package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.EntretienVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntretienVehiculeRepository extends JpaRepository<EntretienVehicule,Long> {
}
