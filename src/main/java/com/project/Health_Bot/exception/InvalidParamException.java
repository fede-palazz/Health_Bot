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
	* 
	*/
	private static final long serialVersionUID = 1L;
	String message;

	/**
	 * 
	 */
	public InvalidParamException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public InvalidParamException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
