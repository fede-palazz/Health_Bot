package com.project.Health_Bot.filter;

import java.util.Vector;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.Health_Bot.exception.InvalidWeightException;

public class GestoreFiltri {

    private Vector<Filtri> filtri;

    public GestoreFiltri(@JsonProperty("etaMin") Integer etaMin, @JsonProperty("etaMax") Integer etaMax,
            @JsonProperty("gen") String genere, @JsonProperty("tipo") String tipo,
            @JsonProperty("pesoMin") Float pesoMin, @JsonProperty("pesoMax") Float pesoMax) throws Exception {

        filtri = new Vector<Filtri>();
        // Crea un filtro sull'età
        if (etaMin != null || etaMax != null)
            filtri.add(new FiltroEta(etaMin, etaMax));
        // Crea un filtro sul genere
        if (genere != null)
            filtri.add(new FiltroGenere(genere.toUpperCase().charAt(0)));
        // Crea un filtro sul peso
        if (pesoMin != null || pesoMax != null)
            filtri.add(new FiltroPeso(pesoMin, pesoMax));
        if (etaMin < 5)
            throw new InvalidWeightException("Beneee");

    }

}
