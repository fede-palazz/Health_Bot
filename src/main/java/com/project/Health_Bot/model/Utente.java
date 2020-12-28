/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.Calendar;
import java.util.Optional;

/**
 * Classe che modella l'utente
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class Utente {

    /**
     * Sesso ('M' o 'F')
     */
    protected Character sesso;
    /**
     * Altezza in cm
     */
    protected Integer altezza;
    /**
     * Peso inserito in fase di registrazione
     */
    protected Float peso;
    /**
     * Anno di nascita
     */
    protected Integer annoNascita;

    /**
     * Costruttore di default utilizzato al momento della registrazione di un nuovo utente (i campi sono
     * nulli)
     * 
     * @param username
     */
    public Utente() {
        this.sesso = null;
        this.peso = null;
        this.altezza = null;
        this.annoNascita = null;
    }

    /**
     * Costruttore
     * 
     * @param sesso
     * @param altezza
     * @param peso
     * @param annoNascita
     */
    public Utente(char sesso, int altezza, float peso, int annoNascita) {
        this.sesso = sesso;
        this.altezza = altezza;
        this.peso = peso;
        this.annoNascita = annoNascita;
    }

    /**
     * 
     * @return Sesso dell'utente
     */
    public Optional<Character> getSesso() {
        return Optional.ofNullable(sesso);
    }

    /**
     * 
     * @param sesso
     */
    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    /**
     * 
     * @return Altezza [cm]
     */
    public Optional<Integer> getAltezza() {
        return Optional.ofNullable(altezza);
    }

    /**
     * 
     * @param altezza
     */
    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    /**
     * 
     * @return Peso al momento della registrazione
     */
    public Optional<Float> getPeso() {
        return Optional.ofNullable(peso);
    }

    /**
     * 
     * @param peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * Metodo che calcola l'età a aprtire dall'anno di nascita
     * 
     * @return età
     */
    public Optional<Integer> getEta() {
        if (Optional.ofNullable(annoNascita).isPresent()) {
            int anno = Calendar.getInstance().get(Calendar.YEAR); // Anno corrente
            return Optional.ofNullable(anno - this.annoNascita); // Calcolo dell'età
        }
        else
            return Optional.empty();
    }

    /**
     * Getter di annoNascita
     * 
     * @return Anno di nascita
     */
    public Optional<Integer> getAnnoNascita() {
        return Optional.ofNullable(this.annoNascita);
    }

    /**
     * Setter di annoNascita
     * 
     * @param annoNascita
     */
    public void setAnnoNascita(int annoNascita) {
        this.annoNascita = annoNascita;
    }

    @Override
    public String toString() {
        return "Utente [sesso=" + sesso + ", altezza=" + altezza + ", peso=" + peso + ", annoNascita=" + annoNascita
                + "]";
    }

}
