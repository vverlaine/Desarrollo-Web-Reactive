package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.OpinionPeliculaController;
import com.example.DesarrolloWebReactive.Entity.OpinionPelicula;
import com.example.DesarrolloWebReactive.Service.OpinionPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pelicula")
public class OpinonPeliculaControllerImpl implements OpinionPeliculaController {

    @Autowired
    OpinionPeliculaService opinionPeliculaService;

    @GetMapping(value = "/opinionPelicula", produces = "application/json")
    @Override
    public Flux<OpinionPelicula> findAllOpinionPelicula() {
        return opinionPeliculaService.findAllOpinionPelicula();
    }

    @GetMapping(value = "/opinionPelicula/{id}", produces = "application/json")
    @Override
    public Mono<OpinionPelicula> findOpinionPeliculaById(@PathVariable Long id) {
        return opinionPeliculaService.findOpinionPeliculaById(id);
    }

    @PostMapping(value = "/opinionPelicula/create", produces = "application/json")
    @Override
    public Mono<OpinionPelicula> saveOpinionPelicula(@RequestBody OpinionPelicula OpinionPeliculaNew) {
        return opinionPeliculaService.saveOpinionPelicula(OpinionPeliculaNew);
    }

    @DeleteMapping(value = "/opinionPelicula/delete/{id}", produces = "application/json")
    @Override
    public Mono<OpinionPelicula> deleteOpinionPelicula(@PathVariable Long id) {
        return opinionPeliculaService.deleteOpinionPelicula(id);
    }

    @PutMapping(value = "/opinionPelicula/update", produces = "application/json")
    @Override
    public Mono<OpinionPelicula> updateOpinionPelicula(@RequestBody OpinionPelicula OpinionPeliculaNew) {
        return opinionPeliculaService.updateOpinionPelicula(OpinionPeliculaNew);
    }
}
