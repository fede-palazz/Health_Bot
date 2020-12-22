/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Vector;

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

}
