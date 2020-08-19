package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.TipoReaccionController;
import com.example.DesarrolloWebReactive.Entity.TipoReaccion;
import com.example.DesarrolloWebReactive.Service.TipoReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TipoReaccionControllerImpl implements TipoReaccionController {

    @Autowired
    TipoReaccionService tipoReaccionService;

    @GetMapping(value = "/tipoReaccion", produces = "application/json")
    @Override
    public Flux<TipoReaccion> findAllTipoReaccion() {
        return tipoReaccionService.findAllTipoReaccion();
    }

    @GetMapping(value = "/tipoReaccion/{id}", produces = "application/json")
    @Override
    public Mono<TipoReaccion> findTipoReaccionById(@PathVariable Long id) {
        return tipoReaccionService.findTipoReaccionById(id);
    }

    @PostMapping(value = "/tipoReaccion/create", produces = "application/json")
    @Override
    public Mono<TipoReaccion> saveTipoReaccion(@RequestBody TipoReaccion TipoReaccionNew) {
        return tipoReaccionService.saveTipoReaccion(TipoReaccionNew);
    }

    @DeleteMapping(value = "/tipoReaccion/delete/{id}", produces = "application/json")
    @Override
    public Mono<TipoReaccion> deleteTipoReaccion(@PathVariable Long id) {
        return tipoReaccionService.deleteTipoReaccion(id);
    }

    @PutMapping(value = "/tipoReaccion/update", produces = "application/json")
    @Override
    public Mono<TipoReaccion> updateTipoReaccion(@RequestBody TipoReaccion TipoReaccionNew) {
        return tipoReaccionService.updateTipoReaccion(TipoReaccionNew);
    }
}
