package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "reparto")
public class Reparto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "apellido")
    String apellido;

    @Column(name = "id_pelicula")
    long id_pelicula;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(long id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public Reparto() {
    }

    public Reparto(String nombre, String apellido, long id_pelicula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_pelicula = id_pelicula;
    }

    public Reparto(long id, String nombre, String apellido, long id_pelicula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_pelicula = id_pelicula;
    }
}
