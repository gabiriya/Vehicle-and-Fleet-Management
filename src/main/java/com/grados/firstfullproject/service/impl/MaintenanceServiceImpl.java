package com.grados.firstfullproject.service.impl;

import com.grados.firstfullproject.entities.Maintenance;
import com.grados.firstfullproject.exception.NotFound;
import com.grados.firstfullproject.repository.MaintenanceRepository;
import com.grados.firstfullproject.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository entretienRepository;

    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepository entretienRepository) {
        this.entretienRepository = entretienRepository;
    }

    @Override
    public Maintenance saveMaintenance(Maintenance entretien) {
        return entretienRepository.save(entretien);
    }

    @Override
    public List<Maintenance> findAllMaintenance() {
        return entretienRepository.findAll();
    }

    @Override
    public Maintenance getMaintenanceById(Long id) {
        return entretienRepository.getById(id);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance entretien, Long id) {
        Maintenance updatedMaintenance = entretienRepository.findById(id).orElseThrow(
                ()-> new NotFound("Maintenance","id",id)
        );
        if(entretien.getName() != null)
            updatedMaintenance.setName(entretien.getName());
        if(entretien.getAmount() != 0)
            updatedMaintenance.setAmount(entretien.getAmount());

        return updatedMaintenance;
    }

    @Override
    public void deleteMaintenance(Long id) {
        entretienRepository.deleteById(id);
    }
}
