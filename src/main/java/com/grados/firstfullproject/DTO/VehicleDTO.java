package com.grados.firstfullproject.DTO;

import com.grados.firstfullproject.entities.Insurance;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VehicleDTO {
    private Long id;
    private String brand;
    private LocalDate model;
    private int horsePower;
    private LocalDate dateOfPurchase;
    private List<Insurance> insurances;

}
