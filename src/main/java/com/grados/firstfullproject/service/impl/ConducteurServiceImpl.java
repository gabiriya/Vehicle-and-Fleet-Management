package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Conducteur;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.ConducteurRepository;
import com.grados.firstfullproject.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ConducteurServiceImpl implements ConducteurService {


    private ConducteurRepository conducteurRepository;
    @Autowired
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
    public Conducteur getConducteurById(Long id) {
        Conducteur conducteur = conducteurRepository.findById(id).orElseThrow(()->
                new NotFound("Conducteur","Id",id));
        return conducteur;
    }

    @Override
    public Conducteur updateConducteur(Conducteur c, Long id) {
        Conducteur updatedConducteur  = conducteurRepository.findById(id).orElseThrow(
                ()-> new NotFound("Conducteur","Id",id));

        // check if empty
        if(c.getNom() != null)
            updatedConducteur.setNom(c.getNom());
        if (c.getDateNaissance() != null)
            updatedConducteur.setDateNaissance(c.getDateNaissance());
        if (c.getPrenom() != null)
            updatedConducteur.setPrenom(c.getPrenom());

        conducteurRepository.save(updatedConducteur);
        return updatedConducteur;

    }

    @Override
    public void deleteConducteur(Long id) {
        conducteurRepository.findById(id).orElseThrow(
                ()-> new NotFound("Conducteur","Id",id));
        conducteurRepository.deleteById(id);
    }
}
