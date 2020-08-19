package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.Lenguaje;
import com.example.DesarrolloWebReactive.Repository.LenguajeRepository;
import com.example.DesarrolloWebReactive.Service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class LenguajeServiceImpl implements LenguajeService {

    @Autowired
    LenguajeRepository LenguajeRepository;

    @Override
    public Flux<Lenguaje> findAllLenguaje() {
        return LenguajeRepository.findAll();
    }

    @Override
    public Mono<Lenguaje> findLenguajeById(Long id) {
        Mono<Lenguaje> Lenguaje = LenguajeRepository.findById(id);
        return Lenguaje;
    }

    @Override
    public Mono<Lenguaje> saveLenguaje(Lenguaje LenguajeNew) {
        if (LenguajeNew != null)
            return LenguajeRepository.save(LenguajeNew);
        return new Mono<Lenguaje>() {
            @Override
            public void subscribe(CoreSubscriber<? super Lenguaje> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<Lenguaje> deleteLenguaje(Long id) {
        return LenguajeRepository.findById(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(LenguajeDeleted -> LenguajeRepository.delete(
                        LenguajeDeleted).then(Mono.just(LenguajeDeleted)));
    }

    @Override
    public Mono<Lenguaje> updateLenguaje(Lenguaje LenguajeNew) {
        Long num = LenguajeNew.getId();
        if (LenguajeRepository.findById(num) != null) {
            Lenguaje Lenguaje = new Lenguaje();
            Lenguaje.setId(LenguajeNew.getId());
            Lenguaje.setLenguaje(LenguajeNew.getLenguaje());
            Lenguaje.setObservacion(LenguajeNew.getObservacion());
            return LenguajeRepository.save(Lenguaje);
        }
        return null;
    }
}
