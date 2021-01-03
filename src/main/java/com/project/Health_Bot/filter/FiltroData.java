package com.project.Health_Bot.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Misurazione;

public class FiltroData extends FiltriMis {

    private String dataInizio, dataFine;
    SimpleDateFormat df; // Oggetto formattatore di date

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
            dal = df.parse(dataInizio);
            al = df.parse(dataFine);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        // Ordina le misurazioni in ordine cronologico
        misure.sort((m1, m2) -> m1.getData().compareTo(m2.getData()));
        if (dataInizio != null) {
            for (Misurazione mis : misure)
                if (mis.getData().compareTo(dal) < 0)
                    misure.remove(mis);
        }
        if (dataFine != null) {
            for (Misurazione mis : misure)
                if (mis.getData().compareTo(al) > 0)
                    misure.remove(mis);
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
