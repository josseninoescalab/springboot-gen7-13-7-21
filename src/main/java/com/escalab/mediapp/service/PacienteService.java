package com.escalab.mediapp.service;

import com.escalab.mediapp.entity.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> findAll();

    Paciente findById(Integer id);

    Paciente findByDniAndNombre(String dni, String nombre);

    Paciente save(Paciente paciente);

    Paciente update(Paciente paciente, Integer id);
}
