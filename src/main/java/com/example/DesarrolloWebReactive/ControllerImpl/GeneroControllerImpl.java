package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.GeneroController;
import com.example.DesarrolloWebReactive.Entity.Genero;
import com.example.DesarrolloWebReactive.Service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pelicula")
public class GeneroControllerImpl implements GeneroController {

    @Autowired
    GeneroService generoService;

    @GetMapping(value = "/genero/all", produces = "application/json")
    @Override
    public Flux<Genero> findAllGenero() {
        return generoService.findAllGenero();
    }

    @GetMapping(value = "/genero/{id}", produces = "application/json")
    @Override
    public Mono<Genero> findGeneroById(@PathVariable Long id) {
        return generoService.findGeneroById(id);
    }

    @PostMapping(value = "/genero/create", produces = "application/json")
    @Override
    public Mono<Genero> saveGenero(@RequestBody Genero GeneroNew) {
        return generoService.saveGenero(GeneroNew);
    }

    @DeleteMapping(value = "/genero/delete/{id}", produces = "application/json")
    @Override
    public Mono<Genero> deleteGenero(@PathVariable Long id) {
        return generoService.deleteGenero(id);
    }

    @PutMapping(value = "/genero/update", produces = "application/json")
    @Override
    public Mono<Genero> updateGenero(@RequestBody Genero GeneroNew) {
        return generoService.updateGenero(GeneroNew);
    }
}
