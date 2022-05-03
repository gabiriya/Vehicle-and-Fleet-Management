package com.grados.firstfullproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MaintenanceDTO {
    private Long id;

    private String name;

    private double amount;
}
