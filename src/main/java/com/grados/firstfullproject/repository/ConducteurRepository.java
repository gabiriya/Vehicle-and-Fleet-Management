package com.grados.firstfullproject.repository;

import com.grados.firstfullproject.entities.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur,Long> {

}
