package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.MaintenanceVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceVehicleRepository extends JpaRepository<MaintenanceVehicle,Long> {
}
