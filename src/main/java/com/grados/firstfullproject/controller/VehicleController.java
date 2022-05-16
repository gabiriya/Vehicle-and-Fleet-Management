package com.grados.firstfullproject.controller;


import com.grados.firstfullproject.DTO.VehicleDTO;
import com.grados.firstfullproject.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/drivers/{idDriver}"))
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<List<VehicleDTO>> saveVehicle(
            @RequestBody List<VehicleDTO> vehicleDTO,
            @PathVariable Long idDriver) {
        return new ResponseEntity<>(vehicleService.saveVehicle(idDriver,vehicleDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/vehicles/{idVehicle}")
    public ResponseEntity<String> deleteVehicle(
            @PathVariable("idDriver") Long idDriver,
            @PathVariable("idVehicle") Long idVehicle){
        vehicleService.deleteVehicle(idDriver,idVehicle);
        return new ResponseEntity<>("Vehicule deleted",HttpStatus.OK);
    }

    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicles(@PathVariable Long idDriver){
        return vehicleService.findAllVehicles(idDriver);
    }

    // get by id

    @GetMapping("/vehicles/{idVehicle}")
    public ResponseEntity<VehicleDTO> getVehicleById(
            @PathVariable("idDriver") Long idDriver,
            @PathVariable("idVehicle") Long idVehicle
            ){
        return new ResponseEntity<>(vehicleService.getVehiculeById(idDriver,idVehicle),HttpStatus.OK);
    }

    // update
    @PutMapping("/vehicles/{idVehicle}")
    public ResponseEntity<VehicleDTO> updateVehicle(
            @PathVariable("idVehicle") Long idVehicle,
            @PathVariable("idDriver") Long idDriver,
            @RequestBody VehicleDTO vehicleDto)
    {
        return new ResponseEntity<>(vehicleService.updateVehicle(idDriver,vehicleDto,idVehicle),HttpStatus.OK);
    }

    // get vehicule(dto)
//    @GetMapping("/cars")
//    public List<CarDriversDTO> getCarDriversDTOS(){
//        return vehicleService.getAllCarDriver();
//    }

   // get vehicule with conducteur and assurance and date exp assurance
//    @GetMapping("/car/{id}")
//    public VehicleDTO getVehiculeDto(@PathVariable("id") Long id){
//        return vehicleMapper.VehiculeToDto(
//                vehicleService.getVehiculeById(id)
//        );
//    }
}
