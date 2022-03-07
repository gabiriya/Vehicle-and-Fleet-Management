package com.grados.firstfullproject.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MaintenanceVehicleDTO {

    private Long idMaintenanceVehicle;

    private LocalDate dateMaintenanceVehicle;

    private int kmVehicle;
}
