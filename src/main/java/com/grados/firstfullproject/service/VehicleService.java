package com.grados.firstfullproject.service;


import com.grados.firstfullproject.entities.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle saveVehicle(Vehicle v,Long idConducteur);
    List<Vehicle> findAllVehicles();
    Vehicle getVehiculeById(Long id);
    Vehicle updateVehicle(Vehicle v,Long id);
    void deleteVehicle(Long id);
//    List<CarDriversDTO> getAllCarDriver();
//    CarDriversDTO carDriverEntityToDTO(Vehicule vehicule);
}
