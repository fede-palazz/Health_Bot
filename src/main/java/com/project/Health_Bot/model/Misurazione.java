/**
 * 
 */
package com.project.Health_Bot.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che contiene i parametri ed i metodi descriventi
 *         lo storico delle misurazioni
 *
 */
public class Misurazione {

    /**
     * Attributo che descrive una misurazione
     */
    private Float peso;

    /**
     * Attributo che descrive una misurazione
     */
    private Float lbm;

    /**
     * Attributo che descrive una misurazione
     */
    private Float bmi;

    /**
     * Attributo che descrive una misurazione
     */
    private Date data;

    /**
     * Costruttore
     * 
     * @param data
     */
    public Misurazione(Date data) {
        this.peso = null;
        this.lbm = null;
        this.bmi = null;
        this.data = data;
    }

    /**
     * Costruttore
     * 
     * @param peso
     * @param lbm
     * @param bmi
     * @param data
     */
    public Misurazione(float peso, float lbm, float bmi, Date data) {
        this.peso = peso;
        this.lbm = lbm;
        this.bmi = bmi;
        this.data = data;
    }

    /**
     * Restituisce il peso dell'utente come float
     * 
     * @return peso
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * Imposta il peso dell'utente come float
     * 
     * @param peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * Restituisce l'lbm dell'utente come float
     * 
     * @return lbm
     */
    public Float getLbm() {
        return lbm;
    }

    /**
     * Imposta l'lbm dell'utente come Stringa
     * 
     * @param lbm
     */
    public void setLbm(float lbm) {
        this.lbm = lbm;
    }

    /**
     * Restituisce il bmi dell'utente come float
     * 
     * @return bmi
     */
    public Float getBmi() {
        return bmi;
    }

    /**
     * Imposta il bmi dell'utente come float
     * 
     * @param bmi
     */
    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    /**
     * Restituisce la data dell'utente come oggeto Date
     * 
     * @return data
     */
    public Date getData() {
        return data;
    }

    /**
     * Restituisce true se la misurazione è vuota, false altrimenti
     * 
     * @return true o false
     */
    public boolean isEmpty() {
        if (this.peso == null && this.lbm == null && this.bmi == null)
            return true;
        else
            return false;
    }

    /**
     * 
     * Metodo toString.
     * Restituisce la stringa formattata, che contiene le informazioni di una certa misurazione.
     * 
     * @return stringa formattata
     * 
     */
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); // Oggetto formattatore di date
        return "In data " + df.format(data).replaceAll("-", "/") + ", hai registrato: \n" + "- peso: " + peso
                + "[Kg];\n" + "- LBM: " + lbm + "[Kg];\n" + "- BMI: " + bmi + "[Kg].\n";
        /* return "Misurazione [peso=" + peso + ", lbm=" + lbm + ", bmi=" + bmi + ", data="
                + df.format(data).replaceAll("-", "/") + "]"; */
    }

}
