package com.grados.firstfullproject.mapper;


import com.grados.firstfullproject.DTO.MaintenanceDTO;
import com.grados.firstfullproject.entities.Maintenance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {

    MaintenanceDTO maintenanceToDTO(Maintenance maintenance);
    List<MaintenanceDTO> maintencancesToDTOs(List<Maintenance> maintenances);

    Maintenance DtoToMaintenance(MaintenanceDTO maintenanceDTO);
    List<Maintenance> DtosToMaintenances(List<MaintenanceDTO> maintenancesDTO);

}
