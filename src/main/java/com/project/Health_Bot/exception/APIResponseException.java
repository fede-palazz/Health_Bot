package com.project.Health_Bot.exception;

public class APIResponseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public APIResponseException() {
		super();
	}
	
	public APIResponseException(String message) {
		super(message);
	}
}
