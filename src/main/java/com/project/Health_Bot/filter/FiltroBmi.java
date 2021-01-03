package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Misurazione;

public class FiltroBmi extends FiltriMis {

    private Float bmiMin, bmiMax;

    public FiltroBmi(Float bmiMin, Float bmiMax) {
        super();
        this.bmiMin = bmiMin;
        this.bmiMax = bmiMax;
    }

    @Override
    public void filtra(Vector<Misurazione> misure) {
        if (bmiMin != null) {
            for (Misurazione mis : misure)
                if (mis.getBmi() < bmiMin)
                    misure.remove(mis);
        }
        if (bmiMax != null) {
            for (Misurazione mis : misure)
                if (mis.getBmi() > bmiMax)
                    misure.remove(mis);
        }
    }

    @Override
    public void validate() {
        if (bmiMin != null && bmiMin < 0)
            throw new FilterArgumentException("Il bmi minimo non può essere negativo");
        if (bmiMax != null && bmiMax < bmiMin)
            throw new FilterArgumentException("Il bmi massimo non può essere minore di quello minimo");
    }

}
