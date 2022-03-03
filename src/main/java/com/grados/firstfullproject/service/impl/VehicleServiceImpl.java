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

        var conducteur = driverRepository.findById(idDriver).orElseThrow(
                ()-> new NotFound("Conducteur","id",idDriver)
        );
        var vehicle = vehicleRepository.findById(v.getId()).orElseThrow(
                ()-> new NotFound("Vehicle","ID",v.getId()));

        conducteur.getVehicles().add(vehicle);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAllVehicules();
    }

    @Override
    public Vehicle getVehiculeById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","Id",id)
        );
    }

    @Override
    public Vehicle updateVehicle(Vehicle v, Long id) {

        Vehicle updatedVehicle = vehicleRepository.findById(id).orElseThrow(
                ()-> new NotFound("Vehicule","Id",id)
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
    public void deleteVehicle(Long id) {
        vehicleRepository.findById(id).orElseThrow(()->new NotFound("Vehicule","ID",id));
        vehicleRepository.deleteById(id);
    }

    // POJO
//    @Override
//    public List<CarDriversDTO> getAllCarDriver() {
//        return vehiculeRepository.findAll()
//                .stream()
//                .map(this::carDriverEntityToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public CarDriversDTO carDriverEntityToDTO(Vehicule vehicule) {
//        CarDriversDTO carDriversDTO = new CarDriversDTO();
//        carDriversDTO.setId(vehicule.getId());
//        carDriversDTO.setNom(vehicule.getConducteur().getNom());
//        carDriversDTO.setPrenom(vehicule.getConducteur().getPrenom());
//        return  carDriversDTO;
//    }

}
