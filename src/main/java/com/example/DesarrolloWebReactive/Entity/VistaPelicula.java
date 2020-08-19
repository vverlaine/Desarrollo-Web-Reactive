package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v_pelicula")
public class VistaPelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "titulo_original")
    String titulo_original;

    @Column(name = "genero")
    String genero;

    @Column(name = "lenguaje")
    String lenguaje;

    @Column(name = "subtitulo")
    String subtitulo;

    @Column(name = "fecha_produccion")
    Date fecha_produccion;

    @Column(name = "fecha_estreno")
    Date fecha_estreno;

    @Column(name = "url_pelicula")
    String url_pelicula;

    @Column(name = "duracion")
    String duracion;

    @Column(name = "clasificacion")
    String clasificacion;

    @Column(name = "resumen")
    String resumen;

    public long getId() {
        return id;
    }

    public String getTitulo_original() {
        return titulo_original;
    }

    public String getGenero() {
        return genero;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public Date getFecha_produccion() {
        return fecha_produccion;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public String getUrl_pelicula() {
        return url_pelicula;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getResumen() {
        return resumen;
    }

    public VistaPelicula() {
    }

    public VistaPelicula(long id, String titulo_original, String genero, String lenguaje, String subtitulo, Date fecha_produccion, Date fecha_estreno, String url_pelicula, String duracion, String clasificacion, String resumen) {
        this.id = id;
        this.titulo_original = titulo_original;
        this.genero = genero;
        this.lenguaje = lenguaje;
        this.subtitulo = subtitulo;
        this.fecha_produccion = fecha_produccion;
        this.fecha_estreno = fecha_estreno;
        this.url_pelicula = url_pelicula;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.resumen = resumen;
    }
}
