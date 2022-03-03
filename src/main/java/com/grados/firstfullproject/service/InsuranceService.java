package com.grados.firstfullproject.service;

import com.grados.firstfullproject.entities.Insurance;

import java.util.List;

public interface InsuranceService {

    Insurance saveInsurance(Insurance insurance);
    List<Insurance> findAllInsurances();
    Insurance getInsuranceById(Long id);
    Insurance updateInsurance(Insurance assurance,Long id);
    void deleteInsurance(Long id);
}
