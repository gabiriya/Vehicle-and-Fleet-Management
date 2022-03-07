package com.grados.firstfullproject.service;

import com.grados.firstfullproject.entities.MaintenanceVehicle;

import java.util.List;

public interface MaintenanceVehicleService  {
    MaintenanceVehicle saveMaintenanceVehicle(MaintenanceVehicle entretienVehicule, Long id);
    List<MaintenanceVehicle> findAllMaintenanceVehicle();
    MaintenanceVehicle getMaintenanceVehicleById(Long id);
    MaintenanceVehicle updateMaintenanceVehicle(MaintenanceVehicle c,Long id);
    void deleteMaintenanceVehicle(Long id);
}
