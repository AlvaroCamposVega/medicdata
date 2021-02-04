package com.sinensia.medicdata.backend.integration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="REPORTES")
public class ReportePL {
	
	@Id
	@TableGenerator(
		name="REPORTES_SEQ",
		table="REPORTES",
		pkColumnName = "NOMBRE",
		pkColumnValue="REPORTES_SEQ",
		valueColumnName="GENERADOR",
		allocationSize = 1
	)
	@GeneratedValue(generator="REPORTES_SEQ", strategy=GenerationType.TABLE)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private UsuarioPL usuario;
	
	@Column(name="FECHA_REPORTE")
	private Date fechaReporte;
	
	@Embedded
	private GeolocalizacionPL geolocalizacion;
	
	private double peso;
	
	@Embedded
	private PresionArterialPL presionArterial;
	
	private int pasos;

	public ReportePL() {
		
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

	public GeolocalizacionPL getGeolocalizacion() {
		return geolocalizacion;
	}

	public void setGeolocalizacion(GeolocalizacionPL geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public PresionArterialPL getPresionArterial() {
		return presionArterial;
	}

	public void setPresionArterial(PresionArterialPL presionArterial) {
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
		ReportePL other = (ReportePL) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReportePL [id=" + id + ", usuario=" + usuario + ", fechaReporte=" + fechaReporte + ", geolocalizacion="
				+ geolocalizacion + ", peso=" + peso + ", presionArterial=" + presionArterial + ", pasos=" + pasos
				+ "]";
	}

}
