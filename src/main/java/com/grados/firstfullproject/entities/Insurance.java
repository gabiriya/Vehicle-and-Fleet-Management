package com.grados.firstfullproject.entities;




import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate dateOfInsurance;
    private LocalDate expirationDate;

//    @OneToOne(
////            cascade = CascadeType.DETACH,
//            mappedBy = "assurance")
////    @JsonIgnore
//    private Vehicule vehicule;
//
//
//    public Vehicule getVehicule() {
//        return vehicule;
//    }
//
//    public void setVehicule(Vehicule vehicule) {
//        this.vehicule = vehicule;
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
