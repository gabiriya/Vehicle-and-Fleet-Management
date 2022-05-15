package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.DTO.InsuranceDTO;
import com.grados.firstfullproject.service.InsuranceService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers/{idDriver}/vehicles/{idVec}/insurances")
public class InsuranceController {
    // todo - api for expired insurances
    private final InsuranceService assuranceService;

    public InsuranceController(InsuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    // add assurance to db
    @PostMapping("")
    public ResponseEntity<InsuranceDTO> addInsurance(@PathVariable("idDriver") Long idDriver,
                                                     @PathVariable("idVec") Long idVec,
                                                     @RequestBody InsuranceDTO insurance){
        return  new ResponseEntity<>(assuranceService.saveInsurance(idDriver,idVec,insurance), HttpStatus.CREATED);
    }

    // get all
    @GetMapping("")
    public List<InsuranceDTO> getAllInsurances(@PathVariable("idDriver") Long idDriver,
            @PathVariable("idVec") Long idVec){
        return assuranceService.findAllInsurances(idDriver,idVec);
    }

    // get assurance by id
    @GetMapping("{idIns}")
    public ResponseEntity<InsuranceDTO> getInsuranceById(@PathVariable("idDriver") Long idDriver,
                                                         @PathVariable("idVec") Long idVec,
                                                         @PathVariable("idIns") Long idIns){
        return new ResponseEntity<>(assuranceService.getInsuranceById(idDriver, idVec, idIns),HttpStatus.OK);
    }

    // update assurance
    @PutMapping("{idIns}")
    public ResponseEntity<InsuranceDTO> updateInsurance(@PathVariable Long idDriver,
                                                        @PathVariable Long idVec,
                                                        @PathVariable("idIns") Long idIns,
                                                        @RequestBody InsuranceDTO insurance){
        return new ResponseEntity<>(assuranceService.updateInsurance(idDriver,idVec,idIns,insurance),HttpStatus.OK);
    }

    // delete assurance
    @DeleteMapping("{idIns}")
    public ResponseEntity<String> deleteInsurance(@PathVariable("idDriver") Long idDriver,
                                                  @PathVariable("idVec") Long idVec,
                                                  @PathVariable("idIns") Long idIns){
        assuranceService.deleteInsurance(idDriver, idVec, idIns);
        return new ResponseEntity<>("Assurance deleted",HttpStatus.OK);
    }
}