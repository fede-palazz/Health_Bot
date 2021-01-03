package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.model.Misurazione;

public class FiltroLbm extends FiltriMis {

    private Float lbmMin, lbmMax;

    public FiltroLbm(Float lbmMin, Float lbmMax) {
        super();
        this.lbmMin = lbmMin;
        this.lbmMax = lbmMax;
    }

    @Override
    public void filtra(Vector<Misurazione> misure) {
        if (lbmMin != null) {
            for (Misurazione mis : misure)
                if (mis.getLbm() < lbmMin)
                    misure.remove(mis);
        }
        if (lbmMax != null) {
            for (Misurazione mis : misure)
                if (mis.getLbm() > lbmMax)
                    misure.remove(mis);
        }
    }

    @Override
    public void validate() {
        if (lbmMin != null && lbmMin < 0)
            throw new FilterArgumentException("L'lbm minimo non può essere negativo");
        if (lbmMax != null && lbmMax < lbmMin)
            throw new FilterArgumentException("L'lbm massimo non può essere minore di quello minimo");
    }

}
