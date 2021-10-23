package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Conducteur;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.ConducteurRepository;
import com.grados.firstfullproject.service.ConducteurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConducteurServiceImpl implements ConducteurService {

    private ConducteurRepository conducteurRepository;

    public ConducteurServiceImpl(ConducteurRepository conducteurRepository) {
        this.conducteurRepository = conducteurRepository;
    }

    @Override
    public Conducteur saveConducteur(Conducteur c) {
        return conducteurRepository.save(c);
    }

    @Override
    public List<Conducteur> findAllConducteurs() {
        return conducteurRepository.findAll();
    }

    @Override
    public Conducteur getConducteurById(long id) {
        Conducteur conducteur = conducteurRepository.findById(id).orElseThrow(()->
                new NotFound("Conducteur","Id",id));
        return conducteur;
    }

    @Override
    public Conducteur updateConducteur(Conducteur c, long id) {
        Conducteur updatedConducteur  = conducteurRepository.findById(id).orElseThrow(
                ()-> new NotFound("Conducteur","Id",id));

        updatedConducteur.setDateNaissance(c.getDateNaissance());
        updatedConducteur.setNom(c.getNom());
        updatedConducteur.setPrenom(c.getPrenom());
        return updatedConducteur;

    }

    @Override
    public void deleteConducteur(long id) {
        conducteurRepository.findById(id).orElseThrow(
                ()-> new NotFound("Conducteur","Id",id));
        conducteurRepository.deleteById(id);
    }
}
