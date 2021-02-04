package com.sinensia.medicdata.backend.business.services;

import java.util.List;

import com.sinensia.medicdata.backend.business.model.Usuario;

public interface UsuarioServices {
	
	public Usuario read(String dni);
	
	public List<Usuario> getAll();

	public Usuario save(Usuario usuario);
}
