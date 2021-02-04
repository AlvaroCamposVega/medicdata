package com.sinensia.medicdata.backend.business.services;

import java.util.List;

import com.sinensia.medicdata.backend.business.model.Reporte;

public interface ReporteServices {

	public Reporte read (int id);
	
	public List<Reporte> getAll();
	
	public Reporte save(Reporte reporte);
}
