package br.com.willalves.webFluxApi.service;

import br.com.willalves.webFluxApi.payload.PlanetPayload;
import br.com.willalves.webFluxApi.payload.ResultPayload;
import br.com.willalves.webFluxApi.model.Planet;
import br.com.willalves.webFluxApi.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class SwapiService {
    private final WebClient webClient;

    @Autowired
    PlanetRepository planetRepository;

    public SwapiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://swapi.co/api/").build();
    }

    public Mono<Planet> getPlanetsOnSave(Planet planet) {
        return this.webClient.get().uri("/planets/?search={name}", planet.getName())
                .retrieve()
                .bodyToMono(ResultPayload.class)
                .flatMap(result -> {
                    if(result.results.isEmpty()) {
                        planet.setMovie_appearances(result.results.get(0).getFilms().size());
                        return planetRepository.save(planet);
                    }else{
                        return planetRepository.save(planet);
                    }
                });
    }

    public Mono<List<PlanetPayload>> getAllPlanets() {
        return this.webClient.get().uri("/planets/")
                .retrieve()
                .bodyToMono(ResultPayload.class)
                .flatMap(result -> {
                    return Mono.just(
                            result.results
                    );
                });
    }
}
