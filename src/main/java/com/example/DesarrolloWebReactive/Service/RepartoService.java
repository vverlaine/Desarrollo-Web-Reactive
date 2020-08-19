package com.example.DesarrolloWebReactive.Service;

import com.example.DesarrolloWebReactive.Entity.Reparto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepartoService {

    public Flux<Reparto> findAllReparto();

    public Mono<Reparto> findRepartoById(Long id);

    public Mono<Reparto> saveReparto(Reparto RepartoNew);

    public Mono<Reparto> deleteReparto(Long id);

    Mono<Reparto> updateReparto(Reparto RepartoNew);
}
