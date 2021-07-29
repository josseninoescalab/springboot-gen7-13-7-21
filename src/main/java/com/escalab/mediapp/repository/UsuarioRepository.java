package com.escalab.mediapp.repository;

import com.escalab.mediapp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	//select * from usuario where username = ?
	Usuario findOneByNombreUsuario(String username);

}
