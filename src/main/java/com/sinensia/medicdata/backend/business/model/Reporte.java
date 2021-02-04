package com.sinensia.medicdata.backend.business.model;

import java.util.Date;

import com.sinensia.medicdata.backend.integration.model.UsuarioPL;

public class Reporte {

	private int             id;
	private UsuarioPL       usuario;
	private Date            fechaReporte;
	private Geolocalizacion geolocalizacion;
	private double          peso;
	private PresionArterial presionArterial;
	private int             pasos;
	
	public Reporte() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UsuarioPL getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioPL usuario) {
		this.usuario = usuario;
	}

	public Date getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(Date fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public Geolocalizacion getGeolocalizacion() {
		return geolocalizacion;
	}

	public void setGeolocalizacion(Geolocalizacion geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public PresionArterial getPresionArterial() {
		return presionArterial;
	}

	public void setPresionArterial(PresionArterial presionArterial) {
		this.presionArterial = presionArterial;
	}

	public int getPasos() {
		return pasos;
	}

	public void setPasos(int pasos) {
		this.pasos = pasos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reporte other = (Reporte) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reporte [id=" + id + ", fechaReporte=" + fechaReporte + ", geolocalizacion=" + geolocalizacion
				+ ", peso=" + peso + ", presionArterial=" + presionArterial + ", pasos=" + pasos + "]";
	}

}