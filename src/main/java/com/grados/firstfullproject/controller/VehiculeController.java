package com.grados.firstfullproject.controller;


import com.grados.firstfullproject.DTO.CarDriversDTO;
import com.grados.firstfullproject.DTO.VehiculeDTO;
import com.grados.firstfullproject.entities.Vehicule;
import com.grados.firstfullproject.mapper.VehiculeMapper;
import com.grados.firstfullproject.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/vehicule"))
public class VehiculeController {

    private final VehiculeService vehiculeService;
    private final VehiculeMapper vehiculeMapper;

    @Autowired
    public VehiculeController(
            VehiculeService vehiculeService,
            // ERROR Could not autowire. No beans of 'VehiculeMapper' type found.
            VehiculeMapper vehiculeMapper) {
        this.vehiculeService = vehiculeService;
        this.vehiculeMapper = vehiculeMapper;
    }

    @PostMapping
    public ResponseEntity<Vehicule> saveVehicule(@RequestBody Vehicule vehicule){
        Long idAssurance  = vehicule.getAssurance().getId();
        Long idConducteur = vehicule.getConducteur().getId();
        return new ResponseEntity<>(vehiculeService.saveVehicule(vehicule,idAssurance,idConducteur), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteVehicule(@PathVariable("id") Long id){
        vehiculeService.deleteVehicule(id);
        return new ResponseEntity<>("Vehicule deleted",HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Vehicule> getAllVehicules(){
        return vehiculeService.findAllVehicules();
    }

    // get by id

    @GetMapping("{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(vehiculeService.getVehiculeById(id),HttpStatus.OK);
    }

    // update
    @PutMapping("{id}")
    public ResponseEntity<Vehicule> updateVehicule(
            @PathVariable("id") Long id,
            @RequestBody Vehicule vehicule)
    {
        return new ResponseEntity<>(vehiculeService.updateVehicule(vehicule,id),HttpStatus.OK);
    }

    // get vehicule(dto)
    @GetMapping("/cars")
    public List<CarDriversDTO> getCarDriversDTOS(){
        return vehiculeService.getllCarDriver();
    }

    // get vehicule with conducteur and assurance and date exp assurance
    @GetMapping("/car/{id}")
    public VehiculeDTO getVehiculeDto(@PathVariable("id") Long id){
        return vehiculeMapper.VehiculeToDto(
                vehiculeService.getVehiculeById(id)
        );
    }
}
