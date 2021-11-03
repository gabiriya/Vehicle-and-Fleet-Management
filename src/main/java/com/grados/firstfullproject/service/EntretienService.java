package com.grados.firstfullproject.service;

import com.grados.firstfullproject.entities.Entretien;

import java.util.List;

public interface EntretienService {
    Entretien saveEntretien(Entretien entretien);
    List<Entretien> findAllEntretien();
    Entretien getEntretienById(Long id);
    Entretien updateEntretien(Entretien entretien,Long id);
    void deleteEntretien(Long id);
}
