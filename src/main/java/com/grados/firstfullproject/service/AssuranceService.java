package com.grados.firstfullproject.service;

import com.grados.firstfullproject.entities.Assurance;

import java.util.List;

public interface AssuranceService {

    Assurance saveAssurance(Assurance assurance);
    List<Assurance> findAllAssurances();
    Assurance getAssuranceById(Long id);
    Assurance updateAssurance(Assurance assurance,Long id);
    void deleteAssurance(Long id);
}
