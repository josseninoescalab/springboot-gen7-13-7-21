package com.escalab.mediapp.service.impl;

import com.escalab.mediapp.entity.Paciente;
import com.escalab.mediapp.exceptions.ModeloNotFoundException;
import com.escalab.mediapp.repository.PacienteRepository;
import com.escalab.mediapp.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAll() {
        //ir a la base de datos y obtener todos los pacientes sin filtro (select * from paciente)
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente findById(Integer id) {
        //ir a la base de datos y obtener el aciente por id (select * from paciente where id = {id})
        Optional<Paciente> pacienteO = pacienteRepository.findById(id);
        if(pacienteO.isPresent()){
            return pacienteO.get();
        }else{
            throw new ModeloNotFoundException("El paciente no existe o es nulo");
        }
    }

    @Override
    public Paciente findByDniAndNombre(String dni, String nombre) {
        //ir a la base de datos y obtener el aciente por id (select * from paciente where dni = {dni} and nombre = {nombre})
        Paciente paciente = new Paciente();
        if(dni == null || dni.equalsIgnoreCase("")){
            if(nombre != null && !"".equalsIgnoreCase(dni)){
                paciente = pacienteRepository.findPacienteByNombres(nombre);
            }
        }else{
            if(nombre == null || "".equalsIgnoreCase(nombre)){
                paciente = pacienteRepository.findPacienteByDni(dni);
            }else {
                paciente = pacienteRepository.findPacienteByDniAndNombres(dni, nombre);
            }
        }
        return paciente;
    }

    @Override
    public Paciente save(Paciente paciente) {
        //guardar el paciente (insert into)
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente, Integer id) {
        Paciente p = new Paciente();
        if(id != null && id > 0){
            Optional<Paciente> po = pacienteRepository.findById(id);
            if(po.isPresent()){
                paciente.setId(id);
                p = pacienteRepository.save(paciente);
            }else{
                throw new ModeloNotFoundException("El paciente no existe o es nulo");
            }
        }else{
            //no se puede actualizar dado que el id es nulo o no existe
        }
        //actualizar paciente (update paciente set nombre = {nombre}, ...)
        return p;
    }

    @Override
    public void delete(Integer id) {
        pacienteRepository.deleteById(id);
    }
}
