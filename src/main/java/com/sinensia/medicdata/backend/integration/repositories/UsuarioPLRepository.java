package com.sinensia.medicdata.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinensia.medicdata.backend.integration.model.UsuarioPL;

@Repository
public interface UsuarioPLRepository extends JpaRepository<UsuarioPL, String> {

}
