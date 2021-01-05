/**
 * 
 */
package com.project.Health_Bot.exception;

public class FilterArgumentException extends IllegalArgumentException {

    /**
     * Messaggio generato dall'eccezione
     */
    private String mess;

    /**
     * Serial ID generale dell'eccezione
     */
    private static final long serialVersionUID = 1L;

    public FilterArgumentException() {
        super();
    }

    public FilterArgumentException(String mess) {
        super(mess);
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }

}
