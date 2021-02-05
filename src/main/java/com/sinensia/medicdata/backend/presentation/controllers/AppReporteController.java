package com.sinensia.medicdata.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinensia.medicdata.backend.business.model.Reporte;
import com.sinensia.medicdata.backend.business.services.ReporteServices;

public class AppReporteController {

	@Autowired
	private ReporteServices reporteServices;

	@RequestMapping("/listado-reportes")
	public String getListadoReportes(Model model) {

		List<Reporte> reportes = reporteServices.getAll();
		model.addAttribute("reportes", reportes);

		return "reportes";

	}

}