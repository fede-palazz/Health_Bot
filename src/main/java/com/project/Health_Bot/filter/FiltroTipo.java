package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;

public class FiltroTipo extends FiltriUser {

    private String tipo;

    public FiltroTipo(String tipo) {
        super();
        this.tipo = tipo;
    }

    @Override
    public void filtra(Vector<Utente> utenti) {
        switch (tipo) {
        case "sed":
            for (Utente user : utenti)
                if (!(user instanceof Sedentario))
                    utenti.remove(user);
            break;

        case "sport":
            for (Utente user : utenti)
                if (!(user instanceof Sportivo))
                    utenti.remove(user);
            break;

        case "pes":
            for (Utente user : utenti)
                if (!(user instanceof Pesista))
                    utenti.remove(user);
            break;
        }

    }

    @Override
    public void validate() {
        if (!(tipo.equals("sed") || tipo.equals("sport") || tipo.equals("pes")))
            throw new FilterArgumentException("Tipo inserito non valido (ammessi 'sed', 'sport', 'pes')");
    }

}
