package com.grados.firstfullproject.service;

import com.grados.firstfullproject.DTO.InsuranceDTO;

import java.util.List;

public interface InsuranceService {

    InsuranceDTO saveInsurance(Long idVec,InsuranceDTO insurance);
    List<InsuranceDTO> findAllInsurances(Long idVec);
    InsuranceDTO getInsuranceById(Long id);
    InsuranceDTO updateInsurance(InsuranceDTO assurance,Long id);
    void deleteInsurance(Long id);
}
