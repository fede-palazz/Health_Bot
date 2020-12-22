/**
 * 
 */
package com.project.Health_Bot.dao;

import java.util.Optional;

/**
 * Interfaccia che modella l'utente non ancora registrato
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public interface UtenteNonRegDao {

    /**
     * Restituisce il nome del primo attributo nullo dell'utente specificato o null se non ve ne sono
     * 
     * @param id
     * @return Optional<String>
     */
    public Optional<String> getCampoVuoto(String id);

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

}
