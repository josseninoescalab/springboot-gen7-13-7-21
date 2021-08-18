package com.escalab.mediapp.repository;

import com.escalab.mediapp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LoginRepository extends JpaRepository<Usuario, Integer> {

    @Query("FROM Usuario us where us.nombreUsuario = :usuario")
    Usuario verificarNombreUsuario(@Param("usuario") String usuario) throws Exception;

    //Usuario findOneByUsername(String usuario)

    @Transactional
    @Modifying
    @Query("UPDATE Usuario us SET us.password = :clave WHERE us.nombreUsuario = :nombre")
    void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre) throws Exception;

}
