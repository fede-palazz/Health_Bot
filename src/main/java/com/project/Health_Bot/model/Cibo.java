/**
 * 
 */
package com.project.Health_Bot.model;

public class Cibo {

    protected String nome;
    protected double energia;
    protected double proteine;
    protected double lipidi;
    protected double carbo;

    public Cibo(String nome) {
        this.nome = nome;
    }

    public Cibo(String nome, double energia, double proteine, double lipidi, double carbo) {
        this.nome = nome;
        this.energia = energia;
        this.proteine = proteine;
        this.lipidi = lipidi;
        this.carbo = carbo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public double getProteine() {
        return proteine;
    }

    public void setProteine(double proteine) {
        this.proteine = proteine;
    }

    public double getLipidi() {
        return lipidi;
    }

    public void setLipidi(double lipidi) {
        this.lipidi = lipidi;
    }

    public double getCarbo() {
        return carbo;
    }

    public void setCarbo(double carbo) {
        this.carbo = carbo;
    }

}
