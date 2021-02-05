package com.sinensia.medicdata.helpers;

import org.springframework.stereotype.Component;

import com.sinensia.medicdata.backend.business.model.Geolocalizacion;
import com.sinensia.medicdata.backend.business.model.PresionArterial;
import com.sinensia.medicdata.backend.business.model.Reporte;
import com.sinensia.medicdata.backend.business.model.Sexo;
import com.sinensia.medicdata.backend.business.model.Usuario;
import com.sinensia.medicdata.backend.integration.model.GeolocalizacionPL;
import com.sinensia.medicdata.backend.integration.model.PresionArterialPL;
import com.sinensia.medicdata.backend.integration.model.ReportePL;
import com.sinensia.medicdata.backend.integration.model.SexoPL;
import com.sinensia.medicdata.backend.integration.model.UsuarioPL;

@Component
public class Sala4Mapper {

	public ReportePL convertReporteToReportePL(Reporte reporte) {

		ReportePL reportePL = new ReportePL();

		GeolocalizacionPL geolocalizacionPL = new GeolocalizacionPL();
		geolocalizacionPL.setLatitud(reporte.getGeolocalizacion().getLatitud());
		geolocalizacionPL.setLongitud(reporte.getGeolocalizacion().getLongitud());

		PresionArterialPL presionArterialPL = new PresionArterialPL();
		presionArterialPL.setPresionMinima(reporte.getPresionArterial().getPresionMinima());
		presionArterialPL.setPresionMaxima(reporte.getPresionArterial().getPresionMaxima());

		UsuarioPL usuarioPL = new UsuarioPL();
		usuarioPL.setAltura(reporte.getUsuario().getAltura());
		usuarioPL.setApellido1(reporte.getUsuario().getApellido1());
		usuarioPL.setApellido2(reporte.getUsuario().getApellido2());
		usuarioPL.setDni(reporte.getUsuario().getDni());
		usuarioPL.setFechaNacimiento(reporte.getUsuario().getFechaNacimiento());
		usuarioPL.setNombre(reporte.getUsuario().getNombre());
		usuarioPL.setObservaciones(reporte.getUsuario().getObservaciones());
		
		if (reporte.getUsuario().getSexo() != null) {
			usuarioPL.setSexo(SexoPL.valueOf(reporte.getUsuario().getSexo().toString()));
		}

		reportePL.setId(reporte.getId());
		reportePL.setFechaReporte(reporte.getFechaReporte());
		reportePL.setPasos(reporte.getPasos());
		reportePL.setGeolocalizacion(geolocalizacionPL);
		reportePL.setPresionArterial(presionArterialPL);
		reportePL.setPeso(reporte.getPeso());
		reportePL.setUsuario(usuarioPL);

		return reportePL;
	}

	public Reporte convertReportePLToReporte(ReportePL reportePL) {

		Reporte reporte = new Reporte();

		Geolocalizacion geolocalizacion = new Geolocalizacion();
		geolocalizacion.setLatitud(reportePL.getGeolocalizacion().getLatitud());
		geolocalizacion.setLongitud(reportePL.getGeolocalizacion().getLongitud());

		PresionArterial presionArterial = new PresionArterial();
		presionArterial.setPresionMinima(reportePL.getPresionArterial().getPresionMinima());
		presionArterial.setPresionMaxima(reportePL.getPresionArterial().getPresionMaxima());

		Usuario usuario = new Usuario();
		usuario.setAltura(reportePL.getUsuario().getAltura());
		usuario.setApellido1(reportePL.getUsuario().getApellido1());
		usuario.setApellido2(reportePL.getUsuario().getApellido2());
		usuario.setDni(reportePL.getUsuario().getDni());
		usuario.setFechaNacimiento(reportePL.getUsuario().getFechaNacimiento());
		usuario.setNombre(reportePL.getUsuario().getNombre());
		usuario.setObservaciones(reportePL.getUsuario().getObservaciones());
		
		if (reportePL.getUsuario().getSexo() != null) {
			usuario.setSexo(Sexo.valueOf(reportePL.getUsuario().getSexo().toString()));
		}

		reporte.setId(reportePL.getId());
		reporte.setFechaReporte(reportePL.getFechaReporte());
		reporte.setPasos(reportePL.getPasos());
		reporte.setGeolocalizacion(geolocalizacion);
		reporte.setPresionArterial(presionArterial);
		reporte.setPeso(reportePL.getPeso());
		reporte.setUsuario(usuario);

		return reporte;
	}

	public UsuarioPL convertUsuarioToUsuarioPL(Usuario usuario) {

		UsuarioPL usuarioPL = new UsuarioPL();

		usuarioPL.setAltura(usuario.getAltura());
		usuarioPL.setApellido1(usuario.getApellido1());
		usuarioPL.setApellido2(usuario.getApellido2());
		usuarioPL.setDni(usuario.getDni());
		usuarioPL.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioPL.setNombre(usuario.getNombre());
		usuarioPL.setObservaciones(usuario.getObservaciones());
		
		if (usuario.getSexo() != null) {
			usuarioPL.setSexo(SexoPL.valueOf(usuario.getSexo().toString()));
		}

		return usuarioPL;
	}

	public Usuario convertUsuarioPLToUsuario(UsuarioPL usuarioPL) {

		Usuario usuario = new Usuario();

		usuario.setAltura(usuarioPL.getAltura());
		usuario.setApellido1(usuarioPL.getApellido1());
		usuario.setApellido2(usuarioPL.getApellido2());
		usuario.setDni(usuarioPL.getDni());
		usuario.setFechaNacimiento(usuarioPL.getFechaNacimiento());
		usuario.setNombre(usuarioPL.getNombre());
		usuario.setObservaciones(usuarioPL.getObservaciones());
		
		if (usuarioPL.getSexo() != null) {
			usuario.setSexo(Sexo.valueOf(usuarioPL.getSexo().toString()));
		}

		return usuario;
	}
}
