package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.Conducteur;
import com.grados.firstfullproject.service.ConducteurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conducteur")
public class ConducteurController {

    private ConducteurService conducteurService;

    public ConducteurController(ConducteurService conducteurService) {
        this.conducteurService = conducteurService;
    }

    @PostMapping
    public ResponseEntity<Conducteur> saveConducteur(@RequestBody Conducteur conducteur){
        return new ResponseEntity<>(conducteurService.saveConducteur(conducteur), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Conducteur> getAllConducteurs(){
        return conducteurService.findAllConducteurs();
    }
    @GetMapping("{id}")
    public ResponseEntity<Conducteur> getConducteurById(@PathVariable("id") Long id){
        return new ResponseEntity<>(conducteurService.getConducteurById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Conducteur> updateConducteur(
            @PathVariable("id") Long id,
            @RequestBody Conducteur conducteur){
        return new ResponseEntity<>(conducteurService.updateConducteur(conducteur,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String > deleteConducteur(@PathVariable("id") Long id){
        conducteurService.deleteConducteur(id);
        return new ResponseEntity<>("Conducteur a ete supprimer avec success",HttpStatus.OK);
    }
}
