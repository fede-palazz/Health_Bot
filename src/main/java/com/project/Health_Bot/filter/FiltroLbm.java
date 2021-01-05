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
 *         Modella il filtro sull'lbm, estendendo la superclasse FiltriMis. Usa due valori di
 *         filtraggio, uno minimo, il lbmMin, ed un valore massimo, il lbmMax.
 *
 */
public class FiltroLbm extends FiltriMis {

    /**
     * Valori minimo e massimo di filtraggio
     */
    private Float lbmMin, lbmMax;

    /**
     * Costruttore
     * 
     * @param lbmMin
     * @param lbmMax
     */
    public FiltroLbm(Float lbmMin, Float lbmMax) {
        super();
        this.lbmMin = lbmMin;
        this.lbmMax = lbmMax;
    }

    @Override
    public void filtra(Vector<Misurazione> misure) {
        if (lbmMin != null) {
            Iterator<Misurazione> iter = misure.iterator();
            while (iter.hasNext()) {
                Misurazione mis = iter.next(); // Prossima misurazione
                if (mis.getLbm() < lbmMin)
                    iter.remove();
            }

        }
        if (lbmMax != null) {
            Iterator<Misurazione> iter = misure.iterator();
            while (iter.hasNext()) {
                Misurazione mis = iter.next(); // Prossima misurazione
                if (mis.getLbm() > lbmMax)
                    iter.remove();
            }
        }
    }

    @Override
    public void validate() {
        if (lbmMin != null && lbmMin < 0)
            throw new FilterArgumentException("L'lbm minimo non può essere negativo");
        if (lbmMax != null && lbmMax < lbmMin)
            throw new FilterArgumentException("L'lbm massimo non può essere minore di quello minimo");
    }

}
