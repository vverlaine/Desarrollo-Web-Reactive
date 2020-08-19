package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.TipoReaccion;
import com.example.DesarrolloWebReactive.Repository.TipoReaccionRepository;
import com.example.DesarrolloWebReactive.Service.TipoReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class TipoReaccionServiceImpl implements TipoReaccionService {

    @Autowired
    TipoReaccionRepository TipoReaccionRepository;

    @Override
    public Flux<TipoReaccion> findAllTipoReaccion() {
        return TipoReaccionRepository.findAll();
    }

    @Override
    public Mono<TipoReaccion> findTipoReaccionById(Long id) {
        Mono<TipoReaccion> TipoReaccion = TipoReaccionRepository.findById(id);
        return TipoReaccion;
    }

    @Override
    public Mono<TipoReaccion> saveTipoReaccion(TipoReaccion TipoReaccionNew) {
        if (TipoReaccionNew != null)
            return TipoReaccionRepository.save(TipoReaccionNew);
        return new Mono<TipoReaccion>() {
            @Override
            public void subscribe(CoreSubscriber<? super TipoReaccion> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<TipoReaccion> deleteTipoReaccion(Long id) {
        return TipoReaccionRepository.findById(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(TipoReaccionDeleted -> TipoReaccionRepository.delete(
                        TipoReaccionDeleted).then(Mono.just(TipoReaccionDeleted)));
    }

    @Override
    public Mono<TipoReaccion> updateTipoReaccion(TipoReaccion TipoReaccionNew) {
        Long num = TipoReaccionNew.getId();
        if (TipoReaccionRepository.findById(num) != null) {
            TipoReaccion TipoReaccion = new TipoReaccion();
            TipoReaccion.setId(TipoReaccionNew.getId());
            TipoReaccion.setTipo_reaccion(TipoReaccionNew.getTipo_reaccion());
            return TipoReaccionRepository.save(TipoReaccion);
        }
        return null;
    }
}
