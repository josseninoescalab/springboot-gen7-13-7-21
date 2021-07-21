package com.escalab.mediapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name = "id_paciente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nombres", length = 70)
    private String nombres;

    @Column(name = "apellido", length = 70)
    private String apellidos;

    @Column(name = "dni", length = 30)
    private String dni;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;}
