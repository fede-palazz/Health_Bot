
package com.project.Health_Bot.dao;

import com.project.Health_Bot.model.Utente;

/**
 * Interfaccia che modella l'utente già registrato
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public interface UtenteRegDao {

    /**
     * Restituisce "True" se l'utente specificato è già registrato nel sistema
     * Restituisce "False" se l'utente non è registrato nel sistema o lo è parzialmente
     * 
     * @param id
     */
    public boolean isRegistered(String id);

    /**
     * Inserisce un nuovo utente in fase di registrazione
     * 
     * @param id
     * @param user
     */
    public Utente inserisciUtente(String id, Utente user);

    /**
     * Aggiorna il peso attuale dell'utente
     * 
     * @param id
     * @param peso
     */
    public void aggiornaPeso(String id, float peso);

    /**
     * Aggiorna l'altezza in cm dell'utente
     * 
     * @param id
     * @param altezza
     */
    public void aggiornaAltezza(String id, int altezza);

    /**
     * Inserisce una nuova misurazione per l'utente specificato
     * 
     * @param id
     * @param peso
     * @param lbm
     * @param bmi
     */
    public void inserisciMisurazione(String id, float peso, float lbm, float bmi);

    public Utente getUtente(String id);
}
