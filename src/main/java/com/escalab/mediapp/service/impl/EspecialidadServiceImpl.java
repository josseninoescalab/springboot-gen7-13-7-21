package com.escalab.mediapp.service.impl;

import com.escalab.mediapp.entity.Especialidad;
import com.escalab.mediapp.repository.EspecialidadRepository;
import com.escalab.mediapp.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public Especialidad save(Especialidad obj) {
		especialidadRepository.save(obj);
		return obj;
	}
	
	@Override
	public Especialidad update(Especialidad obj) {
		return especialidadRepository.save(obj);
	}
	
	@Override
	public List<Especialidad> findAll() {
		return especialidadRepository.findAll();
	}
	
	@Override
	public Especialidad findById(Integer id)  {
		Optional<Especialidad> op = especialidadRepository.findById(id);
//		if (!op.isPresent()) {
//			throw new Exception("ID NO ENCONTRADO" + id);
//		}
		return op.get();
	}
	
	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Especialidad> obj = especialidadRepository.findById(id);
		if (!obj.isPresent()) {
			throw new Exception("ID NO ENCONTRADO" + id);
		}
		especialidadRepository.deleteById(id);
		return true;
	}
}
