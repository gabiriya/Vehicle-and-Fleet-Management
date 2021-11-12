package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.DTO.CarDriversDTO;
import com.grados.firstfullproject.entities.Assurance;
import com.grados.firstfullproject.entities.Conducteur;
import com.grados.firstfullproject.entities.Vehicule;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.AssuranceRepository;
import com.grados.firstfullproject.repository.ConducteurRepository;
import com.grados.firstfullproject.repository.VehiculeRepository;
import com.grados.firstfullproject.service.VehiculeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    private final AssuranceRepository assuranceRepository;

    private final ConducteurRepository conducteurRepository;


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

        Object assurance = assuranceRepository.findById(idAssurance).orElseThrow(
                ()-> new NotFound("Assurance","Id",idAssurance));

        Object conducteur = conducteurRepository.findById(idConducteur).orElseThrow(
                ()-> new NotFound("Conducteur","id",idConducteur)
        );
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

        Long idAs = v.getAssurance().getId();
        Vehicule updatedVehicule = vehiculeRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","Id",id)
        );
        // find Assurance by id to set it in Vehicule
        Assurance assurance = assuranceRepository.findById(idAs)
                .orElseThrow(()-> new NotFound("Assurance","ID",idAs));

        // check empties

        updatedVehicule.setAssurance(assurance);
        if (v.getDateAchat()!=null)
          updatedVehicule.setDateAchat(v.getDateAchat());
        if (v.getMarque()!=null)
          updatedVehicule.setMarque(v.getMarque());
        if (v.getPuissance()!=0)
         updatedVehicule.setPuissance(v.getPuissance());
        if (v.getModel()!=null)
            updatedVehicule.setModel(v.getModel());

        vehiculeRepository.save(updatedVehicule);

        return updatedVehicule;

    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.findById(id).orElseThrow(()->new NotFound("Vehicule","ID",id));
        vehiculeRepository.deleteById(id);
    }

    // POJO
    @Override
    public List<CarDriversDTO> getllCarDriver() {
        return vehiculeRepository.findAll()
                .stream()
                .map(this::carDriverEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarDriversDTO carDriverEntityToDTO(Vehicule vehicule) {
        CarDriversDTO carDriversDTO = new CarDriversDTO();
        carDriversDTO.setId(vehicule.getId());
        carDriversDTO.setNom(vehicule.getConducteur().getNom());
        carDriversDTO.setPrenom(vehicule.getConducteur().getPrenom());
        return  carDriversDTO;
    }

}
