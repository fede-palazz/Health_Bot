/**
 * 
 */
package com.project.Health_Bot.model;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Sottoclasse di Alimento che modella il generico alimento aggiungendo le informazioni
 *         nutrizionali
 *
 */
public class AlimentoInfo extends Alimento {

    private double proteine, lipidi, carbo;

    /**
     * Costruttore
     * 
     * @param nome
     */
    public AlimentoInfo(String nome) {
        super(nome);
    }

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
    public AlimentoInfo(String nome, int kcal, int qta, double proteine, double lipidi, double carbo) {
        super(nome, kcal, qta);
        this.proteine = proteine;
        this.lipidi = lipidi;
        this.carbo = carbo;
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
    public void setProteine(double proteine) {
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
    public void setLipidi(double lipidi) {
        this.lipidi = lipidi;
    }

    /**
     * 
     * @return carboidrati
     */
    public double getCarbo() {
        return carbo;
    }

    /**
     * 
     * @param carboidrati
     */
    public void setCarbo(double carbo) {
        this.carbo = carbo;
    }

    /**
     * Stampa le informazioni dell'alimento
     */
    @Override
    public String toString() {
        return "L'alimento '" + this.getNome() + "', nella seguente quantità in grammi: " + this.getQta() + ", \n"
                + "fornisce " + this.getKcal() + " [Kcal], ripartite in: \n" + this.getCarbo() + " carboidrati 🍝\n"
                + this.getProteine() + " proteine 🥩\n" + this.getLipidi() + " grassi 🧈\n";
    }

}
