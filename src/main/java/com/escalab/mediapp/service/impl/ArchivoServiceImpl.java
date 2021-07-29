package com.escalab.mediapp.service.impl;

import com.escalab.mediapp.entity.Archivo;
import com.escalab.mediapp.repository.ArchivoRepository;
import com.escalab.mediapp.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArchivoServiceImpl implements ArchivoService {
	
	@Autowired
	private ArchivoRepository archivoRepository;
	
	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = archivoRepository.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}
	
	@Override
	public byte[] leerArchivo(Integer idArchivo) {
		Optional<Archivo> op = archivoRepository.findById(idArchivo);
		return op.isPresent() ? op.get().getValue() : new byte[0];
	}
}
