/**
 * 
 */
package com.project.Health_Bot.dao;

/**
 * Interfaccia che modella l'utente DAO
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public interface UtenteDao {

    /**
     * Metodi gestione dei dati (inserimento utenti, eliminazione, ecc ...)
     * @param username
     * @return
     */
    public boolean isRegistered(String username);
}
