/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Vector;

public class Pesista extends Utente {

    private Vector<Misurazione> misurazioni;

    public Pesista() {
        super();
    }

    public Pesista(Character sesso, int altezza, double peso, int annoNascita) {
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
    public Pesista(Character sesso, int altezza, double peso, int annoNascita, Vector<Misurazione> misurazioni) {
        super(sesso, altezza, peso, annoNascita);
        this.misurazioni = new Vector<Misurazione>();
        for (Misurazione m : misurazioni) // Trasferisce la lista di misurazioni
            this.misurazioni.add(m);
    }

}
