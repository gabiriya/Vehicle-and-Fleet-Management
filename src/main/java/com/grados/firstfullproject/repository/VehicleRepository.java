package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {


//    @Transactional
//    @Modifying
//    @Query("delete from Vehicle v where v.d.id = :id")
//    void deleteAllVehiculeWithConduct(@Param("id") Long id);

    @Query("select v from Vehicle v")
    List<Vehicle> findAllVehicules();
}
