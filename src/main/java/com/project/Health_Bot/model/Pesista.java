/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Vector;
import com.project.Health_Bot.util.GestioneJSONOffline;

/**
 * Classe che modella l'utente pesista.
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class Pesista extends Utente {

    private Vector<Misurazione> misurazioni;

    /**
     * Costruttore di default
     */
    public Pesista() {
        super();
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
     * @param stileDiVita
     */
    public Pesista(Character sesso, int altezza, float peso, int annoNascita, Vector<Misurazione> misurazioni) {
        super(sesso, altezza, peso, annoNascita);
        this.misurazioni = new Vector<Misurazione>();
        for (Misurazione m : misurazioni) // Trasferisce la lista di misurazioni
            this.misurazioni.add(m);
    }

	/**
	 * Metodo che genera un numero casuale e restituisce un allenamento salvato nel file
	 * @return Allenamento per utente Pesista
	 */
	public String getAllenamentoPesista() {
		// numero da 0 e 2 inclusi
		int n = (int) (Math.random() * 3);
		// chiamata metodo JSONOffline
		String allenamento = GestioneJSONOffline.getAllenamento("pes", n);
		return allenamento;
	}

}
