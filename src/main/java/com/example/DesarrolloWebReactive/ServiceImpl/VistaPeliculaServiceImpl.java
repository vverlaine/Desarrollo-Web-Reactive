package com.example.DesarrolloWebReactive.ServiceImpl;

import com.example.DesarrolloWebReactive.Entity.VistaPelicula;
import com.example.DesarrolloWebReactive.Repository.VistaPeliculaRepository;
import com.example.DesarrolloWebReactive.Service.VistaPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class VistaPeliculaServiceImpl implements VistaPeliculaService {

    @Autowired
    VistaPeliculaRepository vistaPeliculaRepository;

    @Override
    public Flux<VistaPelicula> findAllVistaPelicula() {
        return vistaPeliculaRepository.findAll();
    }

    @Override
    public Mono<VistaPelicula> findVistaPeliculaById(Long id) {
        Mono<VistaPelicula> vistaPelicula = vistaPeliculaRepository.findById(id);
        return vistaPelicula;
    }
}
