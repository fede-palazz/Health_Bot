/**
 * 
 */
package com.project.Health_Bot.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import com.project.Health_Bot.util.JSONOffline;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che modella l'utente sedentario.
 *
 */
public class Sedentario extends Utente implements Misura {

    /**
     * Attributo misurazioni, espresso come Vector di oggetti Misurazione
     */
    private Vector<Misurazione> misurazioni;

    /**
     * Oggetto dieta
     */
    private Dieta dieta;

    /**
     * Costruttore di default
     */
    public Sedentario() {
        super();
        misurazioni = new Vector<Misurazione>();
        dieta = new Dieta();
    }

    /**
     * Costruttore
     * 
     * @param sesso
     * @param altezza
     * @param peso
     * @param annoNascita
     */
    public Sedentario(Character sesso, int altezza, float peso, int annoNascita) {
        super(sesso, altezza, peso, annoNascita);
        misurazioni = new Vector<Misurazione>();
        dieta = new Dieta();
    }

    /**
     * Costruttore
     * 
     * @param sesso
     * @param altezza
     * @param peso
     * @param annoNascita
     */
    public Sedentario(Character sesso, int altezza, float peso, int annoNascita, Vector<Misurazione> misurazioni) {
        super(sesso, altezza, peso, annoNascita);
        this.misurazioni = new Vector<Misurazione>();
        this.dieta = new Dieta();
        for (Misurazione m : misurazioni) // Trasferisce la lista di misurazioni
            this.misurazioni.add(m);
    }

    /**
     * Metodo che genera un numero casuale e restituisce un allenamento salvato nel file
     * allenamenti.json
     * 
     * @return Allenamento per utente Sedentario
     */
    public String getAllenamento() {
        // numero da 0 e 2 inclusi
        int n = (int) (Math.random() * 3);
        // chiamata metodo JSONOffline
        return JSONOffline.getAllenamento("sed", n);
    }

    @Override
    public void inserisciMisurazione() {
        // Controllo se esiste una misurazione effettuata nello stesso giorno
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); // Oggetto formattatore di date
        String dataOggi = df.format(new Date());
        // Confronto la data con quella dell'ultima misurazione
        if (misurazioni.size() > 0 && df.format(misurazioni.get(misurazioni.size() - 1).getData()).equals(dataOggi))
            // Elimino l'ultima misurazione
            misurazioni.remove(misurazioni.size() - 1);
        // Aggiungo una nuova misurazione vuota
        misurazioni.add(new Misurazione(new Date()));
    }

    @Override
    public void inserisciMisurazione(float peso, float lbm, float bmi) {
        // Controllo se esiste una misurazione effettuata nello stesso giorno
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); // Oggetto formattatore di date
        String dataOggi = df.format(new Date());
        // Confronto la data con quella dell'ultima misurazione
        if (misurazioni.size() > 0 && df.format(misurazioni.get(misurazioni.size() - 1).getData()).equals(dataOggi)) {
            // Aggiorno l'ultima misurazione
            misurazioni.get(misurazioni.size() - 1).setPeso(peso);
            misurazioni.get(misurazioni.size() - 1).setLbm(lbm);
            misurazioni.get(misurazioni.size() - 1).setBmi(bmi);
        }
        else // Aggiungo una nuova misurazione
            misurazioni.add(new Misurazione(peso, lbm, bmi, new Date()));
    }

    @Override
    public void inserisciMisurazione(Misurazione misura) {
        misurazioni.add(misura);
    }

    @Override
    public Vector<Misurazione> getMisurazioni() {
        return misurazioni;
    }

    @Override
    public Vector<Misurazione> getMisurazioni(int ultimeN) {
        if (misurazioni.size() <= ultimeN)
            // Se le misurazioni registrate sono inferiori al numero richiesto, restituisce tutto il Vector
            return misurazioni;
        else { // Altrimenti restituisce le ultime N
            Vector<Misurazione> misure = new Vector<Misurazione>();
            for (int i = misurazioni.size() - ultimeN - 1; i < misurazioni.size(); i++)
                misure.add(misurazioni.get(i));
            return misure;
        }

    }

    @Override
    public String getTipo() {
        return "sed";
    }

    @Override
    public List<Vector<Alimento>> getDieta(int fcg) {
        dieta.generaDieta(fcg);
        List<Vector<Alimento>> pasti = new Vector<Vector<Alimento>>();
        pasti.add(dieta.getColazione());
        pasti.add(dieta.getPranzo());
        pasti.add(dieta.getSpuntino());
        pasti.add(dieta.getCena());
        return pasti;
    }
}
