/**
 * 
 */
package com.project.Health_Bot.model;

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

    private float peso;
    private float lbm;
    private float bmi;
    private Date data;

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
    public float getPeso() {
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
    public float getLbm() {
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
    public float getBmi() {
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

}
