package com.example.DesarrolloWebReactive.Service;

import com.example.DesarrolloWebReactive.Entity.VistaPelicula;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VistaPeliculaService {

    public Flux<VistaPelicula> findAllVistaPelicula();

    public Mono<VistaPelicula> findVistaPeliculaById(Long id);

}
