package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.DTO.InsuranceDTO;
import com.grados.firstfullproject.entities.Insurance;
import com.grados.firstfullproject.entities.Vehicle;
import com.grados.firstfullproject.exception.InsuranceNotFound;
import com.grados.firstfullproject.exception.NotExpired;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.mapper.InsuranceMapper;
import com.grados.firstfullproject.repository.DriverRepository;
import com.grados.firstfullproject.repository.InsuranceRepository;
import com.grados.firstfullproject.repository.VehicleRepository;
import com.grados.firstfullproject.service.InsuranceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper mapper;
    private final DriverRepository driverRepo;
    private final VehicleRepository vehicleRepo;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository,
                                InsuranceMapper mapper, DriverRepository driverRepo,
                                VehicleRepository vehicleRepo) {
        this.insuranceRepository = insuranceRepository;
        this.mapper = mapper;
        this.driverRepo = driverRepo;
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public InsuranceDTO saveInsurance(Long idDriver ,Long idVec,InsuranceDTO insuranceDto) {

        findDriverOrThrow(idDriver);
        findVehicleOrThrow(idDriver,idVec);
        List<InsuranceDTO> allInsurances = findAllInsurances(idDriver,idVec);
        allInsurances.forEach(ins -> {
            if (ins.getExpirationDate().compareTo(LocalDate.now()) > 0)
                throw new NotExpired(ins.getExpirationDate(),ins.getId());
            insuranceRepository.deleteById(ins.getId());
        });


        var dateInsurance = insuranceDto.getExpirationDate();
        if (dateInsurance.compareTo(LocalDate.now()) < 0)
            throw new NotFound("future bro","date",dateInsurance);
        var insurance = mapper.dtoToInsurance(insuranceDto);
        Vehicle vehicle = vehicleRepo.getById(idVec);
        vehicle.getInsurances().add(insurance);


//        return mapper.insuranceToDTO(insurance);
        return mapper.insuranceToDTO(insuranceRepository.save(insurance));
    }

//    private boolean hasInsurance(Long idVec){
//        vehicleRepository.findVehicleById(idVec);
//    }
    @Override
    public List<InsuranceDTO> findAllInsurances(Long idDriver,Long idVec) {
        var insurances = insuranceRepository.findAllByVehicle(idDriver,idVec);
        return mapper.insurancesToDTOs(insurances);
    }

    @Override
    public InsuranceDTO getInsuranceById(Long idDriver,Long idVec, Long idIns) {
        findDriverOrThrow(idDriver);
        findVehicleOrThrow(idDriver,idVec);
        Insurance insurance = findInsuranceOrThrow(idDriver, idVec, idIns);
        return mapper.insuranceToDTO(insurance);
    }

    @Override
    public InsuranceDTO updateInsurance(Long idDriver,Long idVec , Long idIns , InsuranceDTO insurance) {
        findDriverOrThrow(idDriver);
        findVehicleOrThrow(idDriver, idVec);

        Insurance updatedAssurance =  insuranceRepository.findById(idIns).orElseThrow(
                ()-> new InsuranceNotFound("ID",idIns)
        );

//        updatedAssurance.setVehicule(vehicule);
        // check if empty
        if(insurance.getName() != null)
            updatedAssurance.setName(insurance.getName());
        if(insurance.getDateOfInsurance() != null)
            updatedAssurance.setDateOfInsurance(insurance.getDateOfInsurance());
        if(insurance.getExpirationDate() != null)
            if (updatedAssurance.getExpirationDate().compareTo(LocalDate.now()) > 0)
                updatedAssurance.setExpirationDate(insurance.getExpirationDate());
            else throw new NotExpired(updatedAssurance.getExpirationDate(),idIns);

        insuranceRepository.save(updatedAssurance);

        return  mapper.insuranceToDTO(updatedAssurance);
    }

    @Override
    public void deleteInsurance(Long idDriver,Long idVec,Long idIns) {
        insuranceRepository.findById(idIns).orElseThrow(
                ()-> new InsuranceNotFound("ID",idIns)
        );
        insuranceRepository.deleteById(idIns);
    }

    private void findDriverOrThrow(Long id){
        driverRepo.findById(id).orElseThrow(
                () -> new NotFound("Driver","id",id)
        );
    }

    private void findVehicleOrThrow(Long idDriver,Long idVec){
        vehicleRepo.findVehicleById(idDriver,idVec).orElseThrow(
                () -> new NotFound("Vehicle","ID",idVec)
        );
    }

    private Insurance findInsuranceOrThrow(Long idDriver,Long idVec, Long idIns){
        return insuranceRepository.findInsuranceById(idDriver,idVec,idIns).orElseThrow(
                () -> new NotFound("Insurance","ID",idIns)
        );
    }
}
