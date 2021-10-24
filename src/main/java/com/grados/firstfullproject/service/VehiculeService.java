package com.grados.firstfullproject.service;


import com.grados.firstfullproject.entities.Vehicule;

import java.util.List;

public interface VehiculeService {

    Vehicule saveVehicule(Vehicule v,Long id);
    List<Vehicule> findAllVehicules();
    Vehicule getVehiculeById(Long id);
    Vehicule updateVehicule(Vehicule v,Long id);
    void deleteVehicule(Long id);
}
