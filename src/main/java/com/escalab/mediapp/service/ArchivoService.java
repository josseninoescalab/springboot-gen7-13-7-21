package com.escalab.mediapp.service;

import com.escalab.mediapp.entity.Archivo;

public interface ArchivoService {
	
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);

}
