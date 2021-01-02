package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;

public abstract class Filtri {

    /**
     * 
     * @param misure
     */
    public abstract void filtra(Vector<Misurazione> misure);

}
