package com.grados.firstfullproject.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VehiculeDTO {
    private Long id;
    private String marque;
    private String assurance;
    private LocalDate dateExpAssurance;


}
