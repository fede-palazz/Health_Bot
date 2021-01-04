/**
 * 
 */
package com.project.Health_Bot.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Classe che contiene i parametri ed i metodi descriventi
 * lo storico delle misurazioni
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *
 */
public class Misurazione {

    private Float peso;
    private Float lbm;
    private Float bmi;
    private Date data;

    /**
     * Costruttore di default
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
     * 
     * @return peso
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * 
     * @param peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * 
     * @return lbm
     */
    public Float getLbm() {
        return lbm;
    }

    /**
     * 
     * @param lbm
     */
    public void setLbm(float lbm) {
        this.lbm = lbm;
    }

    /**
     * 
     * @return bmi
     */
    public Float getBmi() {
        return bmi;
    }

    /**
     * 
     * @param bmi
     */
    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    /**
     * 
     * @return data
     */
    public Date getData() {
        return data;
    }

    /**
     * Restituisce true se la misurazione è vuota
     * 
     * @return
     */
    public boolean isEmpty() {
        if (this.peso == null && this.lbm == null && this.bmi == null)
            return true;
        else
            return false;
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); // Oggetto formattatore di date
        return "in data " + df.format(data).replaceAll("-", "/") + ", hai registrato: \n" + "- peso: " + peso
                + "[Kg] \n" + "- LBM: " + lbm + "[Kg] \n" + "- BMI: " + bmi + "[Kg] \n";
        /* return "Misurazione [peso=" + peso + ", lbm=" + lbm + ", bmi=" + bmi + ", data="
                + df.format(data).replaceAll("-", "/") + "]"; */
    }

}
