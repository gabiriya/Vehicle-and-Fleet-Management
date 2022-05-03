package com.grados.firstfullproject.entities;




import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfInsurance;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
}
