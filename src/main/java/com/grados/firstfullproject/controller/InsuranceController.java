package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.DTO.InsuranceDTO;
import com.grados.firstfullproject.service.InsuranceService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService assuranceService;

    public InsuranceController(InsuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    // add assurance to db
    @PostMapping("/{idVec}")
    public ResponseEntity<InsuranceDTO> addInsurance(@RequestBody InsuranceDTO insurance,
                                                     @PathVariable("idVec") Long idVec){
        return  new ResponseEntity<>(assuranceService.saveInsurance(idVec,insurance), HttpStatus.CREATED);
    }

    // get all
    @GetMapping("/{idVec}")
    public List<InsuranceDTO> getAllInsurances(@PathVariable("idVec") Long idVec){
        return assuranceService.findAllInsurances(idVec);
    }

    // get assurance by id
    @GetMapping("{id}")
    public ResponseEntity<InsuranceDTO> getInsuranceById(@PathVariable("id") Long id){
        return new ResponseEntity<>(assuranceService.getInsuranceById(id),HttpStatus.OK);
    }

    // update assurance
    @PutMapping("{id}")
    public ResponseEntity<InsuranceDTO> updateInsurance(
            @PathVariable("id") Long id,
            @RequestBody InsuranceDTO assurance){
        return new ResponseEntity<>(assuranceService.updateInsurance(assurance,id),HttpStatus.OK);
    }

    // delete assurance
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInsurance(@PathVariable("id") Long id){
        assuranceService.deleteInsurance(id);
        return new ResponseEntity<>("Assurance deleted",HttpStatus.OK);
    }
}