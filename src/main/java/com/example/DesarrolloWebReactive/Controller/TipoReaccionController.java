package com.example.DesarrolloWebReactive.Controller;

import com.example.DesarrolloWebReactive.Entity.TipoReaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoReaccionController {

    public Flux<TipoReaccion> findAllTipoReaccion();

    public Mono<TipoReaccion> findTipoReaccionById(Long id);

    public Mono<TipoReaccion> saveTipoReaccion(TipoReaccion TipoReaccionNew);

    public Mono<TipoReaccion> deleteTipoReaccion(Long id);

    Mono<TipoReaccion> updateTipoReaccion(TipoReaccion TipoReaccionNew);
}
