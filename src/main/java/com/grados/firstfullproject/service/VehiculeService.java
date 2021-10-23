package com.grados.firstfullproject.service;


import com.grados.firstfullproject.entities.Vehicule;

import java.util.List;

public interface VehiculeService {

    Vehicule saveVehicule(Vehicule v);
    List<Vehicule> findAllVehicules();
    Vehicule getVehiculeById(long id);
    Vehicule updateVehicule(Vehicule v,long id);
    void deleteVehicule(long id);
}
