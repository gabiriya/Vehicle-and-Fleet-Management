package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.EntretienVehicule;
import com.grados.firstfullproject.service.EntretienVehiculeService;
import com.grados.firstfullproject.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entretientVehicule")
public class EntretienVehiculeController {

    private EntretienVehiculeService entretienVehiculeService;
    private VehiculeService vehiculeService;

    @Autowired
    public EntretienVehiculeController(EntretienVehiculeService entretienVehiculeService, VehiculeService vehiculeService) {
        this.entretienVehiculeService = entretienVehiculeService;
        this.vehiculeService = vehiculeService;
    }

    @PostMapping
    public ResponseEntity<EntretienVehicule> saveEntretienVehicule(@RequestBody EntretienVehicule entretienVehicule){
        Long idVehicule  = entretienVehicule.getVehicule().getId();
        return new ResponseEntity<>(entretienVehiculeService.saveEntretienVehicule(entretienVehicule,idVehicule), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteEntretienVehicule(@PathVariable("id") Long id){
        EntretienVehicule ev = entretienVehiculeService.getEntretienVehiculeById(id);
        Long idv = ev.getVehicule().getId();
        entretienVehiculeService.deleteEntretienVehicule(id);
        return new ResponseEntity<>("Entretien de Vehicule :" + idv +" est bien supprimee!!",HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<EntretienVehicule> getAllEntretienVehicules(){
        return entretienVehiculeService.findAllEntretienVehicule();
    }

    // get by id

    @GetMapping("/{id}")
    public ResponseEntity<EntretienVehicule> getEntretienVehiculeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(entretienVehiculeService.getEntretienVehiculeById(id),HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<EntretienVehicule> updateEntretienVehicule(@PathVariable("id") Long id, @RequestBody EntretienVehicule entretienVehicule)
    {
        return new ResponseEntity<>(entretienVehiculeService.updateEntretienVehicule(entretienVehicule,id),HttpStatus.OK);
    }

}
