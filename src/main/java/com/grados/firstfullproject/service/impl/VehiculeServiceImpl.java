package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Assurance;
import com.grados.firstfullproject.entities.Conducteur;
import com.grados.firstfullproject.entities.Vehicule;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.AssuranceRepository;
import com.grados.firstfullproject.repository.ConducteurRepository;
import com.grados.firstfullproject.repository.VehiculeRepository;
import com.grados.firstfullproject.service.VehiculeService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    private VehiculeRepository vehiculeRepository;

    private AssuranceRepository assuranceRepository;

    private ConducteurRepository conducteurRepository;


    public VehiculeServiceImpl(
            VehiculeRepository vehiculeRepository,
            AssuranceRepository assuranceRepository,
            ConducteurRepository conducteurRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.assuranceRepository = assuranceRepository;
        this.conducteurRepository = conducteurRepository;
    }

    @Override
    public Vehicule saveVehicule(Vehicule v, Long idAssurance,Long idConducteur) {

        Object assurance = assuranceRepository.findById(idAssurance).orElseThrow(()->
                new NotFound("Assurance","Id",idAssurance));
        Object conducteur = conducteurRepository.findById(idConducteur).orElseThrow(
                ()-> new NotFound("Conducteur","id",idConducteur)
        );
        System.out.println("conducteur = " + idConducteur);
        v.setAssurance( (Assurance) assurance);
        v.setConducteur((Conducteur) conducteur);
        return vehiculeRepository.save(v);
    }

    @Override
    public List<Vehicule> findAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","Id",id)
        );
    }

    @Override
    public Vehicule updateVehicule(Vehicule v, Long id) {


        Vehicule updatedVehicule = vehiculeRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","Id",id)
        );

        updatedVehicule.setAssurance(v.getAssurance());
        updatedVehicule.setDateAchat(v.getDateAchat());
        updatedVehicule.setMarque(v.getMarque());
        updatedVehicule.setPuissance(v.getPuissance());
        updatedVehicule.setModel(v.getModel());

        vehiculeRepository.save(updatedVehicule);

        return updatedVehicule;

    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.findById(id).orElseThrow(()->new NotFound("Vehicule","ID",id));
        vehiculeRepository.deleteById(id);
    }

}
