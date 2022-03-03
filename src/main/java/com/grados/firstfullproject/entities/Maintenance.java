package com.grados.firstfullproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double amount;


    public Maintenance() {
    }

    public Maintenance(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idEntretien) {
        this.id = idEntretien;
    }

    public String getName() {
        return name;
    }

    public void setName(String nomEntretien) {
        this.name = nomEntretien;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double montant) {
        this.amount = montant;
    }
}
