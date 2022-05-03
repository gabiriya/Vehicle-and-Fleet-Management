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

    private final VehicleService vehiculeService;

    @Autowired
    public VehicleController(VehicleService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<List<VehicleDTO>> saveVehicle(
            @RequestBody List<VehicleDTO> vehicleDTO,
            @PathVariable Long idDriver) {
        return new ResponseEntity<>(vehiculeService.saveVehicle(idDriver,vehicleDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/vehicles/{idVehicle}")
    public ResponseEntity<String> deleteVehicle(
            @PathVariable("idDriver") Long idDriver,
            @PathVariable("idVehicle") Long idVehicle){
        vehiculeService.deleteVehicle(idDriver,idVehicle);
        return new ResponseEntity<>("Vehicule deleted",HttpStatus.OK);
    }

    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicles(@PathVariable Long idDriver){
        return vehiculeService.findAllVehicles(idDriver);
    }

    // get by id

    @GetMapping("/vehicles/{idVehicle}")
    public ResponseEntity<VehicleDTO> getVehicleById(
            @PathVariable("idDriver") Long idDriver,
            @PathVariable("idVehicle") Long idVehicle
            ){
        return new ResponseEntity<>(vehiculeService.getVehiculeById(idDriver,idVehicle),HttpStatus.OK);
    }

    // update
    @PutMapping("/vehicles/{idVehicle}")
    public ResponseEntity<VehicleDTO> updateVehicle(
            @PathVariable("idVehicle") Long idVehicle,
            @PathVariable("idDriver") Long idDriver,
            @RequestBody VehicleDTO vehicleDto)
    {
        return new ResponseEntity<>(vehiculeService.updateVehicle(idDriver,vehicleDto,idVehicle),HttpStatus.OK);
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
