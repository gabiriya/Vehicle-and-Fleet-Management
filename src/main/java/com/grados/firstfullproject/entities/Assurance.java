package com.grados.firstfullproject.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private LocalDate dateAssurance;
    private LocalDate dateExpiration;

    @OneToOne(cascade = CascadeType.DETACH)
    private Vehicule vehicule;
    // this is dto implementation
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Assurance() {
    }

    public Assurance(String nom, LocalDate dateAssurance, LocalDate dateExpiration) {
        this.nom = nom;
        this.dateAssurance = dateAssurance;
        this.dateExpiration = dateExpiration;
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

    public LocalDate getDateAssurance() {
        return dateAssurance;
    }

    public void setDateAssurance(LocalDate dateAssurance) {
        this.dateAssurance = dateAssurance;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
