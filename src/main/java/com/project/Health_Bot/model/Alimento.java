/**
 * 
 */
package com.project.Health_Bot.model;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che modella il generico alimento
 *
 */
public class Alimento {

    /**
     * Nome dell'alimento
     */
    private String nome;

    /**
     * Kcal dell'alimento
     */
    private int kcal;

    /**
     * Quantità in grammi
     */
    private int qta;

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
     * @param kcal
     * @param qta
     */
    public Alimento(String nome, int kcal, int qta) {
        this.nome = nome;
        this.kcal = kcal;
        this.qta = qta;
    }

    /**
     * Restituisce sotto forma di Stringa il nome dell'alimento
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome dell'alimento come Stringa
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce la quantità di kcal dell'alimento, come intero
     * 
     * @return energia
     */
    public int getKcal() {
        return kcal;
    }

    /**
     * Imposta la quantità di kcal dell'alimento, come intero
     * 
     * @param energia
     */
    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    /**
     * Restituisce la quantità in grammi dell'alimento, come intero
     * 
     * @return Quantità in grammi
     */
    public int getQta() {
        return qta;
    }

    /**
     * Imposta la quantità in grammi dell'alimento, come intero
     * 
     * @param qta
     */
    public void setQta(int qta) {
        this.qta = qta;
    }

}
