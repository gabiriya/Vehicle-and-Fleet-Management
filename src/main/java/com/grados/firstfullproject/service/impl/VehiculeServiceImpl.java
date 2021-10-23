package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Vehicule;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.VehiculeRepository;
import com.grados.firstfullproject.service.VehiculeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Vehicule saveVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public List<Vehicule> findAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule getVehiculeById(long id) {
        return vehiculeRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","Id",id)
        );
    }

    @Override
    public Vehicule updateVehicule(Vehicule v, long id) {
        return null;
    }

    @Override
    public void deleteVehicule(long id) {

    }
}
