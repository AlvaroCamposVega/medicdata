package com.sinensia.medicdata.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinensia.medicdata.backend.business.model.Usuario;
import com.sinensia.medicdata.backend.business.services.UsuarioServices;

import org.springframework.ui.Model;

public class AppUsuarioController {
	
	@Autowired
	private UsuarioServices usuarioServices;
	
	@RequestMapping("/listado-usuarios")
	public String getListadoUsuarios(Model model) {
		
		List<Usuario>usuarios=usuarioServices.getAll();
		model.addAttribute("usuarios",usuarios);
		
		return "usuarios";
		
	}

}
