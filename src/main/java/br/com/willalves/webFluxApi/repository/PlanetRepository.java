package br.com.willalves.webFluxApi.repository;

import br.com.willalves.webFluxApi.model.Planet;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetRepository extends ReactiveCassandraRepository<Planet, Integer>{

    @AllowFiltering
    Mono<Planet> findByName(String name);
}
