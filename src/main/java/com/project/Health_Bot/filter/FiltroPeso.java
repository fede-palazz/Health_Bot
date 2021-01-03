package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Misurazione;

public class FiltroPeso extends FiltriMis {

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

    @Override
    public void validate() {
        if (pesoMin != null && pesoMin < 0)
            throw new FilterArgumentException("Il peso minimo non può essere negativo");
        if (pesoMax != null && pesoMax < pesoMin)
            throw new FilterArgumentException("Il peso massimo non può essere minore di quello minimo");
    }

}
