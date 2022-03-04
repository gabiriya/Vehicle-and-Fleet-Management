package com.grados.firstfullproject.controller;


import com.grados.firstfullproject.DTO.VehicleDTO;
import com.grados.firstfullproject.entities.Vehicle;
import com.grados.firstfullproject.mapper.VehicleMapper;
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

    @Autowired
    public VehicleController(
            VehicleService vehiculeService
    ) {
        this.vehiculeService = vehiculeService;
    }

    @PostMapping("/{idDriver}")
    public ResponseEntity<Vehicle> saveVehicle(
            @RequestBody Vehicle vehicle,
            @PathVariable Long idDriver) {
        return new ResponseEntity<>(vehiculeService.saveVehicle(vehicle,idDriver), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idDriver}/{idVehicle}")
    public ResponseEntity<String > deleteVehicle(
            @PathVariable("idDriver") Long idDriver,
            @PathVariable("idVehicle") Long idVehicle){
        vehiculeService.deleteVehicle(idDriver,idVehicle);
        return new ResponseEntity<>("Vehicule deleted",HttpStatus.OK);
    }

    @GetMapping("{idDriver}")
    public List<Vehicle> getAllVehicles(@PathVariable Long idDriver){
        return vehiculeService.findAllVehicles(idDriver);
    }

    // get by id

    @GetMapping("{idDriver}/{idVehicle}")
    public ResponseEntity<Vehicle> getVehicleById(
            @PathVariable("idDriver") Long idDriver,
            @PathVariable("idVehicle") Long idVehicle
            ){
        return new ResponseEntity<>(vehiculeService.getVehiculeById(idDriver,idVehicle),HttpStatus.OK);
    }

    // update
    @PutMapping("/{idDriver}/{idVehicle}")
    public ResponseEntity<Vehicle> updateVehicle(
            @PathVariable("idVehicle") Long idVehicle,
            @PathVariable("idDriver") Long idDriver,
            @RequestBody Vehicle vehicle)
    {
        return new ResponseEntity<>(vehiculeService.updateVehicle(idDriver,vehicle,idVehicle),HttpStatus.OK);
    }

    // get vehicule(dto)
//    @GetMapping("/cars")
//    public List<CarDriversDTO> getCarDriversDTOS(){
//        return vehiculeService.getAllCarDriver();
//    }

   // get vehicule with conducteur and assurance and date exp assurance
//    @GetMapping("/car/{id}")
//    public VehicleDTO getVehiculeDto(@PathVariable("id") Long id){
//        return vehicleMapper.VehiculeToDto(
//                vehiculeService.getVehiculeById(id)
//        );
//    }
}
