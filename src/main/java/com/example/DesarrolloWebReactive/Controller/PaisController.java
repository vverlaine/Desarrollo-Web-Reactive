package com.example.DesarrolloWebReactive.Controller;

import com.example.DesarrolloWebReactive.Entity.Pais;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaisController {

    public Flux<Pais> getPais();

    public Mono<Pais> getPaisById(Long id);

    public Mono<Pais> addPais(Pais pais);

    public Mono<Pais> deletePais(Long id);

    public Mono<Pais> updatePais(Pais paisNew);

    public String test();
}
