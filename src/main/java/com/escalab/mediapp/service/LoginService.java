package com.escalab.mediapp.service;

import com.escalab.mediapp.entity.Usuario;

public interface LoginService {

    Usuario verificarNombreUsuario(String usuario) throws Exception;
    int cambiarClave(String clave, String nombre) throws Exception;

}
