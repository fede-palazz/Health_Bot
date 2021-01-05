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
 *         filtraggio, cioè maschio o femmina, i possibili valori che può assumere sesso.
 *
 */
public class FiltroGenere extends FiltriUser {

    /**
     * Attributo che può essere maschio o femmina
     */
    private char sesso;

    /**
     * Costruttore
     * 
     * @param sesso
     */
    public FiltroGenere(char sesso) {
        super();
        this.sesso = sesso;
    }

    @Override
    public void filtra(Vector<Utente> utenti) {
        Iterator<Utente> iter = utenti.iterator();
        while (iter.hasNext()) {
            Utente user = iter.next(); // Prossimo utente
            if (user.getSesso().get() != sesso)
                iter.remove();
        }
    }

    @Override
    public void validate() {
        if (sesso != 'M' && sesso != 'F')
            throw new FilterArgumentException("Genere inserito non valido (ammessi 'M', 'F')");
    }

}
