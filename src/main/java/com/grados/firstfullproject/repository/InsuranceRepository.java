package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {

    @Query(value = "select i.* from insurance i , vehicle v where i.id = v.insurance_id and  v.id = :idVec",
            nativeQuery = true )

    List<Insurance> findAllByVehicle(@Param("idVec") Long idVec);

    @Query(value = "select i.* from insurance i , vehicle v where i.id = v.insurance_id and  v.id = :idVec and i.id = :idIns",
    nativeQuery = true)
    Insurance findInsuranceById(@Param("idVec") Long idVec, @Param("idIns") Long idIns);
}
