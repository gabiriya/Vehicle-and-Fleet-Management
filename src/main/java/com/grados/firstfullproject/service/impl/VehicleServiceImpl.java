package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Vehicle;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.DriverRepository;
import com.grados.firstfullproject.repository.VehicleRepository;
import com.grados.firstfullproject.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    private final DriverRepository driverRepository;

    public VehicleServiceImpl(
            VehicleRepository vehicleRepository,
            DriverRepository driverRepository) {
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle v,Long idDriver) {

        var driver = driverRepository.findById(idDriver).orElseThrow(
                ()-> new NotFound("Driver","id",idDriver)
        );
        driver.getVehicles().add(v);
        return vehicleRepository.save(v);
    }

    @Override
    public List<Vehicle> findAllVehicles(Long idDriver) {
        return vehicleRepository.findAllVehicles(idDriver);
    }

    @Override
    public Vehicle getVehiculeById(Long idDriver, Long idVehicle) {
        driverRepository.findById(idDriver).orElseThrow(
                ()-> new NotFound("Driver","ID",idDriver)
        );
        return vehicleRepository.findVehicleById(idVehicle).orElseThrow(
                ()-> new NotFound("Vehicule","Id",idVehicle)
        );
    }

    @Override
    public Vehicle updateVehicle(Long idDriver,Vehicle v ,Long idVehicle ) {

        Vehicle updatedVehicle = vehicleRepository.findById(idVehicle).orElseThrow(
                ()-> new NotFound("Vehicule","Id",idVehicle)
        );

        driverRepository.findById(idDriver).orElseThrow(
                () -> new NotFound("Driver","ID",idDriver)
        );

        // check empties
        if (v.getDateOfPurchase()!=null)
          updatedVehicle.setDateOfPurchase(v.getDateOfPurchase());
        if (v.getBrand()!=null)
          updatedVehicle.setBrand(v.getBrand());
        if (v.getHorsePower()!=0)
         updatedVehicle.setHorsePower(v.getHorsePower());
        if (v.getModel()!=null)
            updatedVehicle.setModel(v.getModel());

        vehicleRepository.save(updatedVehicle);

        return updatedVehicle;

    }

    @Override
    public void deleteVehicle(Long idDriver,Long idVehicle) {

        driverRepository.findById(idDriver).orElseThrow(
                () -> new NotFound("Driver","ID",idDriver)
        );

        vehicleRepository.findById(idVehicle).orElseThrow(
                ()->new NotFound("Vehicule","ID",idVehicle));
        vehicleRepository.deleteVehicleById(idDriver,idVehicle);
    }

}
