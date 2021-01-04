package com.project.Health_Bot.filter;

import java.util.Iterator;
import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Utente;

public class FiltroGenere extends FiltriUser {

    private char sesso;

    public FiltroGenere(char sesso) {
        super();
        this.sesso = sesso;
    }

    /**
     * Filtra gli utenti in base al sesso specificato
     */
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
