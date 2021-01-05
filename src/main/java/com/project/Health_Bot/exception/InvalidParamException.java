/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Questa classe contiene l'eccezione riguardante il non inserimento
 *         corretto di un parametro.
 * 
 */
public class InvalidParamException extends IllegalArgumentException {

    /**
     * Serial ID generale dell'eccezione, generato automaticamente
     */
    private static final long serialVersionUID = 1L;

    /**
     * Messaggio generato dall'eccezione
     */
    private String message;

    /**
     * Costruttore di default
     */
    public InvalidParamException() {
        super();
    }

    /**
     * Costruttore
     * 
     * @param message
     */
    public InvalidParamException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * Restituisce il messaggio generato dall'eccezione, sotto forma di stringa
     * 
     * @return message
     */
    public String getMessage() {
        return message;
    }

}
