package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "clasificacion_pelicula")
public class ClasificacionPelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "clasificacion")
    String clasificacion;

    @Column(name = "observacion")
    String observacion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ClasificacionPelicula() {
    }

    public ClasificacionPelicula(String clasificacion, String observacion) {
        this.clasificacion = clasificacion;
        this.observacion = observacion;
    }

    public ClasificacionPelicula(long id, String clasificacion, String observacion) {
        this.id = id;
        this.clasificacion = clasificacion;
        this.observacion = observacion;
    }
}
