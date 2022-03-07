package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.MaintenanceVehicle;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.MaintenanceVehicleRepository;
import com.grados.firstfullproject.repository.VehicleRepository;
import com.grados.firstfullproject.service.MaintenanceVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceVehicleServiceImpl implements MaintenanceVehicleService {

    private final MaintenanceVehicleRepository maintenanceVehicleRepository;

    @Autowired
    public MaintenanceVehicleServiceImpl(MaintenanceVehicleRepository maintenanceVehicleRepository) {
        this.maintenanceVehicleRepository = maintenanceVehicleRepository;
    }

    @Override
    public MaintenanceVehicle saveMaintenanceVehicle(MaintenanceVehicle entretienVehicule, Long id) {
        maintenanceVehicleRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","ID",id)
        );
//        entretienVehicule.setVehicle((Vehicle) vehicule);
        return maintenanceVehicleRepository.save(entretienVehicule);
    }

    @Override
    public List<MaintenanceVehicle> findAllMaintenanceVehicle() {
        return maintenanceVehicleRepository.findAll();
    }

    @Override
    public MaintenanceVehicle getMaintenanceVehicleById(Long id) {
        return maintenanceVehicleRepository.findById(id).orElseThrow(
                ()-> new NotFound("Entretien de vehicule","id",id)
        );
    }

    @Override
    public MaintenanceVehicle updateMaintenanceVehicle(MaintenanceVehicle ev, Long id) {

        MaintenanceVehicle updatedEV = maintenanceVehicleRepository.findById(id).
                orElseThrow(
                        ()-> new NotFound("EntetienVehicule","ID",id)
                );

//        if(ev.getDateEntretien() != null)
//            updatedEV.setDateEntretien(ev.getDateEntretien());
//        if(ev.getKmVehicule() != 0)
//            updatedEV.setKmVehicule(ev.getKmVehicule());
//        if(ev.getVehicule().getId() != 0){
//            Vehicle v = vehicleRepository.findById(ev.getVehicule().getId()).orElseThrow(
//                    ()-> new NotFound("Vehicule","id",ev.getVehicule().getId()));
//            updatedEV.setVehicule(v);
//        }

        maintenanceVehicleRepository.save(updatedEV);
        return updatedEV;
    }

    @Override
    public void deleteMaintenanceVehicle(Long id) {
        maintenanceVehicleRepository.findById(id).orElseThrow(
                ()->new NotFound("Maintenance Vehicle","ID",id));
        maintenanceVehicleRepository.deleteById(id);
    }
}
