/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Vector;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Interfaccia che modella l'oggetto misura.
 * 
 */
public interface Misura {

    /**
     * Permette di inserire una nuova misurazione
     * 
     * @param peso
     * @param lbm
     * @param bmi
     */
    public void inserisciMisurazione(float peso, float lbm, float bmi);

    /**
     * Permette di aggiungere una misurazione esistente
     * 
     * @param misura
     */
    public void inserisciMisurazione(Misurazione misura);

    /**
     * Restituisce le misurazioni dell'utente
     */
    public Vector<Misurazione> getMisurazioni();

    /**
     * Restituisce le ultime N misurazioni
     * 
     * @param ultimeN
     * @return
     */
    public Vector<Misurazione> getMisurazioni(int ultimeN);
}
