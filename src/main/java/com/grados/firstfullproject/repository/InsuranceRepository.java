package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {

    @Query(value = "select i.* from vehicle v , insurance i ,driver d where v.id = i.id_vehicle_fk and d.id = v.id_driver_fk and d.id = :idD and v.id = :idV",
            nativeQuery = true )

    List<Insurance> findAllByVehicle(@Param("idD") Long idD ,@Param("idV") Long idV);

    @Query(value = "select i.* from vehicle v , insurance i ,driver d where v.id = i.id_vehicle_fk and d.id = v.id_driver_fk and d.id = :idD and v.id = :idV and i.id = :idI",
    nativeQuery = true)
    Optional<Insurance> findInsuranceById(@Param("idD") Long idD , @Param("idV") Long idV, @Param("idI") Long idI);


//    @Transactional
//    @Modifying
//    @Query("delete from ")
//    void deleteInsuranceById(@Param("idD") Long idD,@Param("idVec") Long idVec,@Param("idIns") Long idIns)
}
