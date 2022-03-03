package com.grados.firstfullproject.DTO;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class VehicleDTO {
    private Long id;
    private String brand;
    private LocalDate model;
    private int horsePower;
    private LocalDate dateOfPurchase;
//    private String assurance;
//    private LocalDate dateExpAssurance;


}
