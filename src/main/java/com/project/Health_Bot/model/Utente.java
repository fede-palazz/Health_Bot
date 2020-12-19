/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Calendar;
import java.util.Optional;

public class Utente {

    /**
     * Sesso ('M' o 'F')
     */
    protected Character sesso;
    /**
     * Altezza in cm
     */
    protected int altezza;
    /**
     * Peso attuale dell'utente
     */
    protected double peso;
    /**
     * Anno di nascita
     */
    protected int annoNascita;

    /**
     * Costruttore utilizzato al momento della registrazione di un nuovo utente (i campi sono nulli)
     * 
     * @param username
     */
    public Utente() {
    }

    public Utente(char sesso, int altezza, double peso, int annoNascita) {
        this.sesso = sesso;
        this.altezza = altezza;
        this.peso = peso;
        this.annoNascita = annoNascita;
    }

    public Optional<Character> getSesso() {
        return Optional.ofNullable(sesso);
    }

    public void setGenere(char sesso) {
        this.sesso = sesso;
    }

    public Optional<Integer> getAltezza() {
        return Optional.ofNullable(altezza);
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public Optional<Double> getPeso() {
        return Optional.ofNullable(peso);
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Optional<Integer> getEtà() {
        if (Optional.ofNullable(annoNascita).isPresent()) {
            int anno = Calendar.getInstance().get(Calendar.YEAR); // Anno corrente
            return Optional.ofNullable(anno - this.annoNascita); // Calcolo dell'età
        }
        else
            return Optional.empty();
    }

    public void setAnnoNascita(int annoNascita) {
        this.annoNascita = annoNascita;
    }

}
