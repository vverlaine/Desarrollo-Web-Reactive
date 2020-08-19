package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.ClasificacionPeliculaController;
import com.example.DesarrolloWebReactive.Entity.ClasificacionPelicula;
import com.example.DesarrolloWebReactive.Service.ClasificacionPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClasificacionPeliculaControllerImpl implements ClasificacionPeliculaController {

    @Autowired
    ClasificacionPeliculaService clasificacionPeliculaService;

    @GetMapping(value = "/clasificacionPelicula", produces = "application/json")
    @Override
    public Flux<ClasificacionPelicula> findAllClasificacionPelicula() {
        return clasificacionPeliculaService.findAllClasificacionPelicula();
    }

    @GetMapping(value = "/clasificacionPelicula/{id}", produces = "application/json")
    @Override
    public Mono<ClasificacionPelicula> findClasificacionPeliculaById(@PathVariable Long id) {
        return clasificacionPeliculaService.findClasificacionPeliculaById(id);
    }

    @PostMapping(value = "/clasificacionPelicula/create", produces = "application/json")
    @Override
    public Mono<ClasificacionPelicula> saveClasificacionPelicula(@RequestBody ClasificacionPelicula ClasificacionPeliculaNew) {
        return clasificacionPeliculaService.saveClasificacionPelicula(ClasificacionPeliculaNew);
    }

    @DeleteMapping(value = "/clasificacionPelicula/delete/{id}", produces = "application/json")
    @Override
    public Mono<ClasificacionPelicula> deleteClasificacionPelicula(@PathVariable Long id) {
        return clasificacionPeliculaService.deleteClasificacionPelicula(id);
    }

    @PutMapping(value = "/clasificacionPelicula/update", produces = "application/json")
    @Override
    public Mono<ClasificacionPelicula> updateClasificacionPelicula(@RequestBody ClasificacionPelicula ClasificacionPeliculaNew) {
        return clasificacionPeliculaService.updateClasificacionPelicula(ClasificacionPeliculaNew);
    }
}
