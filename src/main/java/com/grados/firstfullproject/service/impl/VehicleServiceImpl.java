package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.DTO.VehicleDTO;
import com.grados.firstfullproject.entities.Vehicle;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.mapper.VehicleMapper;
import com.grados.firstfullproject.repository.DriverRepository;
import com.grados.firstfullproject.repository.VehicleRepository;
import com.grados.firstfullproject.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper mapper;
    private final DriverRepository driverRepository;

    public VehicleServiceImpl(
            VehicleRepository vehicleRepository,
            VehicleMapper mapper, DriverRepository driverRepository) {
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
        this.driverRepository = driverRepository;
    }

    @Override
    public List<VehicleDTO> saveVehicle(Long idDriver, List<VehicleDTO> vehicleDTOs) {

        var driver = driverRepository.findById(idDriver).orElseThrow(
                () -> new NotFound("Driver", "id", idDriver)
        );
        List<Vehicle> vecDto = new ArrayList<>();
        vehicleDTOs.forEach(vehicleDTO -> {
            var vec = mapper.dtoToVehicle(vehicleDTO);
            driver.getVehicles().add(vec);
            vecDto.add(vehicleRepository.save(vec));
        });

        return mapper.vehiclesToDTOs(vecDto);
    }

    @Override
    public List<VehicleDTO> findAllVehicles(Long idDriver) {

        return mapper.vehiclesToDTOs(vehicleRepository.findAllVehicles(idDriver));
    }

    @Override
    public VehicleDTO getVehiculeById(Long idDriver, Long idVehicle) {
        driverRepository.findById(idDriver).orElseThrow(
                () -> new NotFound("Driver", "ID", idDriver)
        );
        var vec = vehicleRepository.findVehicleById(idDriver, idVehicle).orElseThrow(
                () -> new NotFound("Vehicule", "Id", idVehicle)
        );
        return mapper.vehicleToDto(vec);
    }

    @Override
    public VehicleDTO updateVehicle(Long idDriver, VehicleDTO v, Long idVehicle) {

        Vehicle updatedVehicle = vehicleRepository.findById(idVehicle).orElseThrow(
                () -> new NotFound("Vehicule", "Id", idVehicle)
        );

        driverRepository.findById(idDriver).orElseThrow(
                () -> new NotFound("Driver", "ID", idDriver)
        );

        // check empties
        if (v.getDateOfPurchase() != null)
            updatedVehicle.setDateOfPurchase(v.getDateOfPurchase());
        if (v.getBrand() != null)
            updatedVehicle.setBrand(v.getBrand());
        if (v.getHorsePower() != 0)
            updatedVehicle.setHorsePower(v.getHorsePower());
        if (v.getModel() != null)
            updatedVehicle.setModel(v.getModel());

        vehicleRepository.save(updatedVehicle);

        return mapper.vehicleToDto(updatedVehicle);

    }

    @Override
    public void deleteVehicle(Long idDriver, Long idVehicle) {

        driverRepository.findById(idDriver).orElseThrow(
                () -> new NotFound("Driver", "ID", idDriver)
        );

        vehicleRepository.findById(idVehicle).orElseThrow(
                () -> new NotFound("Vehicule", "ID", idVehicle));

        driverRepository.deleteById(idDriver);


        vehicleRepository.deleteVehicleById(idDriver, idVehicle);
    }

    @Override
    public List<VehicleDTO> findAllVecs() {
        return mapper.vehiclesToDTOs(vehicleRepository.findAllBeta());
    }

}
