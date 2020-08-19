package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.VistaPeliculaController;
import com.example.DesarrolloWebReactive.Entity.VistaPelicula;
import com.example.DesarrolloWebReactive.Service.VistaPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VistaPeliculaControllerImpl implements VistaPeliculaController {

    @Autowired
    VistaPeliculaService vistaPeliculaService;

    @GetMapping(value = "/vistaPelicula", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Override
    public Flux<VistaPelicula> findAllVistaPelicula() {
        return vistaPeliculaService.findAllVistaPelicula();
    }

    @GetMapping(value = "/vistaPelicula/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Override
    public Mono<VistaPelicula> findVistaPeliculaById(@PathVariable Long id) {
        return vistaPeliculaService.findVistaPeliculaById(id);
    }
}
