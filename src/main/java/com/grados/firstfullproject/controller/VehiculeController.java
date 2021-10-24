package com.grados.firstfullproject.controller;


import com.grados.firstfullproject.entities.Vehicule;
import com.grados.firstfullproject.repository.VehiculeRepository;
import com.grados.firstfullproject.service.VehiculeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(("/vehicule"))
public class VehiculeController {
    private VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @PostMapping
    public ResponseEntity<Vehicule> saveVehicule(@RequestBody Vehicule vehicule){
        Long id  = vehicule.getAssurance().getId();
        System.out.println("id = " + id);
        return new ResponseEntity<>(vehiculeService.saveVehicule(vehicule,id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicule(@PathVariable("id") Long id){
        vehiculeService.deleteVehicule(id);
    }

    @GetMapping("/all")
    public List<Vehicule> getAllVehicules(){
        return vehiculeService.findAllVehicules();
    }
}
