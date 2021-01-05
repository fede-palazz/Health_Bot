/**
 * 
 */
package com.project.Health_Bot.dao;

import java.util.List;
import java.util.Vector;
import com.project.Health_Bot.model.Alimento;
import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Utente;

/**
 * Modella l'interfaccia di accesso ai dati dell'utente ancora registrato
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
     * @return utente registrato nel Bot
     */
    public boolean isRegistered(String id);

    /**
     * Inserisce un nuovo utente nel DB
     * 
     * @param id
     * @param user id
     */
    public Utente inserisciUtente(String id, Utente user);

    /**
     * Se presente, restituisce l'utente con l'id specificato
     * 
     * @param id
     * @return id dell'utente registrato
     */
    public Utente getUtente(String id);

    /**
     * Rimuove l'utente specificato dal DB in memoria e lo restituisce
     * 
     * @param id
     * @return rimozione dell'utente
     */
    public Utente rimuoviUtente(String id);

    /**
     * Restituisce il tipo di utente ("sed", "sport", "pes")
     * 
     * @param user
     * @return livello di attività fisica
     */
    public String getTipo(Utente user);

    /**
     * Aggiorna il peso attuale dell'utente in Kg
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
     * @return Vector<Misurazione>
     */
    public Misurazione getUltimaMisurazione(Utente user);

    /**
     * Restituisce un allenamento casuale in base al tipo di utente
     * 
     * @param user
     * @return allenamento in Stringa
     */
    public String getAllenamento(Utente user);

    /**
     * Restituisce una dieta casuale in base al tipo di utente
     * 
     * @param fcg
     * @param user
     * @return dieta
     */
    public List<Vector<Alimento>> getDieta(Utente user, int fcg);

    /**
     * Restituisce true se l'ultima misurazione registrata dell'utente è vuota, altrimenti false
     * 
     * @param user
     * @return true o faslse, un boolean
     */
    public boolean isLastMisEmpty(Utente user);

    /**
     * Salva il DB degli utenti e delle misurazioni nel file JSON locale
     */
    public void salvaDB();

}
