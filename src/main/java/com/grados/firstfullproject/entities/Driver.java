package com.grados.firstfullproject.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;


    @OneToMany
    private List<Vehicule> vehicules;

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public Driver() {
    }

    public Driver(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String nom) {
        this.firstName = nom;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String prenom) {
        this.lastName = prenom;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateNaissance) {
        this.dateOfBirth = dateNaissance;
    }
}
