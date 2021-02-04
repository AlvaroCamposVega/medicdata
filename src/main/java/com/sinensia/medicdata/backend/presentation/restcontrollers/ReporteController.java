package com.sinensia.medicdata.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.medicdata.backend.business.model.Reporte;
import com.sinensia.medicdata.backend.business.services.ReporteServices;

@RestController
@CrossOrigin
@RequestMapping("/rest/reportes")
public class ReporteController {
	
	@Autowired
	private ReporteServices reporteServices;
	
	@GetMapping
	public List<Reporte>getAll(){
		return reporteServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Reporte getByCodigo(@PathVariable("id") Integer id) {
		return reporteServices.read(id);
	}
	
	@PostMapping
	public Reporte create(@RequestBody Reporte reporte) {
		return reporteServices.save(reporte);
	}

}
