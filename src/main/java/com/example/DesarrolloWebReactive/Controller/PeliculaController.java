package com.example.DesarrolloWebReactive.Controller;

import com.example.DesarrolloWebReactive.Entity.Pelicula;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PeliculaController {

    public Flux<Pelicula> findAllPelicula();

    public Mono<Pelicula> findPeliculaById(Long id);

    public Mono<Pelicula> savePelicula(Pelicula PeliculaNew);

    public Mono<Pelicula> deletePelicula(Long id);

    Mono<Pelicula> updatePelicula(Pelicula PeliculaNew);
}
