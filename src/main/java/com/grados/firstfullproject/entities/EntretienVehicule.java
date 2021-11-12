package com.grados.firstfullproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class EntretienVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEntrVehic;

    private LocalDate dateEntretien;

    private int kmVehicule;

    // entretien Vehicule with vehicule
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Vehicule vehicule;

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }


    // entretien with entretienVehicule
    @ManyToOne()
    @JoinColumn(name = "id_entretien")
    private Entretien entretien;

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }

    public EntretienVehicule() {
    }

    public EntretienVehicule(LocalDate dateEntretien, int kmVehicule) {
        this.dateEntretien = dateEntretien;
        this.kmVehicule = kmVehicule;
    }

    public Long getIdEntrVehic() {
        return idEntrVehic;
    }

    public LocalDate getDateEntretien() {
        return dateEntretien;
    }

    public int getKmVehicule() {
        return kmVehicule;
    }

    public void setIdEntrVehic(Long idEntrVehic) {
        this.idEntrVehic = idEntrVehic;
    }

    public void setDateEntretien(LocalDate dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public void setKmVehicule(int kmVehicule) {
        this.kmVehicule = kmVehicule;
    }
}
