package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.LenguajeController;
import com.example.DesarrolloWebReactive.Entity.Lenguaje;
import com.example.DesarrolloWebReactive.Service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pelicula")
public class LenguajeControllerImpl implements LenguajeController {

    @Autowired
    LenguajeService lenguajeService;

    @GetMapping(value = "/lenguaje/all", produces = "application/json")
    @Override
    public Flux<Lenguaje> findAllLenguaje() {
        return lenguajeService.findAllLenguaje();
    }

    @GetMapping(value = "/lenguaje/{id}", produces = "application/json")
    @Override
    public Mono<Lenguaje> findLenguajeById(@PathVariable Long id) {
        return lenguajeService.findLenguajeById(id);
    }

    @PostMapping(value = "/lenguaje/create", produces = "application/json")
    @Override
    public Mono<Lenguaje> saveLenguaje(@RequestBody Lenguaje LenguajeNew) {
        return lenguajeService.saveLenguaje(LenguajeNew);
    }

    @DeleteMapping(value = "/lenguaje/delete/{id}", produces = "application/json")
    @Override
    public Mono<Lenguaje> deleteLenguaje(@PathVariable Long id) {
        return lenguajeService.deleteLenguaje(id);
    }

    @PutMapping(value = "/lenguaje/update", produces = "application/json")
    @Override
    public Mono<Lenguaje> updateLenguaje(@RequestBody Lenguaje LenguajeNew) {
        return lenguajeService.updateLenguaje(LenguajeNew);
    }
}
