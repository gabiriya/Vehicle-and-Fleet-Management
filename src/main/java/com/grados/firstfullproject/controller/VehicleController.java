package com.grados.firstfullproject.controller;


import com.grados.firstfullproject.DTO.VehicleDTO;
import com.grados.firstfullproject.entities.Vehicle;
import com.grados.firstfullproject.mapper.VehiculeMapper;
import com.grados.firstfullproject.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/vehicle"))
public class VehicleController {

    private final VehicleService vehiculeService;
    private final VehiculeMapper vehiculeMapper;

    @Autowired
    public VehicleController(
            VehicleService vehiculeService,
            VehiculeMapper vehiculeMapper
    ) {
        this.vehiculeService = vehiculeService;
        this.vehiculeMapper = vehiculeMapper;
    }

//    @PostMapping
//    public ResponseEntity<Vehicule> saveVehicule(@RequestBody Vehicule vehicule){
////        Long idAssurance  = vehicule.getAssurance().getId();
////        Long idConducteur = vehicule.getConducteur().getId();
//        return new ResponseEntity<>(vehiculeService.saveVehicule(vehicule,idAssurance,idConducteur), HttpStatus.CREATED);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteVehicule(@PathVariable("id") Long id){
        vehiculeService.deleteVehicle(id);
        return new ResponseEntity<>("Vehicule deleted",HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Vehicle> getAllVehicules(){
        return vehiculeService.findAllVehicles();
    }

    // get by id

    @GetMapping("{id}")
    public ResponseEntity<Vehicle> getVehiculeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(vehiculeService.getVehiculeById(id),HttpStatus.OK);
    }

    // update
    @PutMapping("{id}")
    public ResponseEntity<Vehicle> updateVehicule(
            @PathVariable("id") Long id,
            @RequestBody Vehicle vehicule)
    {
        return new ResponseEntity<>(vehiculeService.updateVehicle(vehicule,id),HttpStatus.OK);
    }

    // get vehicule(dto)
//    @GetMapping("/cars")
//    public List<CarDriversDTO> getCarDriversDTOS(){
//        return vehiculeService.getAllCarDriver();
//    }

   // get vehicule with conducteur and assurance and date exp assurance
    @GetMapping("/car/{id}")
    public VehicleDTO getVehiculeDto(@PathVariable("id") Long id){
        return vehiculeMapper.VehiculeToDto(
                vehiculeService.getVehiculeById(id)
        );
    }
}
