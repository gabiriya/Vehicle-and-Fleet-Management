package com.grados.firstfullproject.mapper;

import com.grados.firstfullproject.DTO.VehicleDTO;
import com.grados.firstfullproject.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;



@Mapper(componentModel = "spring")
public interface VehicleMapper {

//    @Mapping(target = "dateExpAssurance", source = "assurance.dateExpiration")
//    @Mapping(target = "marque", source = "marque")
//    @Mapping(target = "assurance" , source = "assurance.nom")

    VehicleDTO VehiculeToDto(Vehicle vehicule);
}
