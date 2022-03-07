package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.DTO.DriverDTO;
import com.grados.firstfullproject.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {


    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    public DriverController() {

    }

    // get all
    @GetMapping
    public List<DriverDTO> getAllDrivers(){
        return driverService.findAllDrivers();
    }

    // save driver
    @PostMapping
    public ResponseEntity<?> saveDriver(@RequestBody DriverDTO driver){
        return new ResponseEntity<>(driverService.saveDriver(driver), HttpStatus.CREATED);
    }

    // get driver by id
    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> getDriverById(@PathVariable("id") Long id){
        return new ResponseEntity<>(driverService.getDriverById(id),HttpStatus.OK);
    }

    // update a driver
    @PutMapping("/{id}")
    public ResponseEntity<DriverDTO> updateDriver(
            @PathVariable("id") Long id,
            @RequestBody DriverDTO driver){
        return new ResponseEntity<>(driverService.updateDriver(driver,id),HttpStatus.OK);
    }

    // delete driver by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteDriver(@PathVariable("id") Long id){
        driverService.deleteConducteur(id);

        return new ResponseEntity<>(
                "Vehicule deleted with id conducteur  = " + id +
                        "\n conducteur with id = " + id+ " is deleted",
                HttpStatus.OK);
    }

}
