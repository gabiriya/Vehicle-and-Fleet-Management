package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.DTO.DriverDTO;
import com.grados.firstfullproject.mapper.DriverMapper;
import com.grados.firstfullproject.repository.VehiculeRepository;
import com.grados.firstfullproject.service.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conducteur")
public class DriverController {


    private ConducteurService conducteurService;

    @Autowired
    public DriverController(ConducteurService conducteurService) {
        this.conducteurService = conducteurService;
    }

    public DriverController() {

    }

    @PostMapping
    public ResponseEntity<DriverDTO> saveConducteur(@RequestBody DriverDTO driver){
        return new ResponseEntity<>(conducteurService.saveDriver(driver), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<DriverDTO> getAllConducteurs(){
        return conducteurService.findAllDrivers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> getConducteurById(@PathVariable("id") Long id){
        return new ResponseEntity<>(conducteurService.getDriverById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverDTO> updateConducteur(
            @PathVariable("id") Long id,
            @RequestBody DriverDTO driver){
        return new ResponseEntity<>(conducteurService.updateDriver(driver,id),HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String > deleteConducteur(@PathVariable("id") Long id){
//        vehiculeRepository.deleteAllVehiculeWithConduct(id);
//        conducteurService.deleteConducteur(id);
//
//        return new ResponseEntity<>(
//                "Vehicule deleted with id conducteur  = " + id +
//                        "\n conducteur with id = " + id+ " is deleted",
//                HttpStatus.OK);
//    }

    // ConducteurDTO
    @GetMapping("/driver/{id}")
    public DriverDTO getDriver(@PathVariable("id") Long id){
        return conducteurService.getDriverById(id);
    }
}
