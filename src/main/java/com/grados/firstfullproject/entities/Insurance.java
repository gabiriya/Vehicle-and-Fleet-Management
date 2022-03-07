package com.grados.firstfullproject.entities;




import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfInsurance;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;


//    @OneToOne(
////            cascade = CascadeType.DETACH,
//            mappedBy = "insurance")
////    @JsonIgnore
//    private Vehicle vehicle;


//    public Vehicle getVehicule() {
//        return vehicle;
//    }
//
//    public void setVehicule(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    public Insurance() {
    }

    public Insurance(String name, LocalDate dateOfInsurance, LocalDate expirationDate) {
        this.name = name;
        this.dateOfInsurance = dateOfInsurance;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public LocalDate getDateOfInsurance() {
        return dateOfInsurance;
    }

    public void setDateOfInsurance(LocalDate dateAssurance) {
        this.dateOfInsurance = dateAssurance;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate dateExpiration) {
        this.expirationDate = dateExpiration;
    }
}
