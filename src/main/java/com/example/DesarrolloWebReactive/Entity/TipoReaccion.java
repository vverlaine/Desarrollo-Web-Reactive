package com.example.DesarrolloWebReactive.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "tipo_reaccion")
public class TipoReaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "tipo_reaccion")
    String tipo_reaccion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo_reaccion() {
        return tipo_reaccion;
    }

    public void setTipo_reaccion(String tipo_reaccion) {
        this.tipo_reaccion = tipo_reaccion;
    }

    public TipoReaccion() {
    }

    public TipoReaccion(String tipo_reaccion) {
        this.tipo_reaccion = tipo_reaccion;
    }

    public TipoReaccion(long id, String tipo_reaccion) {
        this.id = id;
        this.tipo_reaccion = tipo_reaccion;
    }
}
