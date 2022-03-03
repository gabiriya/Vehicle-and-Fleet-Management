package com.grados.firstfullproject.service;


import com.grados.firstfullproject.DTO.DriverDTO;

import java.util.List;

public interface DriverService {

    DriverDTO saveDriver(DriverDTO c);
    List<DriverDTO> findAllDrivers();
    DriverDTO getDriverById(Long id);
    DriverDTO updateDriver(DriverDTO c,Long id);
    void deleteConducteur(Long id);
}
