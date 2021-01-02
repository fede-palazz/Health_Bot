package com.project.Health_Bot.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;

public class Errore {

    private final HttpStatus stato;
    private final Instant istante;
    private final String nomeErr;
    private final String mess;

    public Errore(HttpStatus stato, Instant instante, String nomeErr, String mess) {

        this.stato = stato;
        this.istante = instante;
        this.nomeErr = nomeErr;
        this.mess = mess;
    }

    public HttpStatus getHttpStatus() {
        return stato;
    }

    public Instant getInstant() {
        return istante;
    }

    public String geterrorName() {
        return nomeErr;
    }

    public String getMessage() {
        return mess;
    }
}
