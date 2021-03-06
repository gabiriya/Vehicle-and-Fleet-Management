package com.grados.firstfullproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marque;

    private LocalDate model;

    private int puissance;
    private LocalDate dateAchat;


    // Mapping Vehicule with Assurance
    @OneToOne(
            cascade = CascadeType.DETACH
//            ,fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Assurance assurance;


    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }


//     Mapping Vehicule with conducteur
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Conducteur conducteur;

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }
//----------
    public Vehicule() {
    }

    public Vehicule(String marque, LocalDate model, int puissance, LocalDate dateAchat) {
        this.marque = marque;
        this.model = model;
        this.puissance = puissance;
        this.dateAchat = dateAchat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public LocalDate getModel() {
        return model;
    }

    public void setModel(LocalDate model) {
        this.model = model;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }


}
