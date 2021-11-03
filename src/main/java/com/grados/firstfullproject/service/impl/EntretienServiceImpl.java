package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Entretien;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.EntretienRepository;
import com.grados.firstfullproject.service.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntretienServiceImpl implements EntretienService {

    private EntretienRepository entretienRepository;
    @Autowired
    public EntretienServiceImpl(EntretienRepository entretienRepository) {
        this.entretienRepository = entretienRepository;
    }

    @Override
    public Entretien saveEntretien(Entretien entretien) {
        return entretienRepository.save(entretien);
    }

    @Override
    public List<Entretien> findAllEntretien() {
        return entretienRepository.findAll();
    }

    @Override
    public Entretien getEntretienById(Long id) {
        return entretienRepository.getById(id);
    }

    @Override
    public Entretien updateEntretien(Entretien entretien, Long id) {
        Entretien updatedEntretien = entretienRepository.findById(id).orElseThrow(
                ()-> new NotFound("Entretien","id",id)
        );
        if(entretien.getNomEntretien() != null)
            updatedEntretien.setNomEntretien(entretien.getNomEntretien());
        if(entretien.getMontant() != 0)
            updatedEntretien.setMontant(entretien.getMontant());

        return updatedEntretien;
    }

    @Override
    public void deleteEntretien(Long id) {
        entretienRepository.deleteById(id);
    }
}
