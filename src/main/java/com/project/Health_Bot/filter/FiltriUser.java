package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.model.Utente;

public abstract class FiltriUser {

    /**
     * Implementa l'operazione di filtraggio degli utenti sulla base dei parametri precedentemente
     * ricevuti
     * 
     * @param misure
     */
    public abstract void filtra(Vector<Utente> utenti);

    /**
     * Verifica che i parametri passati in ingresso al filtro siano validi o meno
     * 
     * @return
     */
    public abstract void validate();

}
