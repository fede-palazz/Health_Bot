package com.project.Health_Bot.filter;

import java.util.Iterator;
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
        Iterator<Utente> iter = utenti.iterator();
        switch (tipo) {
        case "sed":
            while (iter.hasNext()) {
                Utente user = iter.next(); // Prossimo utente
                if (!(user instanceof Sedentario))
                    iter.remove();
            }
            break;

        case "sport":
            while (iter.hasNext()) {
                Utente user = iter.next(); // Prossimo utente
                if (!(user instanceof Sportivo))
                    iter.remove();
            }
            break;

        case "pes":
            while (iter.hasNext()) {
                Utente user = iter.next(); // Prossimo utente
                if (!(user instanceof Pesista))
                    iter.remove();
            }
            break;
        }

    }

    @Override
    public void validate() {
        if (!(tipo.equals("sed") || tipo.equals("sport") || tipo.equals("pes")))
            throw new FilterArgumentException("Tipo inserito non valido (ammessi 'sed', 'sport', 'pes')");
    }

}
