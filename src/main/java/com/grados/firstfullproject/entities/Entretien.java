package com.grados.firstfullproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entretien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEntretien;

    private String nomEntretien;

    private double montant;


    public Entretien() {
    }

    public Entretien(String nomEntretien, double montant) {
        this.nomEntretien = nomEntretien;
        this.montant = montant;
    }

    public Long getIdEntretien() {
        return idEntretien;
    }

    public void setIdEntretien(Long idEntretien) {
        this.idEntretien = idEntretien;
    }

    public String getNomEntretien() {
        return nomEntretien;
    }

    public void setNomEntretien(String nomEntretien) {
        this.nomEntretien = nomEntretien;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
