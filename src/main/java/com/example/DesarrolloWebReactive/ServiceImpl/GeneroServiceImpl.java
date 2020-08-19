package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.Genero;
import com.example.DesarrolloWebReactive.Repository.GeneroRepository;
import com.example.DesarrolloWebReactive.Service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroRepository generoRepository;

    @Override
    public Flux<Genero> findAllGenero() {
        return generoRepository.findAll();
    }

    @Override
    public Mono<Genero> findGeneroById(Long id) {
        Mono<Genero> Genero = generoRepository.findById(id);
        return Genero;
    }

    @Override
    public Mono<Genero> saveGenero(Genero GeneroNew) {
        if (GeneroNew != null)
            return generoRepository.save(GeneroNew);
        return new Mono<Genero>() {
            @Override
            public void subscribe(CoreSubscriber<? super Genero> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<Genero> deleteGenero(Long id) {
        return generoRepository.findById(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(GeneroDeleted -> generoRepository.delete(
                        GeneroDeleted).then(Mono.just(GeneroDeleted)));
    }

    @Override
    public Mono<Genero> updateGenero(Genero GeneroNew) {
        Long num = GeneroNew.getId();
        if (generoRepository.findById(num) != null) {
            Genero Genero = new Genero();
            Genero.setId(GeneroNew.getId());
            Genero.setGenero(GeneroNew.getGenero());
            Genero.setObservacion(GeneroNew.getObservacion());
            return generoRepository.save(Genero);
        }
        return null;
    }
}
