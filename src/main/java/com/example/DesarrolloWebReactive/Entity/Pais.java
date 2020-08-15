package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "PAIS")
    String pais;

    @Column(name = "OBSERVACION")
    String observacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Pais() {
    }

    public Pais(String pais, String observacion) {
        this.pais = pais;
        this.observacion = observacion;
    }

    public Pais(Long id, String pais, String observacion) {
        this.id = id;
        this.pais = pais;
        this.observacion = observacion;
    }
}
