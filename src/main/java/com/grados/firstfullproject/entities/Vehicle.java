package com.grados.firstfullproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(
            cascade = CascadeType.ALL
//            ,fetch = FetchType.LAZY
    )
    @JoinColumn(name = "id_vehicle_fk")
    private List<Insurance> insurances;




//----------
//    public Vehicle() {
//    }
//
//    public Vehicle(String brand, LocalDate model, int horsePower, LocalDate dateOfPurchase) {
//        this.brand = brand;
//        this.model = model;
//        this.horsePower = horsePower;
//        this.dateOfPurchase = dateOfPurchase;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String marque) {
//        this.brand = marque;
//    }
//
//    public LocalDate getModel() {
//        return model;
//    }
//
//    public void setModel(LocalDate model) {
//        this.model = model;
//    }
//
//    public int getHorsePower() {
//        return horsePower;
//    }
//
//    public void setHorsePower(int horsePower) {
//        this.horsePower = horsePower;
//    }
//
//    public LocalDate getDateOfPurchase() {
//        return dateOfPurchase;
//    }
//
//    public void setDateOfPurchase(LocalDate dateOfPurchase) {
//        this.dateOfPurchase = dateOfPurchase;
//    }


}
