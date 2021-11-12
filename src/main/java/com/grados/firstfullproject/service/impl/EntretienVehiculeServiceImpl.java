package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.EntretienVehicule;
import com.grados.firstfullproject.entities.Vehicule;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.EntretienVehiculeRepository;
import com.grados.firstfullproject.repository.VehiculeRepository;
import com.grados.firstfullproject.service.EntretienVehiculeService;
import com.grados.firstfullproject.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntretienVehiculeServiceImpl implements EntretienVehiculeService {

    private EntretienVehiculeRepository entretienVehiculeRepository;
    private VehiculeRepository vehiculeRepository;

    public EntretienVehiculeServiceImpl(EntretienVehiculeRepository entretienVehiculeRepository, VehiculeRepository vehiculeRepository) {
        this.entretienVehiculeRepository = entretienVehiculeRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public EntretienVehicule saveEntretienVehicule(EntretienVehicule entretienVehicule, Long id) {
        Object vehicule = entretienVehiculeRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","ID",id)
        );
        entretienVehicule.setVehicule((Vehicule) vehicule);
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

        if(ev.getDateEntretien() != null)
            updatedEV.setDateEntretien(ev.getDateEntretien());
        if(ev.getKmVehicule() != 0)
            updatedEV.setKmVehicule(ev.getKmVehicule());
        if(ev.getVehicule().getId() != 0){
            Vehicule v = vehiculeRepository.findById(ev.getVehicule().getId()).orElseThrow(
                    ()-> new NotFound("Vehicule","id",ev.getVehicule().getId()));
            updatedEV.setVehicule(v);
        }

        entretienVehiculeRepository.save(updatedEV);
        return updatedEV;
    }

    @Override
    public void deleteEntretienVehicule(Long id) {
        entretienVehiculeRepository.findById(id).orElseThrow(
                ()-> new NotFound("Entretien Vehicule","ID",id));
        entretienVehiculeRepository.deleteById(id);
    }
}
