/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Questa classe contiene l'eccezione riguardante il non corretto
 *         inserimento del genere.
 *
 */
public class InvalidGenderException extends IllegalArgumentException {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	String message;

	/**
	 * 
	 */
	public InvalidGenderException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public InvalidGenderException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
