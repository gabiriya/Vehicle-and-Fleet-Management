package com.grados.firstfullproject.mapper;


import com.grados.firstfullproject.DTO.DriverDTO;
import com.grados.firstfullproject.entities.Driver;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverDTO DriverToDTO(Driver driver);
    Driver DtoToDriver(DriverDTO c);
    List<Driver> dtosToDrivers(List<DriverDTO> driverDTOS);
    List<DriverDTO> DriverssToDtos(List<Driver> drivers);
}
