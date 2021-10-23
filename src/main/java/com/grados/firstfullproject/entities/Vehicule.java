package com.grados.firstfullproject.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String marque;

    private LocalDate model;

    private int puissance;
    private LocalDate dateAchat;


    @OneToOne(cascade = CascadeType.ALL)
    private Assurance assurance;


    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public Vehicule() {
    }

    public Vehicule(String marque, LocalDate model, int puissance, LocalDate dateAchat,Assurance assurance) {
        this.marque = marque;
        this.model = model;
        this.puissance = puissance;
        this.dateAchat = dateAchat;
        this.assurance = assurance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
