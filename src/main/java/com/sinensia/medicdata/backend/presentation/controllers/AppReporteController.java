package com.sinensia.medicdata.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinensia.medicdata.backend.business.model.Reporte;
import com.sinensia.medicdata.backend.business.services.ReporteServices;

@Controller
@RequestMapping("/medicdata")
public class AppReporteController {

	@Autowired
	private ReporteServices reporteServices;

	@RequestMapping("/listado-reportes")
	public String getListadoReportes(Model model) {

		List<Reporte> reportes = reporteServices.getAll();
		model.addAttribute("reportes", reportes);

		return "reportes";

	}
	
	@RequestMapping("/detalle-reporte/{id}")
	public String getByCodigo(@PathVariable Integer id, Model model) {

		Reporte reporte = reporteServices.read(id);
		model.addAttribute("reporte", reporte);

		return "detalle_reporte";
	}

}
