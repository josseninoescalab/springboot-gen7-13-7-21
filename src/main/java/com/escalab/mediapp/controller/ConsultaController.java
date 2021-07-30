package com.escalab.mediapp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.escalab.mediapp.dto.ConsultaDTO;
import com.escalab.mediapp.dto.ConsultaListaExamenDTO;
import com.escalab.mediapp.dto.MedicoDTO;
import com.escalab.mediapp.entity.Consulta;
import com.escalab.mediapp.service.ArchivoService;
import com.escalab.mediapp.service.ConsultaService;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id) {
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

	@GetMapping("/dto")
	public List<ConsultaDTO> findAllConsultas() throws Exception{
		List<ConsultaDTO> reponse = new ArrayList<>();
		List<Consulta> consultas = service.findAll();
		consultas.forEach(consulta -> {
			ConsultaDTO d = new ConsultaDTO();

			//localhost:8080/paciente/39
			ControllerLinkBuilder linkTo1 =
					linkTo(methodOn(PacienteController.class).findById((consulta.getPaciente().getId())));
			d.add(linkTo1.withSelfRel());
			reponse.add(d);

			//localhost:8080/	medico/48
			ControllerLinkBuilder linkTo2 =
					linkTo(methodOn(MedicoController.class).listarPorId((consulta.getMedico().getIdMedico())));
			d.add(linkTo2.withSelfRel());
			reponse.add(d);

			ControllerLinkBuilder linkTo =
					linkTo(methodOn(ConsultaController.class).listarPorId((consulta.getIdConsulta())));
			d.add(linkTo.withSelfRel());
			d.setIdConsulta(consulta.getIdConsulta());
			reponse.add(d);
		});
		return reponse;
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody ConsultaListaExamenDTO consultaDTO) {
		Consulta obj = service.registrarTransaccional(consultaDTO);
		//consultas/4
		URI location =
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}
}

