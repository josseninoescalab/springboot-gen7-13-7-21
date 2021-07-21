package com.escalab.mediapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private Integer idUsuario;

    @Column(name = "nombre")
    private String nombreUsuario;

    @Column(name = "clave")
    private String password;

    @Column(name = "estado")
    private boolean status;

    @ManyToMany
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private List<Rol> roles;
}
