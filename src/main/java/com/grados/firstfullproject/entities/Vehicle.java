package com.grados.firstfullproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.List;

@Entity
//@Data
@NoArgsConstructor
//@AllArgsConstructor()
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String brand;

    @JsonFormat(pattern = "yyyy")
    private LocalDate model;

    @Column
    @PositiveOrZero
    private int horsePower;

    @Column
//    @PositiveOrZero(message = "countr must be sup a 0")
    private int counter;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfPurchase;


    // Mapping Vehicule with Assurance

    @OneToMany(
            cascade = CascadeType.ALL
//            ,fetch = FetchType.LAZY
    )
    @JoinColumn(name = "id_vehicle_fk")
    private List<Insurance> insurances;


    @OneToMany(
            cascade = CascadeType.DETACH
//            ,fetch = FetchType.LAZY
    )
//    @JoinColumn(name = "id_vehicle_fk")
    private List<MaintenanceVehicle> maintenanceVehicles;


    public Vehicle(Long id, String brand, LocalDate model, int horsePower, int counter, LocalDate dateOfPurchase) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.counter = counter;
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

    public void setBrand(String brand) {
        this.brand = brand;
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

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public List<MaintenanceVehicle> getMaintenanceVehicles() {
        return maintenanceVehicles;
    }

    public void setMaintenanceVehicles(List<MaintenanceVehicle> maintenanceVehicles) {
        this.maintenanceVehicles = maintenanceVehicles;
    }
}
