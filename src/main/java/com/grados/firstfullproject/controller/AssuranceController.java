package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.Assurance;
import com.grados.firstfullproject.repository.AssuranceRepository;
import com.grados.firstfullproject.service.AssuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {

    private AssuranceService assuranceService;

    public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @RequestMapping
    public ResponseEntity<Assurance> addAssurance(@RequestBody Assurance assurance){
        return  new ResponseEntity<>(assuranceService.saveAssurance(assurance), HttpStatus.CREATED);
    }
}
