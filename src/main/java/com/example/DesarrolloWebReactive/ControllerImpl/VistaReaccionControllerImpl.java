package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.VistaReaccionController;
import com.example.DesarrolloWebReactive.Entity.VistaReaccion;
import com.example.DesarrolloWebReactive.Service.VistaReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VistaReaccionControllerImpl implements VistaReaccionController {

    @Autowired
    VistaReaccionService vistaReaccionService;

    @GetMapping(value = "/vistaReaccion", produces = "application/json")
    @Override
    public Flux<VistaReaccion> findAllVistaReaccion() {
        return vistaReaccionService.findAllVistaReaccion();
    }

    @GetMapping(value = "/vistaReaccion/{id}", produces = "application/json")
    @Override
    public Mono<VistaReaccion> findVistaReaccionById(@PathVariable Long id) {
        return vistaReaccionService.findVistaReaccionById(id);
    }
}
