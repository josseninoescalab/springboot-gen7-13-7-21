package com.escalab.mediapp.repository;

import com.escalab.mediapp.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    //select * from paciente where dni = ? and nombres = ?
    Paciente findPacienteByDniAndNombres(String dni, String nombres);

    Paciente findPacienteByNombres(String nombres);

    Paciente findPacienteByDni(String dni);

}
