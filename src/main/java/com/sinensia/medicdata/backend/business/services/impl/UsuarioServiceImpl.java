package com.sinensia.medicdata.backend.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicdata.integration.model.UsuarioPL;
import com.sinensia.medicdata.backend.business.model.Usuario;
import com.sinensia.medicdata.backend.business.services.UsuarioServices;

@Service
public class UsuarioServiceImpl implements UsuarioServices{
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	 
	@Autowired
	private UsuarioPLRepository usuarioPLRepository;
	
	@Override
	public Usuario read(String dni) {
	
		Optional<UsuarioPL> optionalUsuarioPL = usuarioPLRepository.findBy(dni);
		
		UsuarioPL usuarioPL = optionalUsuarioPL.isPresent()
		return null;
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
