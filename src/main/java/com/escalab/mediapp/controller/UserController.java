package com.escalab.mediapp.controller;

import com.escalab.mediapp.entity.Usuario;
import com.escalab.mediapp.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
	private UsuarioService userService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> lista = userService.findAll();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> leerPorId(@PathVariable("id") Integer id){
		Usuario usuario = userService.findById(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> lista = userService.findAll();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}

}
