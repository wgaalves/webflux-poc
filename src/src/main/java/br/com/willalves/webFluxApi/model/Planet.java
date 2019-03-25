package br.com.willalves.webFluxApi.model;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Getter
@Setter
public class Planet {

    @PrimaryKey
    private String id = UUIDs.timeBased().toString();

    @JsonProperty("name")
    private String name;

    @JsonProperty("climate")
    private String climate;

    @JsonProperty("terrain")
    private String terrain;

    private Integer movie_appearances = 0;



}
