package br.com.willalves.webFluxApi.controller;

import br.com.willalves.webFluxApi.model.Planet;
import br.com.willalves.webFluxApi.payload.PlanetPayload;
import br.com.willalves.webFluxApi.repository.PlanetRepository;
import br.com.willalves.webFluxApi.service.SwapiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.validation.Valid;


@Slf4j
@RestController
public class PlanetController {

    @Autowired
    PlanetRepository planetRepository;

    @Autowired
    SwapiService swapiService;

    @GetMapping("/planet")
    public Flux<Planet> findDatabasePlanets() {
        return planetRepository.findAll();
    }

    @PostMapping("/planet")
    public Mono<Planet> createPlanet(@Valid @RequestBody Planet planet) {

        return swapiService.getPlanetsOnSave(planet);
    }

    /** if have time is implemente
    @GetMapping("/swapi/planet")
    public Mono<List<PlanetPayload>> getAllPlanetsFromSwapi() {
        return swapiService.getAllPlanets();
    }
     **/

    @GetMapping("/swapi/planet/search")
    public Mono<Planet> getAllPlanetsFromSwapiFromName(@RequestParam(value = "name") String name) {
        return swapiService.getPlanets(name);
    }

    @GetMapping("/planet/{id}")
    public Mono<ResponseEntity<Planet>> getPlanetById(@PathVariable(value = "id") String id) {
        return planetRepository.findById(id)
                .map(planet -> ResponseEntity.ok(planet))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/planet/search")
    public Mono<ResponseEntity<Planet>> getPlanetByName(@RequestParam(value = "name") String name) {
        return planetRepository.findByName(name)
                .map(planet -> ResponseEntity.ok(planet))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/planet/{id}")
    public Mono<ResponseEntity<Void>> deletePlanet(@PathVariable(value = "id") String id) {
        return planetRepository.deleteById(id)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




}
