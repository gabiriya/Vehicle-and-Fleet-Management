package com.grados.firstfullproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String brand;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate model;

    @Column
    @PositiveOrZero
    private int horsePower;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfPurchase;


    // Mapping Vehicule with Assurance

//    @OneToOne(
//            cascade = CascadeType.DETACH
////            ,fetch = FetchType.LAZY
//    )
//    @JsonIgnore
//    private Assurance assurance;
//
//
//    public Assurance getAssurance() {
//        return assurance;
//    }
//
//    public void setAssurance(Assurance assurance) {
//        this.assurance = assurance;
//    }


//----------
    public Vehicle() {
    }

    public Vehicle(String brand, LocalDate model, int horsePower, LocalDate dateOfPurchase) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String marque) {
        this.brand = marque;
    }

    public LocalDate getModel() {
        return model;
    }

    public void setModel(LocalDate model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int puissance) {
        this.horsePower = puissance;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateAchat) {
        this.dateOfPurchase = dateAchat;
    }


}
