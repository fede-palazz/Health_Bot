/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Vector;
import com.project.Health_Bot.util.GestioneJSONOffline;

public class Sportivo extends Utente {

	private static String utenteSportivo;
	private String stileDiVita;

	private Vector<Misurazione> misurazioni;
	
    /**
     * Costruttore di default
     */
   	public Sportivo() {
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
    public Sportivo(Character sesso, int altezza, float peso, int annoNascita) {
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
     * @param misurazioni
     */
    public Sportivo(Character sesso, int altezza, float peso, int annoNascita, Vector<Misurazione> misurazioni) {
        super(sesso, altezza, peso, annoNascita);
        this.misurazioni = new Vector<Misurazione>();
        for (Misurazione m : misurazioni) // Trasferisce la lista di misurazioni
            this.misurazioni.add(m);
    }
    
    /**
	 * Metodo che genera un numero casuale e restituisce un allenamento salvato nel file
	 * @return Allenamento per utente Sportivo 
	 */
    public String getAllenamentoSportivo() {
		// numero da 0 e 2 inclusi
		int n = (int) (Math.random() * 3);
		// chiamata metodo JSONOffline
		String allenamento = GestioneJSONOffline.getAllenamento("sport", n);
		return allenamento;
	}

}
