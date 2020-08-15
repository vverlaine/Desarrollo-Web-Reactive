package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.PaisController;
import com.example.DesarrolloWebReactive.Entity.Pais;
import com.example.DesarrolloWebReactive.Service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PaisControllerImpl implements PaisController {

    @Autowired
    PaisService paisService;

    @GetMapping(value = "/pais", produces = "application/json")
    @Override
    public Flux<Pais> getPais() {
        return paisService.findAllPais();
    }

    @GetMapping(value = "/pais/{id}", produces = "application/json")
    @Override
    public Mono<Pais> getPaisById(@PathVariable Long id) {
        return paisService.findPaisById(id);
    }

    @PostMapping(value = "/pais/create", produces = "application/json")
    @Override
    public Mono<Pais> addPais(@RequestBody Pais pais) {
        return paisService.savePais(pais);
    }

    @DeleteMapping(value = "/pais/delete/{id}", produces = "application/json")
    @Override
    public Mono<Pais> deletePais(@PathVariable Long id) {
        return paisService.deletePais(id);
    }

    @PutMapping(value = "/pais/update", produces = "application/json")
    @Override
    public Mono<Pais> updatePais(@RequestBody Pais paisNew) {
        return paisService.updatePais(paisNew);
    }

    @GetMapping(value = "/test", produces = "application/json")
    @Override
    public String test() {
        return "Web Service Reactivo Funcionando";
    }
}
