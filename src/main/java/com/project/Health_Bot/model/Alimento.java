/**
 * 
 */
package com.project.Health_Bot.model;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 * Classe che modella il generico alimento
 *
 */
public class Alimento {

    protected String nome;
    protected float energia;
    protected float proteine;
    protected float lipidi;
    protected float carbo;
/**
 * Costruttore
 * 
 * @param nome
 */
    public Alimento(String nome) {
        this.nome = nome;
    }
/**
 * Costruttore
 * 
 * @param nome
 * @param energia
 * @param proteine
 * @param lipidi
 * @param carbo
 */
    public Alimento(String nome, float energia, float proteine, float lipidi, float carbo) {
        this.nome = nome;
        this.energia = energia;
        this.proteine = proteine;
        this.lipidi = lipidi;
        this.carbo = carbo;
    }
    
    /**
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * 
     * @return energia
     */
    public double getEnergia() {
        return energia;
    }
    
    /**
     * 
     * @param energia
     */
    public void setEnergia(float energia) {
        this.energia = energia;
    }
    
    /**
     * 
     * @return energia
     */
    public double getProteine() {
        return proteine;
    }
    
    /**
     * 
     * @param proteine
     */
    public void setProteine(float proteine) {
        this.proteine = proteine;
    }
    
    /**
     * 
     * @return lipidi
     */
    public double getLipidi() {
        return lipidi;
    }
    
    /**
     * 
     * @param lipidi
     */
    public void setLipidi(float lipidi) {
        this.lipidi = lipidi;
    }
    
    /**
     * 
     * @return carbo
     */
    public double getCarbo() {
        return carbo;
    }
    
    /**
     * 
     * @param carbo
     */
    public void setCarbo(float carbo) {
        this.carbo = carbo;
    }

    
}
