package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {


//    @Transactional
//    @Modifying
//    @Query("delete from Vehicle v where v.d.id = :id")
//    void deleteAllVehiculeWithConduct(@Param("id") Long id);

    @Query("select v from Vehicle v, Driver d where d.id = :idDriver")
    List<Vehicle> findAllVehicles(@Param("idDriver") Long idDriver);

    @Query(value = "select v.* from vehicle v where id = :idVec and id_driver_fk = :idDriver",
    nativeQuery = true)
    Optional<Vehicle> findVehicleById(@Param("idDriver") Long idDriver,@Param("idVec") Long idVec);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM vehicle where id = :idVehicle and id_driver_fk = :idDriver",
            nativeQuery = true)
    void deleteVehicleById( @Param("idDriver") Long idDriver,@Param("idVehicle") Long idVehicle);

    @Query(value = "select v.id, v.brand, v.date_of_purchase, v.horse_power, v.model, v.id_driver_fk, i.id from vehicle v , insurance i where v.id = i.id_vehicle_fk",
    nativeQuery = true)
    List<Vehicle> findAllBeta();
}
