package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.ClasificacionPelicula;
import com.example.DesarrolloWebReactive.Repository.ClasificacionPeliculaRepository;
import com.example.DesarrolloWebReactive.Service.ClasificacionPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class ClasificacionPeliculaServiceImpl implements ClasificacionPeliculaService {

    @Autowired
    ClasificacionPeliculaRepository clasificacionPeliculaRepository;

    @Override
    public Flux<ClasificacionPelicula> findAllClasificacionPelicula() {
        return clasificacionPeliculaRepository.findAll();
    }

    @Override
    public Mono<ClasificacionPelicula> findClasificacionPeliculaById(Long id) {
        Mono<ClasificacionPelicula> clasificacionPelicula = clasificacionPeliculaRepository.findById(id);
        return clasificacionPelicula;
    }

    @Override
    public Mono<ClasificacionPelicula> saveClasificacionPelicula(ClasificacionPelicula ClasificacionPeliculaNew) {
        if (ClasificacionPeliculaNew != null)
            return clasificacionPeliculaRepository.save(ClasificacionPeliculaNew);
        return new Mono<ClasificacionPelicula>() {
            @Override
            public void subscribe(CoreSubscriber<? super ClasificacionPelicula> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<ClasificacionPelicula> deleteClasificacionPelicula(Long id) {
        return clasificacionPeliculaRepository.findById(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(clasificacionPeliculaDeleted -> clasificacionPeliculaRepository.delete(
                        clasificacionPeliculaDeleted).then(Mono.just(clasificacionPeliculaDeleted)));
    }

    @Override
    public Mono<ClasificacionPelicula> updateClasificacionPelicula(ClasificacionPelicula ClasificacionPeliculaNew) {
        Long num = ClasificacionPeliculaNew.getId();
        if (clasificacionPeliculaRepository.findById(num) != null) {
            ClasificacionPelicula clasificacionPelicula = new ClasificacionPelicula();
            clasificacionPelicula.setId(ClasificacionPeliculaNew.getId());
            clasificacionPelicula.setClasificacion(ClasificacionPeliculaNew.getClasificacion());
            clasificacionPelicula.setObservacion(ClasificacionPeliculaNew.getObservacion());
            return clasificacionPeliculaRepository.save(clasificacionPelicula);
        }
        return null;
    }
}
