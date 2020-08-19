package com.example.DesarrolloWebReactive.Service;

import com.example.DesarrolloWebReactive.Entity.Lenguaje;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LenguajeService {

    public Flux<Lenguaje> findAllLenguaje();

    public Mono<Lenguaje> findLenguajeById(Long id);

    public Mono<Lenguaje> saveLenguaje(Lenguaje LenguajeNew);

    public Mono<Lenguaje> deleteLenguaje(Long id);

    Mono<Lenguaje> updateLenguaje(Lenguaje LenguajeNew);
}
