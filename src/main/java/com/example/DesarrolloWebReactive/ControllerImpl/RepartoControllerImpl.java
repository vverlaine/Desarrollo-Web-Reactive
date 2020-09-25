package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.RepartoController;
import com.example.DesarrolloWebReactive.Entity.Reparto;
import com.example.DesarrolloWebReactive.Service.RepartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pelicula")
public class RepartoControllerImpl implements RepartoController {

    @Autowired
    RepartoService repartoService;

    @GetMapping(value = "/reparto", produces = "application/json")
    @Override
    public Flux<Reparto> findAllReparto() {
        return repartoService.findAllReparto();
    }

    @GetMapping(value = "/reparto/{id}", produces = "application/json")
    @Override
    public Mono<Reparto> findRepartoById(@PathVariable Long id) {
        return repartoService.findRepartoById(id);
    }

    @PostMapping(value = "/reparto/create", produces = "application/json")
    @Override
    public Mono<Reparto> saveReparto(@RequestBody Reparto RepartoNew) {
        return repartoService.saveReparto(RepartoNew);
    }

    @DeleteMapping(value = "/reparto/delete/{id}", produces = "application/json")
    @Override
    public Mono<Reparto> deleteReparto(@PathVariable Long id) {
        return repartoService.deleteReparto(id);
    }

    @PutMapping(value = "/reparto/update", produces = "application/json")
    @Override
    public Mono<Reparto> updateReparto(@RequestBody Reparto RepartoNew) {
        return repartoService.updateReparto(RepartoNew);
    }
}
