/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Vector;
import com.project.Health_Bot.util.GestioneJSONOffline;

/**
 * Classe che modella l'utente sedentario.
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux 
 *
 */
public class Sedentario extends Utente {

    private Vector<Misurazione> misurazioni;

    /**
     * Costruttore di default
     */
    public Sedentario() {
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
    public Sedentario(Character sesso, int altezza, float peso, int annoNascita) {
        super(sesso, altezza, peso, annoNascita);
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
    public Sedentario(Character sesso, int altezza, float peso, int annoNascita, Vector<Misurazione> misurazioni) {
        super(sesso, altezza, peso, annoNascita);
        this.misurazioni = new Vector<Misurazione>();
        for (Misurazione m : misurazioni) // Trasferisce la lista di misurazioni
            this.misurazioni.add(m);
    }
    
    /**
	 * Metodo che genera un numero casuale e restituisce un allenamento salvato nel file
	 * 
	 * @return Allenamento per utente Sedentario
	 */
    public String getAllenamento() {
		// numero da 0 e 2 inclusi
		int n = (int) (Math.random() * 3);
		// chiamata metodo JSONOffline
		return GestioneJSONOffline.getAllenamento("sed", n);
	}
}
