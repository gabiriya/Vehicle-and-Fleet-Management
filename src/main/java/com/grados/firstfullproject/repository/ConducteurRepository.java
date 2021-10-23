package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConducteurRepository extends JpaRepository<Conducteur,Long> {
}
