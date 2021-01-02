package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;

public class FiltroGenere extends Filtri {

    private char sesso;

    public FiltroGenere(char sesso) {
        super();
        this.sesso = sesso;
    }

    @Override
    public void filtra(Vector<Misurazione> misure) {
        // TODO Auto-generated method stub

    }

}
