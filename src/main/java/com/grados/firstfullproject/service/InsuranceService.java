package com.grados.firstfullproject.service;

import com.grados.firstfullproject.DTO.InsuranceDTO;

import java.util.List;

public interface InsuranceService {

    InsuranceDTO saveInsurance(Long idDriver, Long idVec,InsuranceDTO insurance);
    List<InsuranceDTO> findAllInsurances(Long idDriver,Long idVec);
    InsuranceDTO getInsuranceById(Long idDriver,Long idVec, Long idIns);
    InsuranceDTO updateInsurance(InsuranceDTO assurance,Long id);
    void deleteInsurance(Long idDriver,Long idVec, Long idIns);
}
