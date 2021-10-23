package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance,Long> {

}
