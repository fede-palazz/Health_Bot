package com.project.Health_Bot.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GestoreEccezioni {

    @ExceptionHandler(value = InvalidWeightException.class)
    public ResponseEntity<Object> gestisciInvalidWeightException(InvalidWeightException e) {
        //1. Crea l'oggetto errore
        Errore err = new Errore(HttpStatus.BAD_REQUEST, Instant.now(), e.getClass().getCanonicalName(), e.getMessage());
        //2. Restituisce la response entity
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
