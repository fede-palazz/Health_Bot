package com.project.Health_Bot.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GestoreEccezioni {

    /**
     * Gestisce le eccezioni derivanti da un incorretto inserimento dei paramentri dei filtri
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { FilterArgumentException.class })
    public ResponseEntity<Object> gestisciInvalidWeightException(FilterArgumentException ex) {
        Errore err = new Errore(HttpStatus.BAD_REQUEST, Instant.now(), ex.getClass().getCanonicalName(),
                ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestisce un'eccezione generica
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> gestisciInvalidWeightException(Exception ex) {
        Errore err = new Errore(HttpStatus.BAD_REQUEST, Instant.now(), ex.getClass().getCanonicalName(),
                ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Gestisce le eccezioni derivanti da un incorretto inserimento dei paramentri
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { InvalidParamException.class })
    public ResponseEntity<Object> gestisciInvalidWeightException(InvalidParamException ex) {
        Errore err = new Errore(HttpStatus.BAD_REQUEST, Instant.now(), ex.getClass().getCanonicalName(),
                ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
