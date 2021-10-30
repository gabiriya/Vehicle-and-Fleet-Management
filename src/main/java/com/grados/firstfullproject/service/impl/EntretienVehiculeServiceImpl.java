package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.EntretienVehicule;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.EntretienVehiculeRepository;
import com.grados.firstfullproject.service.EntretienVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntretienVehiculeServiceImpl implements EntretienVehiculeService {

    private EntretienVehiculeRepository vehiculeRepository;
    @Autowired

    public EntretienVehiculeServiceImpl(EntretienVehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public EntretienVehicule saveEntretienVehicule(EntretienVehicule c) {
        return vehiculeRepository.save(c);
    }

    @Override
    public List<EntretienVehicule> findAllEntretienVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public EntretienVehicule getEntretienVehiculeById(Long id) {
        return vehiculeRepository.getById(id);
    }

    @Override
    public EntretienVehicule updateEntretienVehicule(EntretienVehicule c, Long id) {
        EntretienVehicule updatedEV = vehiculeRepository.findById(id).
                orElseThrow(
                        ()-> new NotFound("EntetienVehicule","ID",id)
                );


        if(c.getDateEntretien() != null)
            updatedEV.setDateEntretien(c.getDateEntretien());
        if(c.getKmVehicule() != 0)
            updatedEV.setKmVehicule(c.getKmVehicule());

        vehiculeRepository.save(updatedEV);
        return updatedEV;
    }

    @Override
    public void deleteEntretienVehicule(Long id) {
        vehiculeRepository.findById(id).orElseThrow(()->new NotFound("Entretien Vehicule","ID",id));
        vehiculeRepository.deleteById(id);
    }
}
