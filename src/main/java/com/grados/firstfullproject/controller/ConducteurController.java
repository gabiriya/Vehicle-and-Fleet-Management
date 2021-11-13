package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.DTO.ConducteurDTO;
import com.grados.firstfullproject.entities.Conducteur;
import com.grados.firstfullproject.entities.Vehicule;
import com.grados.firstfullproject.mapper.ConducteurMapper;
import com.grados.firstfullproject.repository.VehiculeRepository;
import com.grados.firstfullproject.service.ConducteurService;
import com.grados.firstfullproject.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conducteur")
public class ConducteurController {



    private VehiculeRepository vehiculeRepository;
    private ConducteurService conducteurService;
    private ConducteurMapper conducteurMapper;

    @Autowired
    public ConducteurController(
            ConducteurService conducteurService,
            VehiculeRepository vehiculeRepository,
            ConducteurMapper conducteurMapper) {
        this.conducteurService = conducteurService;
        this.vehiculeRepository = vehiculeRepository;
        this.conducteurMapper = conducteurMapper;
    }

    public ConducteurController() {

    }

    @PostMapping
    public ResponseEntity<Conducteur> saveConducteur(@RequestBody Conducteur conducteur){
        return new ResponseEntity<>(conducteurService.saveConducteur(conducteur), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Conducteur> getAllConducteurs(){
        return conducteurService.findAllConducteurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conducteur> getConducteurById(@PathVariable("id") Long id){
        return new ResponseEntity<>(conducteurService.getConducteurById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conducteur> updateConducteur(
            @PathVariable("id") Long id,
            @RequestBody Conducteur conducteur){
        return new ResponseEntity<>(conducteurService.updateConducteur(conducteur,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteConducteur(@PathVariable("id") Long id){
        vehiculeRepository.deleteAllVehiculeWithConduct(id);
        conducteurService.deleteConducteur(id);

        return new ResponseEntity<>(
                "Vehicule deleted with id conducteur  = " + id +
                        "\n conducteur with id = " + id+ " is deleted",
                HttpStatus.OK);
    }

    // ConducteurDTO
    @GetMapping("/driver/{id}")
    public ConducteurDTO getDriver(@PathVariable("id") Long id){
        return conducteurMapper.ConducteurToDTO(
                conducteurService.getConducteurById(id)
        );
    }
}
