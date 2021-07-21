package com.escalab.mediapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Integer idRol;
    private String nombre;
}
