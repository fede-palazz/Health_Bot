/**
 * 
 */
package com.project.Health_Bot.filter;

import java.util.Iterator;
import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Utente;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Modella il filtro sull'età, estendendo la superclasse FiltriUser. Usa due valori di
 *         filtraggio, uno minimo, etaMin, ed un valore massimo, etaMax.
 *
 */
public class FiltroEta extends FiltriUser {

    /**
     * Valori minimo e massimo di filtraggio
     */
    private Integer etaMin, etaMax;

    /**
     * Costruttore
     * 
     * @param etaMin
     * @param etaMax
     */
    public FiltroEta(Integer etaMin, Integer etaMax) {
        super();
        this.etaMin = etaMin;
        this.etaMax = etaMax;
    }

    @Override
    public void filtra(Vector<Utente> utenti) {
        if (etaMin != null) {
            Iterator<Utente> iter = utenti.iterator();
            while (iter.hasNext()) {
                Utente user = iter.next(); // Prossimo utente
                if (user.getEta().get() < etaMin)
                    iter.remove();
            }
        }
        if (etaMax != null) {
            Iterator<Utente> iter = utenti.iterator();
            while (iter.hasNext()) {
                Utente user = iter.next(); // Prossimo utente
                if (user.getEta().get() > etaMax)
                    iter.remove();
            }
        }
    }

    @Override
    public void validate() {
        if (etaMin != null && etaMin < 0)
            throw new FilterArgumentException("L'età minima non può essere negativa");
        if (etaMin != null && etaMax != null && etaMax < etaMin)
            throw new FilterArgumentException("L'età massima non può essere minore di quella minima");
    }

}
