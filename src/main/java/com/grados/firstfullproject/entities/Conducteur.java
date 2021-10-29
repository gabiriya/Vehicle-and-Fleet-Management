package com.grados.firstfullproject.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Conducteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;


    // mapping conducteur with vehicule;
//    @OneToMany(mappedBy = "conducteur",cascade = {CascadeType.REFRESH})
//    private List<Vehicule> vehicules;
//
//    public List<Vehicule> getVehicules() {
//        return vehicules;
//    }
//
//    public void setVehicules(List<Vehicule> vehicules) {
//        this.vehicules = vehicules;
//    }



    public Conducteur() {
    }

    public Conducteur(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
