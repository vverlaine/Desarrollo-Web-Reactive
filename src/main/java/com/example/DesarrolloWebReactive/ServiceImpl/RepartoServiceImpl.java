package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.Reparto;
import com.example.DesarrolloWebReactive.Repository.RepartoRepository;
import com.example.DesarrolloWebReactive.Service.RepartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class RepartoServiceImpl implements RepartoService {

    @Autowired
    RepartoRepository RepartoRepository;

    @Override
    public Flux<Reparto> findAllReparto() {
        return RepartoRepository.findAll();
    }

    @Override
    public Mono<Reparto> findRepartoById(Long id) {
        Mono<Reparto> Reparto = RepartoRepository.findById(id);
        return Reparto;
    }

    @Override
    public Mono<Reparto> saveReparto(Reparto RepartoNew) {
        if (RepartoNew != null)
            return RepartoRepository.save(RepartoNew);
        return new Mono<Reparto>() {
            @Override
            public void subscribe(CoreSubscriber<? super Reparto> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<Reparto> deleteReparto(Long id) {
        return RepartoRepository.findById(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(RepartoDeleted -> RepartoRepository.delete(
                        RepartoDeleted).then(Mono.just(RepartoDeleted)));
    }

    @Override
    public Mono<Reparto> updateReparto(Reparto RepartoNew) {
        Long num = RepartoNew.getId();
        if (RepartoRepository.findById(num) != null) {
            Reparto Reparto = new Reparto();
            Reparto.setId(RepartoNew.getId());
            Reparto.setNombre(RepartoNew.getNombre());
            Reparto.setApellido(RepartoNew.getApellido());
            Reparto.setId_pelicula(RepartoNew.getId_pelicula());
            return RepartoRepository.save(Reparto);
        }
        return null;
    }
}
