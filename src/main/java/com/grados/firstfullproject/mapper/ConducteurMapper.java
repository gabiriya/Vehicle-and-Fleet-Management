package com.grados.firstfullproject.mapper;

import com.grados.firstfullproject.DTO.ConducteurDTO;
import com.grados.firstfullproject.entities.Conducteur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ConducteurMapper {

    @Mapping(
            target = "fullName",
            expression = "java(conducteur.getNom() + conducteur.getPrenom())"
    )
    ConducteurDTO ConducteurToDTO(Conducteur conducteur);
}
