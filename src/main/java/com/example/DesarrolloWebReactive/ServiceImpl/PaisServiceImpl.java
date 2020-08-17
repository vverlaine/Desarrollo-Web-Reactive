package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.Pais;
import com.example.DesarrolloWebReactive.Repository.PaisRepository;
import com.example.DesarrolloWebReactive.Service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    PaisRepository paisRepository;

    @Override
    public Flux<Pais> findAllPais() {
        return (Flux<Pais>) paisRepository.findAll();
    }

    @Override
    public Mono<Pais> findPaisById(Long id) {
        Mono<Pais> pais = paisRepository.findById(id);
        return pais;
    }

    @Override
    public Mono<Pais> savePais(Pais PaisNew) {
        if (PaisNew != null)
            return paisRepository.save(PaisNew);
        return new Mono<Pais>() {
            @Override
            public void subscribe(CoreSubscriber<? super Pais> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<Pais> deletePais(Long id) {
        Mono<Pais> dbPais = paisRepository.findById(id);
        if (Objects.isNull(dbPais)) {
            return Mono.empty();
        }
        return paisRepository.findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
                .flatMap(paisToBeDeleted -> paisRepository.delete(paisToBeDeleted).then(Mono.just(paisToBeDeleted)));
    }

    @Override
    public Mono<Pais> updatePais(Pais paisNew) {
        Long num = paisNew.getId();
        if (paisRepository.findById(num) != null) {
            Pais paisToUpdate = new Pais();
            paisToUpdate.setId(paisNew.getId());
            paisToUpdate.setPais(paisNew.getPais());
            paisToUpdate.setObservacion(paisNew.getObservacion());
            return paisRepository.save(paisToUpdate);
        }
        return null;
    }
}
