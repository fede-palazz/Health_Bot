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

    private String nome;
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
    public int getKcal() {
        return kcal;
    }

    /**
     * 
     * @param energia
     */
    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    /**
     * 
     * @return Quantità in grammi
     */
    public int getQta() {
        return qta;
    }

    /**
     * Imposta la quantità [g]
     * 
     * @param qta
     */
    public void setQta(int qta) {
        this.qta = qta;
    }

}
