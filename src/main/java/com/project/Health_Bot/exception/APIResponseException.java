/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Classe che gestisce le eccezioni di tipo APIResponse
 *
 */
public class APIResponseException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public APIResponseException() {
        super();
    }

    /**
     * 
     * @param message
     */
    public APIResponseException(String message) {
        super(message);
    }
}
