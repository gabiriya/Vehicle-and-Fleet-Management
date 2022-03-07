package com.grados.firstfullproject.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MaintenanceVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMaintenanceVehicle;

    private LocalDate dateMaintenanceVehicle;

    private int kmVehicle;

    // entretien Vehicule with vehicule
//    @ManyToOne(fetch = FetchType.LAZY)
////    @JsonIgnore
//    private Vehicle vehicule;
//
//    public Vehicle getVehicule() {
//        return vehicule;
//    }
//
//    public void setVehicule(Vehicle vehicule) {
//        this.vehicule = vehicule;
//    }


    // entretien with entretienVehicule
//    @ManyToOne()
//    @JoinColumn(name = "id_maintenance")
//    private Maintenance maintenance;
//
//    public Maintenance getEntretien() {
//        return maintenance;
//    }
//
//    public void setEntretien(Maintenance entretien) {
//        this.maintenance = entretien;
//    }

    public MaintenanceVehicle() {
    }

    public MaintenanceVehicle(LocalDate dateMaintenanceVehicle, int kmVehicle) {
        this.dateMaintenanceVehicle = dateMaintenanceVehicle;
        this.kmVehicle = kmVehicle;
    }

    public Long getIdMaintenanceVehicle() {
        return idMaintenanceVehicle;
    }

    public LocalDate getDateMaintenanceVehicle() {
        return dateMaintenanceVehicle;
    }

    public int getKmVehicle() {
        return kmVehicle;
    }

    public void setIdMaintenanceVehicle(Long idEntrVehic) {
        this.idMaintenanceVehicle = idEntrVehic;
    }

    public void setDateMaintenanceVehicle(LocalDate dateEntretien) {
        this.dateMaintenanceVehicle = dateEntretien;
    }

    public void setKmVehicle(int kmVehicule) {
        this.kmVehicle = kmVehicule;
    }
}
