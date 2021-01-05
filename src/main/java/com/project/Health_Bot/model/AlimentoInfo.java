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

    /**
     * Attributi nutrizionali aggiuntivi del generico alimento
     */
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
     * Restituisce la quantità di proteine dell'alimento, come double
     * 
     * @return energia
     */
    public double getProteine() {
        return proteine;
    }

    /**
     * Imposta le proteine dell'alimento, come double
     * 
     * @param proteine
     */
    public void setProteine(double proteine) {
        this.proteine = proteine;
    }

    /**
     * Restituisce la quantità di lipidi dell'alimento, come double
     * 
     * @return lipidi
     */
    public double getLipidi() {
        return lipidi;
    }

    /**
     * Imposta i lipidi dell'alimento, come double
     * 
     * @param lipidi
     */
    public void setLipidi(double lipidi) {
        this.lipidi = lipidi;
    }

    /**
     * Restituisce la quantità di carboidrati dell'alimento, come double
     * 
     * @return carboidrati
     */
    public double getCarbo() {
        return carbo;
    }

    /**
     * Imposta i carboidrati dell'alimento, come double
     * 
     * @param carboidrati
     */
    public void setCarbo(double carbo) {
        this.carbo = carbo;
    }

    /**
     * Stampa le informazioni dell'alimento, come stringa
     * 
     * @return la stringa con le informazioni nutrizionali sull'alimento
     */
    @Override
    public String toString() {
        return "L'alimento '" + this.getNome() + "', nella seguente quantità in grammi: " + this.getQta() + ", \n"
                + "fornisce " + this.getKcal() + " [Kcal], ripartite in: \n" + this.getCarbo() + " carboidrati 🍝\n"
                + this.getProteine() + " proteine 🥩\n" + this.getLipidi() + " grassi 🧈\n";
    }

}
