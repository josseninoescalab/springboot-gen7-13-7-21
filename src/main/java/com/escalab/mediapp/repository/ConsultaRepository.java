package com.escalab.mediapp.repository;

import com.escalab.mediapp.entity.Consulta;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

  @Query(value = "select * from fn_listarResumen()", nativeQuery = true)
  List<Object[]> listarResumen();
}
