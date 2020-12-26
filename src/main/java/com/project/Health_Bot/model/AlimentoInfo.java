package com.project.Health_Bot.model;

public class AlimentoInfo extends Alimento {

    private float proteine, lipidi, carbo;

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
    public AlimentoInfo(String nome, float kcal, int qta, float proteine, float lipidi, float carbo) {
        super(nome, kcal, qta);
        this.proteine = proteine;
        this.lipidi = lipidi;
        this.carbo = carbo;
    }

    /**
     * 
     * @return energia
     */
    public float getProteine() {
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
    public float getLipidi() {
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
     * @return carboidrati
     */
    public float getCarbo() {
        return carbo;
    }

    /**
     * 
     * @param carboidrati
     */
    public void setCarbo(float carbo) {
        this.carbo = carbo;
    }

}
