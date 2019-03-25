package br.com.willalves.webFluxApi.repository;

import br.com.willalves.webFluxApi.model.Planet;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetRepository extends ReactiveCrudRepository<Planet, String> {

    @AllowFiltering
    Mono<Planet> findByName(String name);

    @AllowFiltering
    Mono<Planet> findById(String id);


}
