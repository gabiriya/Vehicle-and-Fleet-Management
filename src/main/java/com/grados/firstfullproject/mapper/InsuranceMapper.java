package com.grados.firstfullproject.mapper;

import com.grados.firstfullproject.DTO.InsuranceDTO;
import com.grados.firstfullproject.entities.Insurance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {
    Insurance dtoToInsurance(InsuranceDTO insuranceDto);
    InsuranceDTO insuranceToDTO(Insurance insurance);

    List<Insurance> dtosToInsurances(List<InsuranceDTO> insuranceDto);
    List<InsuranceDTO> insurancesToDTOs(List<Insurance> insurance);
}
