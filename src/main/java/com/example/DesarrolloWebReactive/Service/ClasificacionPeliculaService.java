package com.example.DesarrolloWebReactive.Service;

import com.example.DesarrolloWebReactive.Entity.ClasificacionPelicula;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClasificacionPeliculaService {

    public Flux<ClasificacionPelicula> findAllClasificacionPelicula();

    public Mono<ClasificacionPelicula> findClasificacionPeliculaById(Long id);

    public Mono<ClasificacionPelicula> saveClasificacionPelicula(ClasificacionPelicula ClasificacionPeliculaNew);

    public Mono<ClasificacionPelicula> deleteClasificacionPelicula(Long id);

    Mono<ClasificacionPelicula> updateClasificacionPelicula(ClasificacionPelicula ClasificacionPeliculaNew);
}
