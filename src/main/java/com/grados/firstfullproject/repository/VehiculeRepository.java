package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {

    @Query("delete from Vehicule where conducteur = :id")
    void deleteAllVehiculeWithConduct(@Param("id") Long id);
}
