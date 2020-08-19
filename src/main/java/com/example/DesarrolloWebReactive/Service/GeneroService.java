package com.example.DesarrolloWebReactive.Service;

import com.example.DesarrolloWebReactive.Entity.Genero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GeneroService {

    public Flux<Genero> findAllGenero();

    public Mono<Genero> findGeneroById(Long id);

    public Mono<Genero> saveGenero(Genero GeneroNew);

    public Mono<Genero> deleteGenero(Long id);

    Mono<Genero> updateGenero(Genero GeneroNew);
}
