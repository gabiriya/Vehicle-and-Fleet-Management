package com.grados.firstfullproject.service;


import com.grados.firstfullproject.DTO.VehicleDTO;
import com.grados.firstfullproject.entities.Vehicle;

import java.util.List;

public interface VehicleService {

    VehicleDTO saveVehicle(Long idDriver,VehicleDTO vehicleDTO );
    List<VehicleDTO> findAllVehicles(Long idDriver);
    VehicleDTO getVehiculeById(Long idDriver, Long idVehicle);
    VehicleDTO updateVehicle( Long idDriver,VehicleDTO vDto,Long idVehicle);
    void deleteVehicle(Long idDriver,Long idVehicle);
//    List<CarDriversDTO> getAllCarDriver();
//    CarDriversDTO carDriverEntityToDTO(Vehicule vehicule);
}
