package com.medicdata.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicdata.integration.model.UsuarioPL;

@Repository
public interface UsuarioPLRepository extends JpaRepository<UsuarioPL, String> {

}
