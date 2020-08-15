package com.example.DesarrolloWebReactive.Service;

import com.example.DesarrolloWebReactive.Entity.Pais;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaisService {

    public Flux<Pais> findAllPais();

    public Mono<Pais> findPaisById(Long id);

    public Mono<Pais> savePais(Pais PaisNew);

    public Mono<Pais> deletePais(Long id);

    Mono<Pais> updatePais(Pais paisNew);
}
