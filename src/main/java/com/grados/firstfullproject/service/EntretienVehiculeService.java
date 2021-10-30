package com.grados.firstfullproject.service;

import com.grados.firstfullproject.entities.Conducteur;
import com.grados.firstfullproject.entities.EntretienVehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntretienVehiculeService  {
    EntretienVehicule saveEntretienVehicule(EntretienVehicule c);
    List<EntretienVehicule> findAllEntretienVehicule();
    EntretienVehicule getEntretienVehiculeById(Long id);
    EntretienVehicule updateEntretienVehicule(EntretienVehicule c,Long id);
    void deleteEntretienVehicule(Long id);
}
