package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;

public abstract class FiltriMis {

    /**
     * Implementa l'operazione di filtraggio delle misurazioni sulla base dei parametri precedentemente
     * ricevuti
     * 
     * @param mis
     */
    public abstract void filtra(Vector<Misurazione> misure);

    /**
     * Verifica che i parametri passati in ingresso al filtro siano validi o meno
     * 
     * @return
     */
    public abstract void validate();
}
