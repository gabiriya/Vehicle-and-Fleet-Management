package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntretienRepository extends JpaRepository<Entretien,Long> {

}
