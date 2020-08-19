package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v_reaccion")
public class VistaReaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "pelicula")
    String pelicula;

    @Column(name = "correo")
    String correo;

    @Column(name = "fecha_registro")
    Date fecha_registro;

    @Column(name = "comentarios")
    String comentarios;

    @Column(name = "tipo_reaccion")
    String tipo_reaccion;

    public long getId() {
        return id;
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public String getComentarios() {
        return comentarios;
    }

    public String getTipo_reaccion() {
        return tipo_reaccion;
    }

    public VistaReaccion() {
    }

    public VistaReaccion(long id, String pelicula, String correo, Date fecha_registro, String comentarios, String tipo_reaccion) {
        this.id = id;
        this.pelicula = pelicula;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
        this.comentarios = comentarios;
        this.tipo_reaccion = tipo_reaccion;
    }
}
