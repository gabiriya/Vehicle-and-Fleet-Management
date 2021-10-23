package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Assurance;
import com.grados.firstfullproject.exception.AssuranceNotFound;
import com.grados.firstfullproject.repository.AssuranceRepository;
import com.grados.firstfullproject.service.AssuranceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    private AssuranceRepository assuranceRepository;

    @Override
    public Assurance saveAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    @Override
    public List<Assurance> findAllAssurances() {
        return assuranceRepository.findAll();
    }

    @Override
    public Assurance getAssuranceById(long id) {
        Assurance assurance = assuranceRepository.findById(id).orElseThrow(
                ()-> new AssuranceNotFound("ID",id)
        );
        return assurance;
    }

    @Override
    public Assurance updateAssurance(Assurance assurance, long id) {
        Assurance updatedAssurance =  assuranceRepository.findById(id).orElseThrow(
                ()-> new AssuranceNotFound("ID",id)
        );

        updatedAssurance.setNom(assurance.getNom());
        updatedAssurance.setDateAssurance(assurance.getDateAssurance());
        updatedAssurance.setDateExpiration(assurance.getDateExpiration());

        return assurance;
    }

    @Override
    public void deleteAssurance(long id) {
        assuranceRepository.findById(id).orElseThrow(
                ()-> new AssuranceNotFound("ID",id)
        );
        assuranceRepository.deleteById(id);
    }
}
