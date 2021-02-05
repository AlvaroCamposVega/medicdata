package com.sinensia.medicdata.backend.presentation.restcontrollers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.medicdata.backend.integration.repositories.ReportePLRepository;
import com.sinensia.medicdata.backend.integration.repositories.UsuarioPLRepository;

@RestController
@CrossOrigin
@RequestMapping("/rest/pruebas")
public class PruebasController {

	@Autowired
	private UsuarioPLRepository usuarioPLRepository;
	
	@Autowired
	private ReportePLRepository reportePLRepository;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@GetMapping("/prueba1")
	public List<Object[]> getPresionArterialMediaDadoUnMes() {
		
		return reportePLRepository.getPresionArterialMediaDadoUnMes("271949805-X", 2020, 1);
	}
	
	@GetMapping("/prueba2")
	public List<Object> getPesoMedioDadoUnMes() {
		
		return reportePLRepository.getPesoMedioDadoUnMes("271949805-X", 1);
	}
	
	@GetMapping("/prueba3")
	public List<Object[]> getPesoMedioCadaMesAnyo() {
		
		return reportePLRepository.getPesoMedioCadaMesAnyo("409048585-M", 2020);
	}
	
	@GetMapping("/prueba4")
	public List<Object> getCantidadLecturasPresionesAltas() {
		
		Date fechaInicio = null;
		Date fechaFin = null;
		
		try {
			fechaInicio = sdf.parse("2019-01-01");
			fechaFin = sdf.parse("2019-10-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reportePLRepository.getCantidadLecturasPresionesAltas("640494454-S", 1, fechaInicio, fechaFin);
	}
	
	@GetMapping("/prueba5")
	public List<Object> getDiferenciaPeso() {
		
		Date fechaInicio = null;
		Date fechaFin = null;
		
		try {
			fechaInicio = sdf.parse("2019-01-01");
			fechaFin = sdf.parse("2019-10-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reportePLRepository.getDiferenciaPeso("640494454-S", fechaInicio, fechaFin);
	}
}
