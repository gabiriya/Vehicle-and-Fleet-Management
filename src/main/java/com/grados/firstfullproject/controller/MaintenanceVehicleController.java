package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.MaintenanceVehicle;
import com.grados.firstfullproject.service.MaintenanceVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MaintenanceVehicle")
public class MaintenanceVehicleController {

    private final MaintenanceVehicleService entretienVehiculeService;

    @Autowired
    public MaintenanceVehicleController(MaintenanceVehicleService entretienVehiculeService) {
        this.entretienVehiculeService = entretienVehiculeService;
    }

//    @PostMapping
//    public ResponseEntity<EntretienVehicule> saveEntretienVehicule(@RequestBody EntretienVehicule entretienVehicule){
//        Long idVehicule  = entretienVehicule.getVehicule().getId();
//        return new ResponseEntity<>(entretienVehiculeService.saveEntretienVehicule(entretienVehicule,idVehicule), HttpStatus.CREATED);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String > deleteEntretienVehicule(@PathVariable("id") Long id){
//        EntretienVehicule ev = entretienVehiculeService.getEntretienVehiculeById(id);
//        Long idv = ev.getVehicule().getId();
//        entretienVehiculeService.deleteEntretienVehicule(id);
//        return new ResponseEntity<>("Entretien de Vehicule :" + idv +" est bien supprimee!!",HttpStatus.OK);
//    }

    @GetMapping("/all")
    public List<MaintenanceVehicle> getAllEntretienVehicules(){
        return entretienVehiculeService.findAllMaintenanceVehicle();
    }

    // get by id

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceVehicle> getEntretienVehiculeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(entretienVehiculeService.getMaintenanceVehicleById(id),HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceVehicle> updateEntretienVehicule(@PathVariable("id") Long id, @RequestBody MaintenanceVehicle entretienVehicule)
    {
        return new ResponseEntity<>(entretienVehiculeService.updateMaintenanceVehicle(entretienVehicule,id),HttpStatus.OK);
    }

}
