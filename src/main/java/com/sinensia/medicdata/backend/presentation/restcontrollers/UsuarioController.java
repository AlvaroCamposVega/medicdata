package com.sinensia.medicdata.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.medicdata.backend.business.model.Reporte;
import com.sinensia.medicdata.backend.business.model.Usuario;
import com.sinensia.medicdata.backend.business.services.ReporteServices;
import com.sinensia.medicdata.backend.business.services.UsuarioServices;

@RestController
@CrossOrigin
@RequestMapping("/rest/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServices usuarioServices;
	
	@Autowired
	private ReporteServices reporteServices;
	
	@GetMapping
	public List<Usuario>getAll(){
		return usuarioServices.getAll();
	}
	
	@GetMapping("/{dni}")
	public Usuario getByCodigo(@PathVariable("dni") String dni) {
		return usuarioServices.read(dni);
	}
	
	@GetMapping("/{dni}/reportes")
	public List<Reporte> getReportesByCodigoUsuario(@PathVariable("dni") String dni) {
		return reporteServices.findByUsuarioDni(dni);
	}
	
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioServices.save(usuario);
	}

}