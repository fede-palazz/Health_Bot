/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Questa classe contiene l'eccezione riguardante il non corretto
 *         inserimento dell'età.
 *
 */
public class InvalidAgeException extends IllegalArgumentException {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	String message;

	/**
	 * 
	 */
	public InvalidAgeException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public InvalidAgeException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
