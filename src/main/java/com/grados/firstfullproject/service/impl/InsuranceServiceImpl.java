package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Insurance;
import com.grados.firstfullproject.exception.InsuranceNotFound;
import com.grados.firstfullproject.repository.InsuranceRepository;
import com.grados.firstfullproject.repository.VehicleRepository;
import com.grados.firstfullproject.service.InsuranceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository assuranceRepository;
    private final VehicleRepository vehicleRepository;

    public InsuranceServiceImpl(InsuranceRepository assuranceRepository, VehicleRepository vehicleRepository) {
        this.assuranceRepository = assuranceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Insurance saveInsurance(Insurance insurance) {
        return assuranceRepository.save(insurance);
    }

    @Override
    public List<Insurance> findAllInsurances() {
        return assuranceRepository.findAll();
    }

    @Override
    public Insurance getInsuranceById(Long id) {
        Insurance insurance = assuranceRepository.findById(id).orElseThrow(
                ()-> new InsuranceNotFound("ID",id)
        );
        return insurance;
    }

    @Override
    public Insurance updateInsurance(Insurance insurance, Long id) {
//        Long idv = assurance.getVehicule().getId();
//        Vehicle vehicule = vehiculeRepository.findById(idv).orElseThrow(
//                ()-> new NotFound("Vehicule","ID",idv)
//        );
        Insurance updatedAssurance =  assuranceRepository.findById(id).orElseThrow(
                ()-> new InsuranceNotFound("ID",id)
        );

//        updatedAssurance.setVehicule(vehicule);
        // check if empty
        if(insurance.getName() != null)
            updatedAssurance.setName(insurance.getName());
        if(insurance.getDateOfInsurance() != null)
            updatedAssurance.setDateOfInsurance(insurance.getDateOfInsurance());
        if(insurance.getExpirationDate() != null)
            updatedAssurance.setExpirationDate(insurance.getExpirationDate());

        assuranceRepository.save(updatedAssurance);
        return updatedAssurance;
    }

    @Override
    public void deleteInsurance(Long id) {
        assuranceRepository.findById(id).orElseThrow(
                ()-> new InsuranceNotFound("ID",id)
        );
        assuranceRepository.deleteById(id);
    }
}
