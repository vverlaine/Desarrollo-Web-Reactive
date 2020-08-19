package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.VistaReaccion;
import com.example.DesarrolloWebReactive.Repository.VistaReaccionRepository;
import com.example.DesarrolloWebReactive.Service.VistaReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class VistaReaccionServiceImpl implements VistaReaccionService {

    @Autowired
    VistaReaccionRepository vistaReaccionRepository;


    @Override
    public Flux<VistaReaccion> findAllVistaReaccion() {
        return vistaReaccionRepository.findAll();
    }

    @Override
    public Mono<VistaReaccion> findVistaReaccionById(Long id) {
        Mono<VistaReaccion> vistaReaccion = vistaReaccionRepository.findById(id);
        return vistaReaccion;
    }
}
