/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Questa classe contiene l'eccezione riguardante la non esistenza del
 *         cibo inserito.
 *
 */
public class FoodNotFoundException extends Exception {

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
    public FoodNotFoundException() {
        super();
    }

    /**
     * Costruttore
     * 
     * @param message
     */
    public FoodNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * Restituisce il messaggio generato dall'eccezione, sotto forma di stringa
     * 
     * @return mess
     */
    public String getMessage() {
        return message;
    }

}
