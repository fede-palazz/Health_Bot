/**
 * 
 */
package com.project.Health_Bot.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Misurazione;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Modella il filtro sulla data, estendendo la superclasse FiltriUser. Usa due valori di
 *         filtraggio, uno minimo, dataInizio, ed un valore massimo, dataFine.
 *
 */
public class FiltroData extends FiltriMis {

    /**
     * Valori minimo e massimo di filtraggio
     */
    private String dataInizio, dataFine;

    /**
     * Oggetto formattatore di date
     */
    SimpleDateFormat df;

    /**
     * Costruttore
     * 
     * @param dataInizio
     * @param dataFine
     */
    public FiltroData(String dataInizio, String dataFine) {
        super();
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        df = new SimpleDateFormat("dd-MM-yyyy");
    }

    @Override
    public void filtra(Vector<Misurazione> misure) {
        // Crea le date a partire dalle stringhe
        Date dal = null, al = null;
        try {
            if (dataInizio != null)
                dal = df.parse(dataInizio);
            if (dataFine != null)
                al = df.parse(dataFine);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        // Ordina le misurazioni in ordine cronologico
        misure.sort((m1, m2) -> m1.getData().compareTo(m2.getData()));
        // Istanzia un nuovo iteratore

        if (dataInizio != null) {
            Iterator<Misurazione> iter = misure.iterator();
            while (iter.hasNext()) {
                Misurazione m = iter.next(); // Prossima misurazione
                if (m.getData().compareTo(dal) < 0) // Data misurazione precedente alla minima richiesta
                    iter.remove();
                else
                    break;
            }

        }
        if (dataFine != null) {
            Iterator<Misurazione> iter = misure.iterator();
            while (iter.hasNext()) {
                Misurazione m = iter.next(); // Prossima misurazione
                if (m.getData().compareTo(al) > 0) // Data misurazione precedente alla minima richiesta
                    iter.remove();
            }
        }
    }

    @Override
    public void validate() {
        Date dal = null, al = null;
        try {
            dal = df.parse(dataInizio);
            al = df.parse(dataFine);
        }
        catch (ParseException e) {
            throw new FilterArgumentException("Date inserite non valide (formato accettato 'dd-MM-yyyy')");
        }
        if (al != null && al.compareTo(dal) < 0)
            throw new FilterArgumentException("La data finale non può essere precedente a quella iniziale");
    }

}
