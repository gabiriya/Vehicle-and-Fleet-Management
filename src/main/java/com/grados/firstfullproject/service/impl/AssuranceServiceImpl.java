package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Assurance;
import com.grados.firstfullproject.entities.Vehicule;
import com.grados.firstfullproject.exception.AssuranceNotFound;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.AssuranceRepository;
import com.grados.firstfullproject.repository.VehiculeRepository;
import com.grados.firstfullproject.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    private final AssuranceRepository assuranceRepository;
    private final VehiculeRepository vehiculeRepository;

    public AssuranceServiceImpl(AssuranceRepository assuranceRepository, VehiculeRepository vehiculeRepository) {
        this.assuranceRepository = assuranceRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Assurance saveAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    @Override
    public List<Assurance> findAllAssurances() {
        return assuranceRepository.findAll();
    }

    @Override
    public Assurance getAssuranceById(Long id) {
        Assurance assurance = assuranceRepository.findById(id).orElseThrow(
                ()-> new AssuranceNotFound("ID",id)
        );
        return assurance;
    }

    @Override
    public Assurance updateAssurance(Assurance assurance, Long id) {
        Long idv = assurance.getVehicule().getId();
        Vehicule vehicule = vehiculeRepository.findById(idv).orElseThrow(
                ()-> new NotFound("Vehicule","ID",idv)
        );
        Assurance updatedAssurance =  assuranceRepository.findById(id).orElseThrow(
                ()-> new AssuranceNotFound("ID",id)
        );

        updatedAssurance.setVehicule(vehicule);
        // check if empty
        if(assurance.getNom() != null)
            updatedAssurance.setNom(assurance.getNom());
        if(assurance.getDateAssurance() != null)
            updatedAssurance.setDateAssurance(assurance.getDateAssurance());
        if(assurance.getDateExpiration() != null)
            updatedAssurance.setDateExpiration(assurance.getDateExpiration());

        assuranceRepository.save(updatedAssurance);
        return updatedAssurance;
    }

    @Override
    public void deleteAssurance(Long id) {
        assuranceRepository.findById(id).orElseThrow(
                ()-> new AssuranceNotFound("ID",id)
        );
        assuranceRepository.deleteById(id);
    }
}
