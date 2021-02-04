package com.sinensia.medicdata.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.medicdata.backend.business.model.Usuario;
import com.sinensia.medicdata.backend.business.services.UsuarioServices;
import com.sinensia.medicdata.backend.integration.model.UsuarioPL;
import com.sinensia.medicdata.backend.integration.repositories.UsuarioPLRepository;
import com.sinensia.medicdata.helpers.Sala4Mapper;

@Service
public class UsuarioServiceImpl implements UsuarioServices {

	@Autowired
	private Sala4Mapper sala4Mapper;

	// @Autowired
	// private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private UsuarioPLRepository usuarioPLRepository;

	@Override
	public Usuario read(String dni) {

		Optional<UsuarioPL> optionalUsuarioPL = usuarioPLRepository.findById(dni);

		UsuarioPL usuarioPL = optionalUsuarioPL.isPresent() ? optionalUsuarioPL.get() : null;

		// Usuario usuario = dozerBeanMapper.map(usuarioPL, Usuario.class);

		Usuario usuario = sala4Mapper.convertUsuarioPLToUsuario(usuarioPL);

		return usuario;
	}

	@Override
	public List<Usuario> getAll() {

		List<UsuarioPL> usuariosPL = usuarioPLRepository.findAll();

		List<Usuario> usuarios = new ArrayList<>();

		for (UsuarioPL usuarioPL : usuariosPL) {
			// usuarios.add(dozerBeanMapper.map(usuarioPL, Usuario.class));
			usuarios.add(sala4Mapper.convertUsuarioPLToUsuario(usuarioPL));
		}

		return usuarios;
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {

		// UsuarioPL usuarioPL = dozerBeanMapper.map(usuario, UsuarioPL.class);
		
		UsuarioPL usuarioPL = sala4Mapper.convertUsuarioToUsuarioPL(usuario);

		UsuarioPL createdUsuarioPL = usuarioPLRepository.save(usuarioPL);

		// Usuario createdUsuario = dozerBeanMapper.map(createdUsuarioPL, Usuario.class);
		
		Usuario createdUsuario = sala4Mapper.convertUsuarioPLToUsuario(createdUsuarioPL);

		return createdUsuario;
	}
}
