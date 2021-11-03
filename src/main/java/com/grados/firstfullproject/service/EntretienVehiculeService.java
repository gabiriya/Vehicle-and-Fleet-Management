package com.grados.firstfullproject.service;

import com.grados.firstfullproject.entities.EntretienVehicule;

import java.util.List;

public interface EntretienVehiculeService  {
    EntretienVehicule saveEntretienVehicule(EntretienVehicule entretienVehicule, Long id);
    List<EntretienVehicule> findAllEntretienVehicule();
    EntretienVehicule getEntretienVehiculeById(Long id);
    EntretienVehicule updateEntretienVehicule(EntretienVehicule c,Long id);
    void deleteEntretienVehicule(Long id);
}
