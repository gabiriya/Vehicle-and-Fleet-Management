package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.DTO.InsuranceDTO;
import com.grados.firstfullproject.entities.Insurance;
import com.grados.firstfullproject.exception.InsuranceNotFound;
import com.grados.firstfullproject.mapper.InsuranceMapper;
import com.grados.firstfullproject.repository.InsuranceRepository;
import com.grados.firstfullproject.repository.VehicleRepository;
import com.grados.firstfullproject.service.InsuranceService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper mapper;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository,
                                InsuranceMapper mapper) {
        this.insuranceRepository = insuranceRepository;
        this.mapper = mapper;
    }

    @Override
    public InsuranceDTO saveInsurance(Long idVec,InsuranceDTO insuranceDto) {

        var insuranceX = insuranceRepository.findInsuranceById(idVec,insuranceDto.getId());
        var dateInsurance = insuranceX.getExpirationDate();
        if (dateInsurance.compareTo(LocalDate.now()) < 0)
            throw new InsuranceNotFound("date problem",insuranceX);
        var insurance = mapper.dtoToInsurance(insuranceDto);

        return mapper.insuranceToDTO(insuranceRepository.save(insurance));
    }

//    private boolean hasInsurance(Long idVec){
//        vehicleRepository.findVehicleById(idVec);
//    }
    @Override
    public List<InsuranceDTO> findAllInsurances(Long idVec) {
        var insurances = insuranceRepository.findAllByVehicle(idVec);
        return mapper.insurancesToDTOs(insurances);
    }

    @Override
    public InsuranceDTO getInsuranceById(Long id) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(
                ()-> new InsuranceNotFound("ID",id)
        );
        return mapper.insuranceToDTO(insurance);
    }

    @Override
    public InsuranceDTO updateInsurance(InsuranceDTO insurance, Long id) {
//        Long idv = assurance.getVehicule().getId();
//        Vehicle vehicule = vehiculeRepository.findById(idv).orElseThrow(
//                ()-> new NotFound("Vehicule","ID",idv)
//        );
        Insurance updatedAssurance =  insuranceRepository.findById(id).orElseThrow(
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

        insuranceRepository.save(updatedAssurance);

        return  mapper.insuranceToDTO(updatedAssurance);
    }

    @Override
    public void deleteInsurance(Long id) {
        insuranceRepository.findById(id).orElseThrow(
                ()-> new InsuranceNotFound("ID",id)
        );
        insuranceRepository.deleteById(id);
    }
}
