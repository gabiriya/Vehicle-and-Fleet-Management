package com.grados.firstfullproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMaintenanceVehicle;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateMaintenanceVehicle;

    @Column
    @PositiveOrZero
    private int kmVehicle;


//    // entretien Vehicule with vehicule
//    @ManyToOne(fetch = FetchType.LAZY)
////    @JsonIgnore
//    private Vehicle vehicle;
//
//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }
//
//
////     entretien with entretienVehicule
//    @ManyToOne()
//    @JoinColumn(name = "id_maintenance")
//    private Maintenance maintenance;
//
//    public Maintenance getMaintenance() {
//        return maintenance;
//    }
//
//    public void setMaintenance(Maintenance maintenance) {
//        this.maintenance = maintenance;
//    }
}
