/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Questa classe contiene l'eccezione riguardante il non corretto
 *         inserimento del livello di attività fisica.
 *
 */
public class InvalidLevelException extends IllegalArgumentException {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	String message;

	/**
	 * 
	 */
	public InvalidLevelException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public InvalidLevelException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
