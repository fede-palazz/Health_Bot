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
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public InvalidUpdateException() {
        super();
    }

    /**
     * 
     * @param message
     */
    public InvalidUpdateException(String message) {
        super(message);
    }

}
