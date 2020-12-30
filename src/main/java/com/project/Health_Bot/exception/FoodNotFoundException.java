/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 * Questa classe  contiene il metodo che segnala l'eccezione riguardante la non esistenza del cibo inserito. 
 *
 */
public class FoodNotFoundException extends Exception {

	 /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public FoodNotFoundException() {
        super();
    }

    /**
     * 
     * @param message
     */
    public FoodNotFoundException(String message) {
        super(message);
    }
}
