package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.DTO.DriverDTO;
import com.grados.firstfullproject.entities.Driver;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.mapper.DriverMapper;
import com.grados.firstfullproject.repository.DriverRepository;
import com.grados.firstfullproject.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {


    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @Override
    public DriverDTO saveDriver(DriverDTO d) {
        var driver = driverMapper.DtoToDriver(d);
        var driver2 = driverRepository.save(driver);

        return driverMapper.DriverToDTO(driver2);
    }

    @Override
    public List<DriverDTO> findAllDrivers() {
        var drivers = driverRepository.findAllDrivers();
        return driverMapper.DriverssToDtos(drivers);
    }

    @Override
    public DriverDTO getDriverById(Long id) {
        Driver driver = driverRepository.findById(id).orElseThrow(()->
                new NotFound("Conducteur","Id",id));
        return driverMapper.DriverToDTO(driver);
    }

    @Override
    public DriverDTO updateDriver(DriverDTO c, Long id) {
        Driver updatedDriver = driverRepository.findById(id).orElseThrow(
                ()-> new NotFound("Conducteur","Id",id));

        // check if empty
        if(c.getFirstName() != null)
            updatedDriver.setFirstName(c.getFirstName());
        if(c.getLastName() != null)
            updatedDriver.setLastName(c.getLastName());
        if (c.getDateOfBirth() != null)
            updatedDriver.setDateOfBirth(c.getDateOfBirth());

        driverRepository.save(updatedDriver);

        // convert driver to driverDto and return it
       return driverMapper.DriverToDTO(updatedDriver);

    }

    @Override
    public void deleteConducteur(Long id) {
        driverRepository.findById(id).orElseThrow(
                ()-> new NotFound("Driver ","Id",id));
        driverRepository.deleteById(id);
    }
}
