/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Questa classe contiene l'eccezione riguardante il non corretto
 *         inserimento del peso.
 *
 */
public class InvalidWeightException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	/**
	 * 
	 */
	public InvalidWeightException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public InvalidWeightException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
