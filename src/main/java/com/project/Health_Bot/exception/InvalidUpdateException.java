/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Classe che gestisce le eccezioni di tipo InvalidUpdate
 * 
 */
public class InvalidUpdateException extends Exception {

    /**
     * Serial ID generale dell'eccezione, generato automaticamente
     */
    private static final long serialVersionUID = 1L;

    /**
     * Costruttore di default
     */
    public InvalidUpdateException() {
        super();
    }

    /**
     * Costruttore
     * 
     * @param message
     */
    public InvalidUpdateException(String message) {
        super(message);
    }

}
