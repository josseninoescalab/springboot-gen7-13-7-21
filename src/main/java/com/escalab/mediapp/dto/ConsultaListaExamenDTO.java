package com.escalab.mediapp.dto;

import com.escalab.mediapp.entity.Consulta;
import com.escalab.mediapp.entity.Examen;
import java.util.List;

public class ConsultaListaExamenDTO {

  private Consulta consulta;
  private List<Examen> examenList;

  public Consulta getConsulta() {
    return consulta;
  }

  public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
  }

  public List<Examen> getExamenList() {
    return examenList;
  }

  public void setExamenList(List<Examen> examenList) {
    this.examenList = examenList;
  }
}
