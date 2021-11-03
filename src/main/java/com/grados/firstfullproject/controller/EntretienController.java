package com.grados.firstfullproject.controller;

import com.grados.firstfullproject.entities.Conducteur;
import com.grados.firstfullproject.entities.Entretien;
import com.grados.firstfullproject.service.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entretien")
public class EntretienController {

    private final EntretienService entretienService;
    @Autowired

    public EntretienController(EntretienService entretienService) {
        this.entretienService = entretienService;
    }

    @PostMapping
    public ResponseEntity<Entretien> saveConducteur(@RequestBody Entretien entretien){
        return new ResponseEntity<>(entretienService.saveEntretien(entretien), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Entretien> getAllConducteurs(){
        return entretienService.findAllEntretien();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entretien> getConducteurById(@PathVariable("id") Long id){
        return new ResponseEntity<>(entretienService.getEntretienById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entretien> updateConducteur(
            @PathVariable("id") Long id,
            @RequestBody Entretien entretien){
        return new ResponseEntity<>(entretienService.updateEntretien(entretien,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteConducteur(@PathVariable("id") Long id){
        entretienService.deleteEntretien(id);

        return new ResponseEntity<>(
                "Entretien bien supprimee",
                HttpStatus.OK);
    }
}
