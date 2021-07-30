package com.escalab.mediapp.service.impl;

import com.escalab.mediapp.dto.ConsultaDTO;
import com.escalab.mediapp.dto.ConsultaListaExamenDTO;
import com.escalab.mediapp.dto.MedicoDTO;
import com.escalab.mediapp.dto.PacienteDTO;
import com.escalab.mediapp.entity.Consulta;
import com.escalab.mediapp.repository.ConsultaExamenRepository;
import com.escalab.mediapp.repository.ConsultaRepository;
import com.escalab.mediapp.service.ConsultaService;
import com.escalab.mediapp.service.EspecialidadService;
import com.escalab.mediapp.service.MedicoService;
import com.escalab.mediapp.service.PacienteService;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired	
	private ConsultaRepository consultaRepository;

	@Autowired
	private ConsultaExamenRepository consultaExamenRepository;
	
	@Override
	public Consulta save(Consulta obj) {
		obj.getDetalleConsulta().forEach(det -> {
			det.setConsulta(obj);
		});
		return consultaRepository.save(obj);
	}

	@Override
	public Consulta update(Consulta obj) {
		return consultaRepository.save(obj);
	}

	@Override
	public List<Consulta> findAll() {
		return consultaRepository.findAll();
	}

	@Override
	public Consulta findById(Integer id){
		Optional<Consulta> op = consultaRepository.findById(id);
		/*if(!op.isPresent()) {
			throw new Exception("ID NO ENCONTRADO " + id);
		}*/
		return op.get();
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Consulta> obj = consultaRepository.findById(id);
		if(!obj.isPresent()) {
			throw new Exception("ID NO ENCONTRADO " + id);
		}
		consultaRepository.deleteById(id);
		return true;
	}

	@Override
	public List<ConsultaDTO> findAllConsultas() {
		List<ConsultaDTO> response = new ArrayList<>();
		List<Consulta> consultas = consultaRepository.findAll();
		consultas.forEach(consulta -> {
			ConsultaDTO consultaDTO = new ConsultaDTO();
			consultaDTO.setIdConsulta(consulta.getIdConsulta());
			PacienteDTO pacienteDTO = new PacienteDTO();
			pacienteDTO.setNombres(consulta.getPaciente().getNombres());
			pacienteDTO.setApellidos(consulta.getPaciente().getApellidos());
			pacienteDTO.setDni(consulta.getPaciente().getDni());
			pacienteDTO.setTelefono(consulta.getPaciente().getTelefono());
			pacienteDTO.setEmail(consulta.getPaciente().getEmail());
			consultaDTO.setPacienteDTO(pacienteDTO);
			MedicoDTO medicoDTO = new MedicoDTO();
			medicoDTO.setNombres(consulta.getMedico().getNombres());
			medicoDTO.setApellidos(consulta.getMedico().getApellidos());
			medicoDTO.setFotoUrl(consulta.getMedico().getFotoUrl());
			medicoDTO.setCmp(consulta.getMedico().getCmp());
			consultaDTO.setMedicoDTO(medicoDTO);
			response.add(consultaDTO);
		});
		return response;
	}

	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) {
		dto.getConsulta().getDetalleConsulta().forEach(det -> {
			det.setConsulta(dto.getConsulta());
		});
		consultaRepository.save(dto.getConsulta());
		dto.getExamenList().forEach(ex -> consultaExamenRepository.registrar(dto.getConsulta().getIdConsulta(),
				ex.getIdExamen()));
		return dto.getConsulta();
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


