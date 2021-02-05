package com.sinensia.medicdata.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.medicdata.backend.business.model.Reporte;
import com.sinensia.medicdata.backend.business.services.ReporteServices;
import com.sinensia.medicdata.backend.integration.model.ReportePL;
import com.sinensia.medicdata.backend.integration.repositories.ReportePLRepository;
import com.sinensia.medicdata.helpers.Sala4Mapper;

@Service
public class ReporteServiceImpl implements ReporteServices {

	@Autowired
	private Sala4Mapper sala4Mapper;
	
	// @Autowired
	// private DozerBeanMapper dozerBeanMapper;
	 
	@Autowired
	private ReportePLRepository reportePLRepository;
	
	@Override
	public Reporte read(int id) {
		
		Optional<ReportePL> optionalReportePL = reportePLRepository.findById(id);
		
		ReportePL reportePL = optionalReportePL.isPresent() ? optionalReportePL.get() : null;
		
		// Reporte reporte =  dozerBeanMapper.map(reportePL, Reporte.class);
		
		Reporte reporte = sala4Mapper.convertReportePLToReporte(reportePL);
		
		return reporte;
	}

	@Override
	public List<Reporte> getAll() {
		
		List<ReportePL> reportesPL = reportePLRepository.findAll();
		
		List<Reporte> reportes = new ArrayList<>();
		
		for (ReportePL reportePL : reportesPL) {
			// reportes.add(dozerBeanMapper.map(reportePL, Reporte.class));
			
			reportes.add(sala4Mapper.convertReportePLToReporte(reportePL));
		}

		return reportes;
	}

	@Override
	@Transactional
	public Reporte save(Reporte reporte) {
		
		// ReportePL reportePL = dozerBeanMapper.map(reporte, ReportePL.class);
		
		ReportePL reportePL = sala4Mapper.convertReporteToReportePL(reporte);

		ReportePL createdReportePL = reportePLRepository.save(reportePL);

		// Reporte createdReporte = dozerBeanMapper.map(createdReportePL, Reporte.class);
		
		Reporte createdReporte = sala4Mapper.convertReportePLToReporte(createdReportePL);

		return createdReporte;
	}

	@Override
	public List<Reporte> findByUsuarioDni(String dni) {
		
		List<ReportePL> reportesPL = reportePLRepository.findByUsuarioDni(dni);
		
		List<Reporte> reportes = new ArrayList<>();
		
		for (ReportePL reportePL : reportesPL) {
			// reportes.add(dozerBeanMapper.map(reportePL, Reporte.class));
			
			reportes.add(sala4Mapper.convertReportePLToReporte(reportePL));
		}

		return reportes;
	}

}
