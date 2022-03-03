package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.Maintenance;
import com.grados.firstfullproject.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entretien")
public class MaintenanceController {

    private final MaintenanceService entretienService;
    @Autowired

    public MaintenanceController(MaintenanceService entretienService) {
        this.entretienService = entretienService;
    }

    @PostMapping
    public ResponseEntity<Maintenance> saveConducteur(@RequestBody Maintenance entretien){
        return new ResponseEntity<>(entretienService.saveMaintenance(entretien), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Maintenance> getAllConducteurs(){
        return entretienService.findAllMaintenance();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getConducteurById(@PathVariable("id") Long id){
        return new ResponseEntity<>(entretienService.getMaintenanceById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateConducteur(
            @PathVariable("id") Long id,
            @RequestBody Maintenance entretien){
        return new ResponseEntity<>(entretienService.updateMaintenance(entretien,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteConducteur(@PathVariable("id") Long id){
        entretienService.deleteMaintenance(id);

        return new ResponseEntity<>(
                "Maintenance bien supprimee",
                HttpStatus.OK);
    }
}
