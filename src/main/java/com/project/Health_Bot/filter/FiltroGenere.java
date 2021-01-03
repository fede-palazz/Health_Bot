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

    @Override
    public void filtra(Vector<Utente> misure) {
        // TODO Auto-generated method stub

    }

    @Override
    public void validate() {
        if (sesso != 'M' || sesso != 'F')
            throw new FilterArgumentException("Genere inserito non valido (ammessi 'M', 'F')");
    }

}
