package com.sinensia.medicdata.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.medicdata.backend.integration.model.ReportePL;

public interface ReportePLRepository extends JpaRepository<ReportePL, Integer> {

	public List<ReportePL> findByUsuarioDni(String dni);
		
}
