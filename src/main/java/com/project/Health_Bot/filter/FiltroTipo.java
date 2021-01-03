package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Utente;

public class FiltroTipo extends FiltriUser {

    private String tipo;

    public FiltroTipo(String tipo) {
        super();
        this.tipo = tipo;
    }

    @Override
    public void filtra(Vector<Utente> utenti) {
        // TODO Auto-generated method stub

    }

    @Override
    public void validate() {
        if (!(tipo.equals("sed") || tipo.equals("sport") || tipo.equals("pes")))
            throw new FilterArgumentException("Tipo inserito non valido (ammessi 'sed', 'sport', 'pes'");
    }

}
