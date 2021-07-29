package com.escalab.mediapp.repository;

import com.escalab.mediapp.entity.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivoRepository extends JpaRepository<Archivo, Integer> {
	
}
