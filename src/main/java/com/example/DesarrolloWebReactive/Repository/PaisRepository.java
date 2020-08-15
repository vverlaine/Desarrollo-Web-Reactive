package com.example.DesarrolloWebReactive.Repository;

import com.example.DesarrolloWebReactive.Entity.Pais;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.Optional;

public interface PaisRepository extends ReactiveCrudRepository<Pais, Long> {
    void save(Optional<Pais> paisToUpdate);
}
