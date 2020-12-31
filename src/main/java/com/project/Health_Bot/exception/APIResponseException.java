/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Questa classe contiene il metodo che segnala l'eccezione riguardante
 *         l'assenza della risposta dell'API.
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
