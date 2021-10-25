package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.Assurance;
import com.grados.firstfullproject.repository.AssuranceRepository;
import com.grados.firstfullproject.service.AssuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {

    private AssuranceService assuranceService;

    public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    // add assurance to db
    @RequestMapping
    public ResponseEntity<Assurance> addAssurance(@RequestBody Assurance assurance){
        return  new ResponseEntity<>(assuranceService.saveAssurance(assurance), HttpStatus.CREATED);
    }

    // get all
    @GetMapping("/all")
    public List<Assurance> getAllAssurances(){
        return assuranceService.findAllAssurances();
    }

    // get assurance by id
    @GetMapping("{id}")
    public ResponseEntity<Assurance> getAssuranceById(@PathVariable("id") Long id){
        return new ResponseEntity<>(assuranceService.getAssuranceById(id),HttpStatus.OK);
    }

    // update assurance
    @PutMapping("{id}")
    public ResponseEntity<Assurance> updateAssurance(
            @PathVariable("id") Long id,
            @RequestBody Assurance assurance){
        return new ResponseEntity<>(assuranceService.updateAssurance(assurance,id),HttpStatus.OK);
    }

    // delete assurance
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAssurance(@PathVariable("id") Long id){
        assuranceService.deleteAssurance(id);
        return new ResponseEntity<>("Assurance deleted",HttpStatus.OK);
    }
}
