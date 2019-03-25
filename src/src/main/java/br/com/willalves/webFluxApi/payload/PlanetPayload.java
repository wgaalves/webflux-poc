package br.com.willalves.webFluxApi.payload;

import br.com.willalves.webFluxApi.model.Planet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class PlanetPayload extends Planet{

    @JsonIgnore
    @JsonProperty("films")
    public List<String> films = new ArrayList<String>(0);

}
