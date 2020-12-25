/**
 * 
 */
package com.project.Health_Bot.dao;

import com.project.Health_Bot.model.Utente;

/**
 * Interfaccia che modella l'utente non ancora registrato
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public interface UtenteNonRegDao {

    /**
     * Verifica se l'utente è in fase di registrazione o meno
     * 
     * @param id
     * @return Boolean
     */
    public Boolean isRegistering(String id);

    /**
     * Restituisce il nome del primo attributo nullo dell'utente specificato (null se tutti i campi sono
     * compilati)
     * 
     * @param id
     * @return String
     */
    public String getCampoVuoto(String id);

    /**
     * Restituisce l'utente con l'id specificato, null se non è presente
     * 
     * @param id
     * @return
     */
    public Utente getUtente(String id);

    /**
     * Registra un nuovo utente al sistema (attributi nulli)
     * 
     * @param id
     */
    public void nuovoUtente(String id);

    /**
     * Regista il sesso dell'utente
     * 
     * @param id
     * @param sesso
     */
    public void registraSesso(String id, char sesso);

    /**
     * Registra il peso attuale dell'utente
     * 
     * @param id
     * @param peso
     */
    public void registraPeso(String id, float peso);

    /**
     * Registra l'altezza in cm dell'utente
     * 
     * @param id
     * @param altezza
     */
    public void registraAltezza(String id, int altezza);

    /**
     * Registra l'anno di nascita dell'utente
     * 
     * @param id
     * @param anno
     */
    public void registraAnno(String id, int anno);

    /**
     * Rimuove un utente da quelli in fase di registrazione e lo restituisce
     * 
     * @param id
     */
    public Utente rimuoviUtente(String id);

}
