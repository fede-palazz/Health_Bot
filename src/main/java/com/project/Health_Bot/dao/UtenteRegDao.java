/**
 * 
 */
package com.project.Health_Bot.dao;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;
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
     * Inserisce un nuovo utente nel DB
     * 
     * @param id
     * @param user
     */
    public Utente inserisciUtente(String id, Utente user);

    /**
     * Se presente, restituisce l'utente con l'id specificato
     * 
     * @param id
     * @return
     */
    public Utente getUtente(String id);

    /**
     * Rimuove l'utente specificato dal DB e lo restituisce
     * 
     * @param id
     */
    public Utente rimuoviUtente(String id);

    /**
     * Restituisce il tipo di utente ("sed", "sport", "pes")
     * 
     * @param user
     * @return
     */
    public String getTipo(Utente user);

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
     * Inserisce o aggiorna una misurazione per l'utente specificato
     * 
     * @param id
     * @param peso
     * @param lbm
     * @param bmi
     */
    public void inserisciMisurazione(String id, float peso, float lbm, float bmi);

    /**
     * Inserisce o aggiorna una misurazione vuota
     * 
     * @param id
     * @param peso
     * @param lbm
     * @param bmi
     */
    public void inserisciMisurazione(String id);

    /**
     * Inserisce una misurazione già esistente
     * 
     * @param id
     * @param peso
     * @param lbm
     * @param bmi
     */
    public void inserisciMisurazione(String id, Misurazione misura);

    /**
     * Restituisce tutte le misurazioni registrate di un utente
     * 
     * @param user
     * @return
     */
    public Vector<Misurazione> getMisurazioni(Utente user);

    /**
     * Restituisce l'ultima misurazione registrata dell'utente specificato
     * 
     * @param id
     * @return
     */
    public Misurazione getUltimaMisurazione(Utente user);

    /**
     * Restituisce true se l'ultima misurazione registrata dell'utente è vuota
     * 
     * @param id
     * @return
     */
    public boolean isLastMisEmpty(Utente user);

    /**
     * Salva il DB degli utenti e delle misurazioni nel file JSON locale
     */
    public void salvaDB();

}
