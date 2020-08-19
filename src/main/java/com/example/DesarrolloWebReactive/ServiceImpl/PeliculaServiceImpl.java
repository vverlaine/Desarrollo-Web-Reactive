package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.Pelicula;
import com.example.DesarrolloWebReactive.Repository.PeliculaRepository;
import com.example.DesarrolloWebReactive.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository PeliculaRepository;

    @Override
    public Flux<Pelicula> findAllPelicula() {
        return PeliculaRepository.findAll();
    }

    @Override
    public Mono<Pelicula> findPeliculaById(Long id) {
        Mono<Pelicula> Pelicula = PeliculaRepository.findById(id);
        return Pelicula;
    }

    @Override
    public Mono<Pelicula> savePelicula(Pelicula PeliculaNew) {
        if (PeliculaNew != null)
            return PeliculaRepository.save(PeliculaNew);
        return new Mono<Pelicula>() {
            @Override
            public void subscribe(CoreSubscriber<? super Pelicula> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<Pelicula> deletePelicula(Long id) {
        return PeliculaRepository.findById(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(PeliculaDeleted -> PeliculaRepository.delete(
                        PeliculaDeleted).then(Mono.just(PeliculaDeleted)));
    }

    @Override
    public Mono<Pelicula> updatePelicula(Pelicula PeliculaNew) {
        Long num = PeliculaNew.getId();
        if (PeliculaRepository.findById(num) != null) {
            Pelicula Pelicula = new Pelicula();
            Pelicula.setId(PeliculaNew.getId());
            Pelicula.setTitulo_original(PeliculaNew.getTitulo_original());
            Pelicula.setId_genero(PeliculaNew.getId_genero());
            Pelicula.setId_lenguaje(PeliculaNew.getId_lenguaje());
            Pelicula.setId_subtitulo(PeliculaNew.getId_subtitulo());
            Pelicula.setFecha_produccion(PeliculaNew.getFecha_produccion());
            Pelicula.setFecha_estreno(PeliculaNew.getFecha_estreno());
            Pelicula.setUrl_pelicula(PeliculaNew.getUrl_pelicula());
            Pelicula.setDuracion(PeliculaNew.getDuracion());
            Pelicula.setId_clasificacion(PeliculaNew.getId_clasificacion());
            Pelicula.setResumen(PeliculaNew.getResumen());
            return PeliculaRepository.save(Pelicula);
        }
        return null;
    }
}
