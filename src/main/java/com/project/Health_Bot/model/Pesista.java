/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Date;
import java.util.Vector;
import com.project.Health_Bot.util.GestioneJSONOffline;

/**
 * Classe che modella l'utente pesista.
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class Pesista extends Utente implements Misura {

    private Vector<Misurazione> misurazioni;

    /**
     * Costruttore di default
     */
    public Pesista() {
        super();
        misurazioni = new Vector<Misurazione>();
    }

    /**
     * Costruttore
     * 
     * @param sesso
     * @param altezza
     * @param peso
     * @param annoNascita
     */
    public Pesista(Character sesso, int altezza, float peso, int annoNascita) {
        super(sesso, altezza, peso, annoNascita);
        misurazioni = new Vector<Misurazione>();
    }

    /**
     * Costruttore
     * 
     * @param genere
     * @param altezza
     * @param peso
     * @param età
     */
    public Pesista(Character sesso, int altezza, float peso, int annoNascita, Vector<Misurazione> misurazioni) {
        super(sesso, altezza, peso, annoNascita);
        this.misurazioni = new Vector<Misurazione>();
        for (Misurazione m : misurazioni) // Trasferisce la lista di misurazioni
            this.misurazioni.add(m);
    }

    /**
     * Metodo che genera un numero casuale e restituisce un allenamento salvato nel file
     * 
     * @return Allenamento per utente Pesista
     */
    public String getAllenamento() {
        // numero da 0 e 2 inclusi
        int n = (int) (Math.random() * 3);
        // chiamata metodo JSONOffline
        return GestioneJSONOffline.getAllenamento("pes", n);

    }

    @Override
    public void inserisciMisurazione(float peso, float lbm, float bmi) {
        misurazioni.add(new Misurazione(peso, lbm, bmi, new Date()));
        // TODO Verificare la presenza di una misurazione con stesso giorno e, in caso, aggiornare i dati mantenendo la data
    }

}
