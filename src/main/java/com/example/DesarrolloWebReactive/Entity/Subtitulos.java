package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "subtitulos")
public class Subtitulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "subtitulo")
    String subtitulo;

    @Column(name = "observaciones")
    String observaciones;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Subtitulos() {
    }

    public Subtitulos(String subtitulo, String observaciones) {
        this.subtitulo = subtitulo;
        this.observaciones = observaciones;
    }

    public Subtitulos(long id, String subtitulo, String observaciones) {
        this.id = id;
        this.subtitulo = subtitulo;
        this.observaciones = observaciones;
    }
}
