package com.escalab.mediapp.dto;

import java.io.Serializable;
import org.springframework.hateoas.ResourceSupport;

public class ConsultaDTO extends ResourceSupport implements Serializable {

  private Integer idConsulta;
  private PacienteDTO pacienteDTO;
  private MedicoDTO medicoDTO;

  public Integer getIdConsulta() {
    return idConsulta;
  }

  public void setIdConsulta(Integer idConsulta) {
    this.idConsulta = idConsulta;
  }

  public PacienteDTO getPacienteDTO() {
    return pacienteDTO;
  }

  public void setPacienteDTO(PacienteDTO pacienteDTO) {
    this.pacienteDTO = pacienteDTO;
  }

  public MedicoDTO getMedicoDTO() {
    return medicoDTO;
  }

  public void setMedicoDTO(MedicoDTO medicoDTO) {
    this.medicoDTO = medicoDTO;
  }
}
