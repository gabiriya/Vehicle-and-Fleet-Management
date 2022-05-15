package com.grados.firstfullproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

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


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_driver_fk")
    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
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
