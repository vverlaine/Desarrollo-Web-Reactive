package com.example.DesarrolloWebReactive.Service;

import com.example.DesarrolloWebReactive.Entity.VistaReaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VistaReaccionService {

    public Flux<VistaReaccion> findAllVistaReaccion();

    public Mono<VistaReaccion> findVistaReaccionById(Long id);

}
