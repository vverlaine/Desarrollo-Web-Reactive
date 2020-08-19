package com.example.DesarrolloWebReactive.Controller;

import com.example.DesarrolloWebReactive.Entity.VistaPelicula;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VistaPeliculaController {

    public Flux<VistaPelicula> findAllVistaPelicula();

    public Mono<VistaPelicula> findVistaPeliculaById(Long id);
}
