package com.project.Health_Bot.exception;

public class InvalidWeightException extends IllegalArgumentException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InvalidWeightException() {
        super();
    }

    public InvalidWeightException(String mess) {
        super(mess);
    }

}
