package com.escalab.mediapp.service.impl;

import com.escalab.mediapp.entity.ConsultaExamen;
import com.escalab.mediapp.repository.ConsultaExamenRepository;
import com.escalab.mediapp.service.ConsultaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService {
	
	@Autowired
	private ConsultaExamenRepository consultaExamenRepository;
}
