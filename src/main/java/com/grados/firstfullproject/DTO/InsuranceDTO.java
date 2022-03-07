package com.grados.firstfullproject.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InsuranceDTO {
    private Long id;
    private String name;
    private LocalDate dateOfInsurance;
    private LocalDate expirationDate;
}
