/**
 * 
 */
package com.project.Health_Bot.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Modella l'oggetto errore.
 *
 */
public class Errore {

    private final HttpStatus stato;
    private final Instant istante;
    private final String nomeErr;
    private final String mess;

    /**
     * Costruttore
     * 
     * @param stato
     * @param istante
     * @param nomeErr
     * @param mess
     */
    public Errore(HttpStatus stato, Instant istante, String nomeErr, String mess) {
        this.stato = stato;
        this.istante = istante;
        this.nomeErr = nomeErr;
        this.mess = mess;
    }

    /**
     * Restituisce lo stato, che è un oggetto di tipo HttpStatus
     * 
     * @return stato
     */
    public HttpStatus getHttpStatus() {
        return stato;
    }

    /**
     * Restituisce l'istante, che è un oggetto di tipo Instant
     * 
     * @return istante
     */
    public Instant getInstant() {
        return istante;
    }

    /**
     * Restituisce la stringa contenente il nome errato
     * 
     * @return nomeErr
     */
    public String geterrorName() {
        return nomeErr;
    }

    /**
     * Restituisce il messaggio generato dall'eccezione, sotto forma di stringa
     * 
     * @return mess
     */
    public String getMessage() {
        return mess;
    }
}
