package com.grados.firstfullproject.service;

import com.grados.firstfullproject.entities.Conducteur;

import java.util.List;

public interface ConducteurService {

    Conducteur saveConducteur(Conducteur c);
    List<Conducteur> findAllConducteurs();
    Conducteur getConducteurById(long id);
    Conducteur updateConducteur(Conducteur c,long id);
    void deleteConducteur(long id);
}
