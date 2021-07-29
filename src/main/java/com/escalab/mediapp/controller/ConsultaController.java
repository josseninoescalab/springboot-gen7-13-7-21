package com.escalab.mediapp.controller;

import com.escalab.mediapp.entity.Consulta;
import com.escalab.mediapp.service.ArchivoService;
import com.escalab.mediapp.service.ConsultaService;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService service;

	@Autowired
	private ArchivoService serviceArchivo;

	@GetMapping
	public ResponseEntity<List<Consulta>> findAll(){
		List<Consulta> lista = service.findAll();
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Consulta obj = service.findById(id);
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}


	@PutMapping
	public ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta consulta) {
		Consulta obj = service.update(consulta);
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
		service.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {

		byte[] arr = serviceArchivo.leerArchivo(idArchivo);

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}

}

