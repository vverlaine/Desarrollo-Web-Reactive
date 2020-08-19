package com.example.DesarrolloWebReactive.Controller;

import com.example.DesarrolloWebReactive.Entity.OpinionPelicula;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OpinionPeliculaController {

    public Flux<OpinionPelicula> findAllOpinionPelicula();

    public Mono<OpinionPelicula> findOpinionPeliculaById(Long id);

    public Mono<OpinionPelicula> saveOpinionPelicula(OpinionPelicula OpinionPeliculaNew);

    public Mono<OpinionPelicula> deleteOpinionPelicula(Long id);

    Mono<OpinionPelicula> updateOpinionPelicula(OpinionPelicula OpinionPeliculaNew);
}
