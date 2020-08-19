package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "lenguaje")
public class Lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "lenguaje")
    String lenguaje;

    @Column(name = "observacion")
    String observacion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Lenguaje() {
    }

    public Lenguaje(String lenguaje, String observacion) {
        this.lenguaje = lenguaje;
        this.observacion = observacion;
    }

    public Lenguaje(long id, String lenguaje, String observacion) {
        this.id = id;
        this.lenguaje = lenguaje;
        this.observacion = observacion;
    }
}
