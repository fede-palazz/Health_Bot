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

    /**
     * Filtra gli utenti in base ai valori minimi e massimi di età specificati
     * 
     */
    @Override
    public void filtra(Vector<Utente> utenti) {
        if (etaMin != null) {
            for (Utente user : utenti)
                if (user.getEta().get() < etaMin)
                    utenti.remove(user);
        }
        if (etaMax != null) {
            for (Utente user : utenti)
                if (user.getEta().get() > etaMax)
                    utenti.remove(user);
        }
    }

    @Override
    public void validate() {
        if (etaMin != null && etaMin < 0)
            throw new FilterArgumentException("L'età minima non può essere negativa");
        if (etaMax != null && etaMax < etaMin)
            throw new FilterArgumentException("L'età massima non può essere minore di quella minima");
    }

}
