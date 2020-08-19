package com.example.DesarrolloWebReactive.Service;

import com.example.DesarrolloWebReactive.Entity.Subtitulos;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubtitulosService {

    public Flux<Subtitulos> findAllSubtitulos();

    public Mono<Subtitulos> findSubtitulosById(Long id);

    public Mono<Subtitulos> saveSubtitulos(Subtitulos SubtitulosNew);

    public Mono<Subtitulos> deleteSubtitulos(Long id);

    Mono<Subtitulos> updateSubtitulos(Subtitulos SubtitulosNew);
}
