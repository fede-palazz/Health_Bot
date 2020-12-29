/**
 * 
 */
package com.project.Health_Bot.model;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Sottoclasse di Alimento che modella il generico alimento, aggiungendo informazioni
 *
 */
public class AlimentoInfo extends Alimento {

    private int proteine, lipidi, carbo;

    /**
     * Costruttore
     * 
     * @param nome
     * @param kcal
     * @param qta
     * @param proteine
     * @param lipidi
     * @param carbo
     */
    public AlimentoInfo(String nome, int kcal, int qta, int proteine, int lipidi, int carbo) {
        super(nome, kcal, qta);
        this.proteine = proteine;
        this.lipidi = lipidi;
        this.carbo = carbo;
    }

    /**
     * 
     * @return energia
     */
    public int getProteine() {
        return proteine;
    }

    /**
     * 
     * @param proteine
     */
    public void setProteine(int proteine) {
        this.proteine = proteine;
    }

    /**
     * 
     * @return lipidi
     */
    public int getLipidi() {
        return lipidi;
    }

    /**
     * 
     * @param lipidi
     */
    public void setLipidi(int lipidi) {
        this.lipidi = lipidi;
    }

    /**
     * 
     * @return carboidrati
     */
    public int getCarbo() {
        return carbo;
    }

    /**
     * 
     * @param carboidrati
     */
    public void setCarbo(int carbo) {
        this.carbo = carbo;
    }

}
