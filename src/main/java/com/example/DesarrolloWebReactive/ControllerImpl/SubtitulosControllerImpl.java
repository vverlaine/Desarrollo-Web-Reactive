package com.example.DesarrolloWebReactive.ControllerImpl;

import com.example.DesarrolloWebReactive.Controller.SubtitulosController;
import com.example.DesarrolloWebReactive.Entity.Subtitulos;
import com.example.DesarrolloWebReactive.Service.SubtitulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SubtitulosControllerImpl implements SubtitulosController {

    @Autowired
    SubtitulosService subtitulosService;

    @GetMapping(value = "/subtitulos", produces = "application/json")
    @Override
    public Flux<Subtitulos> findAllSubtitulos() {
        return subtitulosService.findAllSubtitulos();
    }

    @GetMapping(value = "/subtitulos/{id}", produces = "application/json")
    @Override
    public Mono<Subtitulos> findSubtitulosById(@PathVariable Long id) {
        return subtitulosService.findSubtitulosById(id);
    }

    @PostMapping(value = "/subtitulos/create", produces = "application/json")
    @Override
    public Mono<Subtitulos> saveSubtitulos(@RequestBody Subtitulos SubtitulosNew) {
        return subtitulosService.saveSubtitulos(SubtitulosNew);
    }

    @DeleteMapping(value = "/subtitulos/delete/{id}", produces = "application/json")
    @Override
    public Mono<Subtitulos> deleteSubtitulos(@PathVariable Long id) {
        return subtitulosService.deleteSubtitulos(id);
    }

    @PutMapping(value = "/subtitulos/update", produces = "application/json")
    @Override
    public Mono<Subtitulos> updateSubtitulos(@RequestBody Subtitulos SubtitulosNew) {
        return subtitulosService.updateSubtitulos(SubtitulosNew);
    }
}
