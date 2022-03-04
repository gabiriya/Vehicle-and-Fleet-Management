package com.grados.firstfullproject.service;


import com.grados.firstfullproject.entities.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle saveVehicle(Vehicle v,Long idDriver);
    List<Vehicle> findAllVehicles(Long idDriver);
    Vehicle getVehiculeById(Long idDriver, Long idVehicle);
    Vehicle updateVehicle( Long idDriver,Vehicle v,Long idVehicle);
    void deleteVehicle(Long idDriver,Long idVehicle);
//    List<CarDriversDTO> getAllCarDriver();
//    CarDriversDTO carDriverEntityToDTO(Vehicule vehicule);
}
