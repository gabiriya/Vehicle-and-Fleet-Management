package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.EntretienVehicule;
import com.grados.firstfullproject.entities.Vehicle;
import com.grados.firstfullproject.entities.Vehicle;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.EntretienVehiculeRepository;
import com.grados.firstfullproject.repository.VehicleRepository;
import com.grados.firstfullproject.service.EntretienVehiculeService;
import com.grados.firstfullproject.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntretienVehiculeServiceImpl implements EntretienVehiculeService {

    private EntretienVehiculeRepository entretienVehiculeRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public EntretienVehiculeServiceImpl(EntretienVehiculeRepository entretienVehiculeRepository, VehicleRepository vehicleRepository) {
        this.entretienVehiculeRepository = entretienVehiculeRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public EntretienVehicule saveEntretienVehicule(EntretienVehicule entretienVehicule, Long id) {
        Object vehicule = entretienVehiculeRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","ID",id)
        );
//        entretienVehicule.setVehicle((Vehicle) vehicule);
        return entretienVehiculeRepository.save(entretienVehicule);
    }

    @Override
    public List<EntretienVehicule> findAllEntretienVehicule() {
        return entretienVehiculeRepository.findAll();
    }

    @Override
    public EntretienVehicule getEntretienVehiculeById(Long id) {
        return entretienVehiculeRepository.findById(id).orElseThrow(
                ()-> new NotFound("Entretien de vehicule","id",id)
        );
    }

    @Override
    public EntretienVehicule updateEntretienVehicule(EntretienVehicule ev, Long id) {

        EntretienVehicule updatedEV = entretienVehiculeRepository.findById(id).
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

        entretienVehiculeRepository.save(updatedEV);
        return updatedEV;
    }

    @Override
    public void deleteEntretienVehicule(Long id) {
        entretienVehiculeRepository.findById(id).orElseThrow(
                ()->new NotFound("Entretien Vehicule","ID",id));
        entretienVehiculeRepository.deleteById(id);
    }
}
