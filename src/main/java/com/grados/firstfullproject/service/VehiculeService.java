package com.grados.firstfullproject.service;


import com.grados.firstfullproject.DTO.CarDriversDTO;
import com.grados.firstfullproject.entities.Vehicule;

import java.util.List;

public interface VehiculeService {

    Vehicule saveVehicule(Vehicule v,Long idAssurance,Long idConducteur);
    List<Vehicule> findAllVehicules();
    Vehicule getVehiculeById(Long id);
    Vehicule updateVehicule(Vehicule v,Long id);
    void deleteVehicule(Long id);
    List<CarDriversDTO> getllCarDriver();
    CarDriversDTO carDriverEntityToDTO(Vehicule vehicule);
}
