package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "titulo_original")
    String titulo_original;

    @Column(name = "id_genero")
    long id_genero;

    @Column(name = "id_lenguaje")
    long id_lenguaje;

    @Column(name = "id_subtitulo")
    long id_subtitulo;

    @Column(name = "fecha_produccion")
    Date fecha_produccion;

    @Column(name = "fecha_estreno")
    Date fecha_estreno;

    @Column(name = "url_pelicula")
    String url_pelicula;

    @Column(name = "duracion")
    String duracion;

    @Column(name = "id_clasificacion")
    Long id_clasificacion;

    @Column(name = "resumen")
    String resumen;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo_original() {
        return titulo_original;
    }

    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }

    public long getId_genero() {
        return id_genero;
    }

    public void setId_genero(long id_genero) {
        this.id_genero = id_genero;
    }

    public long getId_lenguaje() {
        return id_lenguaje;
    }

    public void setId_lenguaje(long id_lenguaje) {
        this.id_lenguaje = id_lenguaje;
    }

    public long getId_subtitulo() {
        return id_subtitulo;
    }

    public void setId_subtitulo(long id_subtitulo) {
        this.id_subtitulo = id_subtitulo;
    }

    public Date getFecha_produccion() {
        return fecha_produccion;
    }

    public void setFecha_produccion(Date fecha_produccion) {
        this.fecha_produccion = fecha_produccion;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getUrl_pelicula() {
        return url_pelicula;
    }

    public void setUrl_pelicula(String url_pelicula) {
        this.url_pelicula = url_pelicula;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Long getId_clasificacion() {
        return id_clasificacion;
    }

    public void setId_clasificacion(Long id_clasificacion) {
        this.id_clasificacion = id_clasificacion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Pelicula() {
    }

    public Pelicula(String titulo_original, long id_genero, long id_lenguaje, long id_subtitulo, Date fecha_produccion, Date fecha_estreno, String url_pelicula, String duracion, Long id_clasificacion, String resumen) {
        this.titulo_original = titulo_original;
        this.id_genero = id_genero;
        this.id_lenguaje = id_lenguaje;
        this.id_subtitulo = id_subtitulo;
        this.fecha_produccion = fecha_produccion;
        this.fecha_estreno = fecha_estreno;
        this.url_pelicula = url_pelicula;
        this.duracion = duracion;
        this.id_clasificacion = id_clasificacion;
        this.resumen = resumen;
    }

    public Pelicula(long id, String titulo_original, long id_genero, long id_lenguaje, long id_subtitulo, Date fecha_produccion, Date fecha_estreno, String url_pelicula, String duracion, Long id_clasificacion, String resumen) {
        this.id = id;
        this.titulo_original = titulo_original;
        this.id_genero = id_genero;
        this.id_lenguaje = id_lenguaje;
        this.id_subtitulo = id_subtitulo;
        this.fecha_produccion = fecha_produccion;
        this.fecha_estreno = fecha_estreno;
        this.url_pelicula = url_pelicula;
        this.duracion = duracion;
        this.id_clasificacion = id_clasificacion;
        this.resumen = resumen;
    }
}
