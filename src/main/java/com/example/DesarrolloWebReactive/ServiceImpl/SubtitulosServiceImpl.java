package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.Subtitulos;
import com.example.DesarrolloWebReactive.Repository.SubtitulosRepository;
import com.example.DesarrolloWebReactive.Service.SubtitulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class SubtitulosServiceImpl implements SubtitulosService {

    @Autowired
    SubtitulosRepository SubtitulosRepository;

    @Override
    public Flux<Subtitulos> findAllSubtitulos() {
        return SubtitulosRepository.findAll();
    }

    @Override
    public Mono<Subtitulos> findSubtitulosById(Long id) {
        Mono<Subtitulos> Subtitulos = SubtitulosRepository.findById(id);
        return Subtitulos;
    }

    @Override
    public Mono<Subtitulos> saveSubtitulos(Subtitulos SubtitulosNew) {
        if (SubtitulosNew != null)
            return SubtitulosRepository.save(SubtitulosNew);
        return new Mono<Subtitulos>() {
            @Override
            public void subscribe(CoreSubscriber<? super Subtitulos> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<Subtitulos> deleteSubtitulos(Long id) {
        return SubtitulosRepository.findById(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(SubtitulosDeleted -> SubtitulosRepository.delete(
                        SubtitulosDeleted).then(Mono.just(SubtitulosDeleted)));
    }

    @Override
    public Mono<Subtitulos> updateSubtitulos(Subtitulos SubtitulosNew) {
        Long num = SubtitulosNew.getId();
        if (SubtitulosRepository.findById(num) != null) {
            Subtitulos Subtitulos = new Subtitulos();
            Subtitulos.setId(SubtitulosNew.getId());
            Subtitulos.setSubtitulo(SubtitulosNew.getSubtitulo());
            Subtitulos.setObservaciones(SubtitulosNew.getObservaciones());
            return SubtitulosRepository.save(Subtitulos);
        }
        return null;
    }
}
