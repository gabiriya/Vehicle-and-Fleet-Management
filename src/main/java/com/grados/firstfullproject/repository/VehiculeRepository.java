package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {


    @Transactional
    @Modifying
    @Query("delete from Vehicule v where v.conducteur.id = :id")
    void deleteAllVehiculeWithConduct(@Param("id") Long id);

}
