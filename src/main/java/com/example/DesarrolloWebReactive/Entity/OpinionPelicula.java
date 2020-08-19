package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "opinion_pelicula")
public class OpinionPelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    long id_registro;

    @Column(name = "id_pelicula")
    long id_pelicula;

    @Column(name = "correo")
    String correo;

    @Column(name = "fecha_registro")
    Date fecha_registro;

    @Column(name = "comentarios")
    String comentarios;

    @Column(name = "id_tipo_reaccion")
    long id_tipo_reaccion;

    public long getId_registro() {
        return id_registro;
    }

    public void setId_registro(long id_registro) {
        this.id_registro = id_registro;
    }

    public long getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(long id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public long getId_tipo_reaccion() {
        return id_tipo_reaccion;
    }

    public void setId_tipo_reaccion(long id_tipo_reaccion) {
        this.id_tipo_reaccion = id_tipo_reaccion;
    }

    public OpinionPelicula() {
    }

    public OpinionPelicula(long id_pelicula, String correo, Date fecha_registro, String comentarios, long id_tipo_reaccion) {
        this.id_pelicula = id_pelicula;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
        this.comentarios = comentarios;
        this.id_tipo_reaccion = id_tipo_reaccion;
    }

    public OpinionPelicula(long id_registro, long id_pelicula, String correo, Date fecha_registro, String comentarios, long id_tipo_reaccion) {
        this.id_registro = id_registro;
        this.id_pelicula = id_pelicula;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
        this.comentarios = comentarios;
        this.id_tipo_reaccion = id_tipo_reaccion;
    }
}
