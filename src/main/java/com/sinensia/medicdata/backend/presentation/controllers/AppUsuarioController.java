package com.sinensia.medicdata.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinensia.medicdata.backend.business.model.Usuario;
import com.sinensia.medicdata.backend.business.services.UsuarioServices;

import org.springframework.ui.Model;

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

}
