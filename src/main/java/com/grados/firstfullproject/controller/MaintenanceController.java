package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.Maintenance;
import com.grados.firstfullproject.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;
    @Autowired

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    public ResponseEntity<Maintenance> saveConducteur(@RequestBody Maintenance maintenance){
        return new ResponseEntity<>(maintenanceService.saveMaintenance(maintenance), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Maintenance> getAllConducteurs(){
        return maintenanceService.findAllMaintenance();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getConducteurById(@PathVariable("id") Long id){
        return new ResponseEntity<>(maintenanceService.getMaintenanceById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> updateConducteur(
            @PathVariable("id") Long id,
            @RequestBody Maintenance maintenance){
        return new ResponseEntity<>(maintenanceService.updateMaintenance(maintenance,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteConducteur(@PathVariable("id") Long id){
        maintenanceService.deleteMaintenance(id);

        return new ResponseEntity<>(
                "Maintenance is deleted",
                HttpStatus.OK);
    }
}
