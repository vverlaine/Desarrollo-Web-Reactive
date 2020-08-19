package com.example.DesarrolloWebReactive.Repository;

import com.example.DesarrolloWebReactive.Entity.Pelicula;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PeliculaRepository extends ReactiveCrudRepository<Pelicula, Long> {
}
