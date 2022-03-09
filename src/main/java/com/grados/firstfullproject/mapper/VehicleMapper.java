package com.grados.firstfullproject.mapper;

import com.grados.firstfullproject.DTO.VehicleDTO;
import com.grados.firstfullproject.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface VehicleMapper {

//    @Mapping(target = "dateExpAssurance", source = "assurance.dateExpiration")
//    @Mapping(target = "marque", source = "marque")
//    @Mapping(target = "insurances" , source = "insurances")

    VehicleDTO vehicleToDto(Vehicle vehicule);
    Vehicle dtoToVehicle(VehicleDTO vehicleDTO);


    List<VehicleDTO> vehiclesToDTOs(List<Vehicle> vehicule);
    List<Vehicle> dtosToVehicles(List<VehicleDTO> vehicleDTO);
}
