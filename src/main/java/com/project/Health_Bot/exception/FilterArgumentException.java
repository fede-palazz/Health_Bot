/**
 * 
 */
package com.project.Health_Bot.exception;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Questa classe contiene il metodo che segnala l'eccezione riguardante
 *         i possibili argomenti errati di un filtro.
 *
 */
public class FilterArgumentException extends IllegalArgumentException {

    /**
     * Messaggio generato dall'eccezione
     */
    private String mess;

    /**
     * Serial ID generale dell'eccezione, generato automaticamente
     */
    private static final long serialVersionUID = 1L;

    /**
     * Costruttore di default
     */
    public FilterArgumentException() {
        super();
    }

    /**
     * Costruttore
     * 
     * @param mess
     */
    public FilterArgumentException(String mess) {
        super(mess);
        this.mess = mess;
    }

    /**
     * Restituisce il messaggio generato dall'eccezione, sotto forma di stringa
     * 
     * @return mess
     */
    public String getMess() {
        return mess;
    }

}
