package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.PeliculaController;
import com.example.DesarrolloWebReactive.Entity.Pelicula;
import com.example.DesarrolloWebReactive.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pelicula")
public class PeliculaControllerImpl implements PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping(value = "/pelicula", produces = "application/json")
    @Override
    public Flux<Pelicula> findAllPelicula() {
        return peliculaService.findAllPelicula();
    }

    @GetMapping(value = "/pelicula/{id}", produces = "application/json")
    @Override
    public Mono<Pelicula> findPeliculaById(@PathVariable Long id) {
        return peliculaService.findPeliculaById(id);
    }

    @PostMapping(value = "/pelicula/create", produces = "application/json")
    @Override
    public Mono<Pelicula> savePelicula(@RequestBody Pelicula PeliculaNew) {
        return peliculaService.savePelicula(PeliculaNew);
    }

    @DeleteMapping(value = "/pelicula/delete/{id}", produces = "application/json")
    @Override
    public Mono<Pelicula> deletePelicula(@PathVariable Long id) {
        return peliculaService.deletePelicula(id);
    }

    @PutMapping(value = "/pelicula/update", produces = "application/json")
    @Override
    public Mono<Pelicula> updatePelicula(@RequestBody Pelicula PeliculaNew) {
        return peliculaService.updatePelicula(PeliculaNew);
    }
}
