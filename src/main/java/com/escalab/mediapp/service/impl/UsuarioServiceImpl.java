package com.escalab.mediapp.service.impl;

import com.escalab.mediapp.entity.Usuario;
import com.escalab.mediapp.repository.UsuarioRepository;
import com.escalab.mediapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl  implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario save(Usuario obj) {
		return usuarioRepository.save(obj);
	}

	@Override
	public Usuario update(Usuario obj) {
		return usuarioRepository.save(obj);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Integer id) {
		Optional<Usuario> op = usuarioRepository.findById(id);
		return op.isPresent() ? op.get() : new Usuario(); 
	}

	@Override
	public boolean deleteById(Integer id) {
		usuarioRepository.deleteById(id);
		return true;
	}
	
	
}

