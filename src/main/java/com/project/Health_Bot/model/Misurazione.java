package com.project.Health_Bot.model;

import java.util.Date;

public class Misurazione {

    private float peso;
    private float lbm;
    private float bmi;
    private Date data;

    public Misurazione(float peso, float lbm, float bmi, Date data) {
        this.peso = peso;
        this.lbm = lbm;
        this.bmi = bmi;
        this.data = data;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getLbm() {
        return lbm;
    }

    public void setLbm(float lbm) {
        this.lbm = lbm;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public Date getData() {
        return data;
    }

}
