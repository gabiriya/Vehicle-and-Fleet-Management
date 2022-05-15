package com.grados.firstfullproject.entities;

import com.grados.firstfullproject.service.helper.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank
    private String name;

    private int frequency;

    @Enumerated(EnumType.STRING)
    private PeriodType period;

    private int mileage;

    @Column
    @NotNull
    private double amount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MaintenanceVehicle> maintenanceVehicles;
}
