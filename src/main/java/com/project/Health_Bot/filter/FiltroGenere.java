package com.project.Health_Bot.filter;

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
        for (Utente user : utenti)
            if (user.getSesso().get() != sesso)
                utenti.remove(user);
    }

    @Override
    public void validate() {
        if (sesso != 'M' || sesso != 'F')
            throw new FilterArgumentException("Genere inserito non valido (ammessi 'M', 'F')");
    }

}
