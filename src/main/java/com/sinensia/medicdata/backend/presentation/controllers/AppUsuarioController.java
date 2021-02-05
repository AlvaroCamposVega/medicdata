package com.sinensia.medicdata.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinensia.medicdata.backend.business.model.Reporte;
import com.sinensia.medicdata.backend.business.model.Usuario;
import com.sinensia.medicdata.backend.business.services.UsuarioServices;

@Controller
@RequestMapping("/medicdata")
public class AppUsuarioController {

	@Autowired
	private UsuarioServices usuarioServices;

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
	
	@RequestMapping(value="/nuevo-reporte",
            method=RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Reporte crearReporte(@RequestBody MultiValueMap<String, String> datosFormulario) {
		System.out.println(datosFormulario.get("dni"));
		return null;
//		Reporte reporteNuevo=new Reporte();
//		Usuario usuario=new Usuario();
//		usuario.setDni(datosFormulario.get("dni").toString());
//		reporteNuevo.setUsuario(new Usuario);(datosFormulario.get("dni"));
//
//		
//		usuarioServices.save(reporteNuevo);
//		
//		return reporteNuevo;
	}

}
