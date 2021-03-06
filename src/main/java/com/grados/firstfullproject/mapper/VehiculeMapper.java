package com.grados.firstfullproject.mapper;

import com.grados.firstfullproject.DTO.VehiculeDTO;
import com.grados.firstfullproject.entities.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;



@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    @Mapping(target = "dateExpAssurance", source = "assurance.dateExpiration")
    @Mapping(target = "marque", source = "marque")
    @Mapping(target = "assurance" , source = "assurance.nom")

    VehiculeDTO VehiculeToDto(Vehicule vehicule);
}
