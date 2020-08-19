package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.OpinionPelicula;
import com.example.DesarrolloWebReactive.Repository.OpinionPeliculaRepository;
import com.example.DesarrolloWebReactive.Service.OpinionPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class OpinionPeliculaServiceImpl implements OpinionPeliculaService {

    @Autowired
    OpinionPeliculaRepository OpinionPeliculaRepository;

    @Override
    public Flux<OpinionPelicula> findAllOpinionPelicula() {
        return OpinionPeliculaRepository.findAll();
    }

    @Override
    public Mono<OpinionPelicula> findOpinionPeliculaById(Long id) {
        Mono<OpinionPelicula> OpinionPelicula = OpinionPeliculaRepository.findById(id);
        return OpinionPelicula;
    }

    @Override
    public Mono<OpinionPelicula> saveOpinionPelicula(OpinionPelicula OpinionPeliculaNew) {
        if (OpinionPeliculaNew != null)
            return OpinionPeliculaRepository.save(OpinionPeliculaNew);
        return new Mono<OpinionPelicula>() {
            @Override
            public void subscribe(CoreSubscriber<? super OpinionPelicula> coreSubscriber) {
            }
        };
    }

    @Override
    public Mono<OpinionPelicula> deleteOpinionPelicula(Long id) {
        return OpinionPeliculaRepository.findById(id).switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(OpinionPeliculaDeleted -> OpinionPeliculaRepository.delete(
                        OpinionPeliculaDeleted).then(Mono.just(OpinionPeliculaDeleted)));
    }

    @Override
    public Mono<OpinionPelicula> updateOpinionPelicula(OpinionPelicula OpinionPeliculaNew) {
        Long num = OpinionPeliculaNew.getId_registro();
        if (OpinionPeliculaRepository.findById(num) != null) {
            OpinionPelicula OpinionPelicula = new OpinionPelicula();
            OpinionPelicula.setId_registro(OpinionPeliculaNew.getId_registro());
            OpinionPelicula.setId_pelicula(OpinionPeliculaNew.getId_pelicula());
            OpinionPelicula.setCorreo(OpinionPeliculaNew.getCorreo());
            OpinionPelicula.setFecha_registro(OpinionPeliculaNew.getFecha_registro());
            OpinionPelicula.setComentarios(OpinionPeliculaNew.getComentarios());
            OpinionPelicula.setId_tipo_reaccion(OpinionPeliculaNew.getId_tipo_reaccion());
            return OpinionPeliculaRepository.save(OpinionPelicula);
        }
        return null;
    }
}
