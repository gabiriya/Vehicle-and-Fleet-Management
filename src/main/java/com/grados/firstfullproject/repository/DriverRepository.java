package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    @Query("select d from Driver d")
    List<Driver> findAllDrivers();
}
