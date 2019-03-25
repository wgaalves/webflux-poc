package br.com.willalves.webFluxApi.payload;

import br.com.willalves.webFluxApi.model.Planet;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultPayload {
    @JsonProperty("count")
    public Integer count;
    @JsonProperty("next")
    public Object next;
    @JsonProperty("previous")
    public Object previous;
    @JsonProperty("results")
    public List<PlanetPayload> results = null;
}
