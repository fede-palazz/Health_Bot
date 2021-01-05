/**
 * 
 */
package com.project.Health_Bot.filter;

import java.util.Iterator;
import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Misurazione;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Modella il filtro sul bmi, estendendo la superclasse FiltriMis. Usa due valori di
 *         filtraggio, uno minimo, il bmiMin, ed un valore massimo, il bmiMax.
 *
 */
public class FiltroBmi extends FiltriMis {

    /**
     * Valori minimo e massimo di filtraggio
     */
    private Float bmiMin, bmiMax;

    /**
     * Costruttore
     * 
     * @param bmiMin
     * @param bmiMax
     */
    public FiltroBmi(Float bmiMin, Float bmiMax) {
        super();
        this.bmiMin = bmiMin;
        this.bmiMax = bmiMax;
    }

    @Override
    public void filtra(Vector<Misurazione> misure) {
        if (bmiMin != null) {
            Iterator<Misurazione> iter = misure.iterator();
            while (iter.hasNext()) {
                Misurazione mis = iter.next(); // Prossima misurazione
                if (mis.getBmi() < bmiMin)
                    iter.remove();
            }
        }
        if (bmiMax != null) {
            Iterator<Misurazione> iter = misure.iterator();
            while (iter.hasNext()) {
                Misurazione mis = iter.next(); // Prossima misurazione
                if (mis.getBmi() > bmiMax)
                    iter.remove();
            }
        }
    }

    @Override
    public void validate() {
        if (bmiMin != null && bmiMin < 0)
            throw new FilterArgumentException("Il bmi minimo non può essere negativo");
        if (bmiMin != null && bmiMax != null && bmiMax < bmiMin)
            throw new FilterArgumentException("Il bmi massimo non può essere minore di quello minimo");
    }

}
