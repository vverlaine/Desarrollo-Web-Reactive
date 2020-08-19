package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "genero")
    String genero;

    @Column(name = "observacion")
    String observacion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Genero() {
    }

    public Genero(String genero, String observacion) {
        this.genero = genero;
        this.observacion = observacion;
    }

    public Genero(long id, String genero, String observacion) {
        this.id = id;
        this.genero = genero;
        this.observacion = observacion;
    }
}
