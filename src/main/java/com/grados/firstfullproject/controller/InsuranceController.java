package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.Insurance;
import com.grados.firstfullproject.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurance")
public class InsuranceController {

    private final InsuranceService assuranceService;

    public InsuranceController(InsuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    // add assurance to db
    @PostMapping
    public ResponseEntity<Insurance> addAssurance(@RequestBody Insurance insurance){
        return  new ResponseEntity<>(assuranceService.saveInsurance(insurance), HttpStatus.CREATED);
    }

    // get all
    @GetMapping("/all")
    public List<Insurance> getAllAssurances(){
        return assuranceService.findAllInsurances();
    }

    // get assurance by id
    @GetMapping("{id}")
    public ResponseEntity<Insurance> getAssuranceById(@PathVariable("id") Long id){
        return new ResponseEntity<>(assuranceService.getInsuranceById(id),HttpStatus.OK);
    }

    // update assurance
    @PutMapping("{id}")
    public ResponseEntity<Insurance> updateAssurance(
            @PathVariable("id") Long id,
            @RequestBody Insurance assurance){
        return new ResponseEntity<>(assuranceService.updateInsurance(assurance,id),HttpStatus.OK);
    }

    // delete assurance
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAssurance(@PathVariable("id") Long id){
        assuranceService.deleteInsurance(id);
        return new ResponseEntity<>("Assurance deleted",HttpStatus.OK);
    }
}