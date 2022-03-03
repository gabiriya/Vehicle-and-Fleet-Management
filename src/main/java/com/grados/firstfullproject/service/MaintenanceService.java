package com.grados.firstfullproject.service;

import com.grados.firstfullproject.entities.Maintenance;

import java.util.List;

public interface MaintenanceService {
    Maintenance saveMaintenance(Maintenance entretien);
    List<Maintenance> findAllMaintenance();
    Maintenance getMaintenanceById(Long id);
    Maintenance updateMaintenance(Maintenance entretien,Long id);
    void deleteMaintenance(Long id);
}
