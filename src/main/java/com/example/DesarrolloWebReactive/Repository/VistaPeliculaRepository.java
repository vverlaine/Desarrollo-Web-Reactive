package com.example.DesarrolloWebReactive.Repository;

import com.example.DesarrolloWebReactive.Entity.VistaPelicula;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface VistaPeliculaRepository extends ReactiveCrudRepository<VistaPelicula, Long> {
}
