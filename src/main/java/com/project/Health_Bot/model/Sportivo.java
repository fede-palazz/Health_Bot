/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Vector;

public class Sportivo extends Utente {

    private Vector<Misurazione> misurazioni;

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
    public Sportivo(Character sesso, int altezza, double peso, int annoNascita) {
        super(sesso, altezza, peso, annoNascita);
        misurazioni = new Vector<Misurazione>();
    }

    public Sportivo(Character sesso, int altezza, double peso, int annoNascita, Vector<Misurazione> misurazioni) {
        super(sesso, altezza, peso, annoNascita);
        this.misurazioni = new Vector<Misurazione>();
        for (Misurazione m : misurazioni) // Trasferisce la lista di misurazioni
            this.misurazioni.add(m);
    }

}
