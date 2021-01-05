/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.List;
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
     * Inserisce una misurazione vuota o annulla tutti i campi dell'ultima misurazione giornaliera
     */
    public void inserisciMisurazione();

    /**
     * Restituisce le misurazioni dell'utente, sotto forma di Vector di oggetti Misurazione
     * 
     * @return Vector<Misurazione>
     */
    public Vector<Misurazione> getMisurazioni();

    /**
     * Restituisce le ultime N misurazioni, sotto forma di Vector di oggetti Misurazione
     * 
     * @param ultimeN misurazioni di un utente
     * @return Vector<Misurazione>
     */
    public Vector<Misurazione> getMisurazioni(int ultimeN);

    /**
     * Restituisce il tipo di utente {"sed", "sport", "pes"}, come stringa
     * 
     * @return Tipo di utente
     */
    public String getTipo();

    /**
     * Restituisce una dieta casuale, come Lista di di Vector di oggetti Misurazione, sulla base
     * dell'intero fcg
     * 
     * @param fcg
     * @return List<Vector<Alimento>>
     */
    public List<Vector<Alimento>> getDieta(int fcg);
}
