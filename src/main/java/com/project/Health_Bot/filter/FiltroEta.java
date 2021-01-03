/**
 * 
 */
package com.project.Health_Bot.filter;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;

public class FiltroEta extends FiltriUser {

    private Integer etaMin, etaMax;

    public FiltroEta(Integer etaMin, Integer etaMax) {
        super();
        this.etaMin = etaMin;
        this.etaMax = etaMax;
    }

    @Override
    public void filtra(<Vector> utente) {
        // TODO Auto-generated method stub
        
    }

}
