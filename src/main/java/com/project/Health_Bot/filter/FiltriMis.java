/**
 * 
 */
package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;

/**
 * 
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public abstract class FiltriMis {

    /**
     * 
     * @param misure
     */
    public abstract void filtra(Vector<Misurazione> misure);

    /**
     * Verifica che i parametri passati in ingresso al filtro siano validi o meno
     * 
     */
    public abstract void validate();
}
