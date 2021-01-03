package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Utente;

public class FiltroEta extends FiltriUser {

    private Integer etaMin, etaMax;

    public FiltroEta(Integer etaMin, Integer etaMax) {
        super();
        this.etaMin = etaMin;
        this.etaMax = etaMax;
    }

    @Override
    public void filtra(Vector<Utente> misure) {
        // TODO Auto-generated method stub

    }

    @Override
    public void validate() {
        if (etaMin != null && etaMin < 0)
            throw new FilterArgumentException("L'età minima non può essere negativa");
        if (etaMax != null && etaMax < etaMin)
            throw new FilterArgumentException("L'età massima non può essere minore di quella minima");
    }

}
