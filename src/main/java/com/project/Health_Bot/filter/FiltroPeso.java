package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;

public class FiltroPeso extends Filtri {

    private Float pesoMin, pesoMax;

    public FiltroPeso(Float pesoMin, Float pesoMax) {
        super();
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
    }

    @Override
    public void filtra(Vector<Misurazione> misure) {
        // TODO Auto-generated method stub

    }
}
