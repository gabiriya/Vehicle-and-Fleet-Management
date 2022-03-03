package com.grados.firstfullproject.DTO;


import com.grados.firstfullproject.entities.Vehicle;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
public class DriverDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<Vehicle> vehicles;

}
