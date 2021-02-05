package com.sinensia.medicdata.backend.presentation.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinensia.medicdata.backend.business.model.Geolocalizacion;
import com.sinensia.medicdata.backend.business.model.PresionArterial;
import com.sinensia.medicdata.backend.business.model.Reporte;
import com.sinensia.medicdata.backend.business.model.Usuario;
import com.sinensia.medicdata.backend.business.services.ReporteServices;
import com.sinensia.medicdata.backend.business.services.UsuarioServices;

@Controller
@RequestMapping("/medicdata")
public class AppUsuarioController {

	@Autowired
	private UsuarioServices usuarioServices;

	@Autowired
	private ReporteServices reporteServices;

	@RequestMapping("/listado-usuarios")
	public String getAll(Model model) {

		List<Usuario> usuarios = usuarioServices.getAll();
		model.addAttribute("usuarios", usuarios);

		return "usuarios";

	}

	@RequestMapping("/detalle-usuario/{dni}")
	public String getByCodigo(@PathVariable String dni, Model model) {

		Usuario usuario = usuarioServices.read(dni);
		model.addAttribute("usuario", usuario);

		return "detalle_usuario";
	}

	@RequestMapping("/nuevo-reporte/{dni}")
	public String nuevoReporte(@PathVariable String dni, Model model) {

		model.addAttribute("dni", dni);

		return "nuevo_reporte";
	}

	@RequestMapping(value = "/nuevo-reporte", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void crearReporte(
			@RequestBody MultiValueMap<String, String> datosFormulario,
			HttpServletResponse res
	) throws ParseException {

		Reporte reporteNuevo = new Reporte();

		Usuario usuario = new Usuario();
		usuario.setDni(datosFormulario.get("dni").get(0));
		reporteNuevo.setUsuario(usuario);

		Geolocalizacion geolocalizacion = new Geolocalizacion();
		geolocalizacion.setLatitud(Integer.parseInt(datosFormulario.get("latitud").get(0)));
		geolocalizacion.setLongitud(Integer.parseInt(datosFormulario.get("longitud").get(0)));
		reporteNuevo.setGeolocalizacion(geolocalizacion);

		String fecha = datosFormulario.get("fechaReporte").get(0);
		Date date = null;
		date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		reporteNuevo.setFechaReporte(date);

		PresionArterial presionArterial = new PresionArterial();
		presionArterial.setPresionMaxima(Integer.parseInt(datosFormulario.get("presionMaxima").get(0)));
		presionArterial.setPresionMinima(Integer.parseInt(datosFormulario.get("presionMinima").get(0)));
		reporteNuevo.setPresionArterial(presionArterial);

		reporteNuevo.setPasos(Integer.parseInt(datosFormulario.get("pasos").get(0)));
		reporteNuevo.setPeso(Double.parseDouble(datosFormulario.get("peso").get(0)));

		reporteServices.save(reporteNuevo);
		
		try {
			res.sendRedirect("/medicdata/listado-reportes");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
