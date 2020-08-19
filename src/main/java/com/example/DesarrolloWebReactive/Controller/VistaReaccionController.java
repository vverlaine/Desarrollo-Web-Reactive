package com.example.DesarrolloWebReactive.Controller;

import com.example.DesarrolloWebReactive.Entity.VistaReaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VistaReaccionController {

    public Flux<VistaReaccion> findAllVistaReaccion();

    public Mono<VistaReaccion> findVistaReaccionById(Long id);
}
