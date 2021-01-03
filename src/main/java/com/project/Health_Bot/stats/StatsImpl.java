/**
 * 
 */
package com.project.Health_Bot.stats;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;
import com.project.Health_Bot.util.ParamNutr;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che implementa l'interfaccia delle statistiche
 *
 */
public class StatsImpl implements Stats {

    @Override
    public float[] percTipo(Vector<Utente> utenti) {

        int[] cont = new int[3];

        for (int i = 0; i < cont.length; i++)
            cont[i] = 0;
        for (Utente utente : utenti) {
            if (utente instanceof Sedentario)
                cont[0]++;
            else if (utente instanceof Sportivo)
                cont[1]++;
            else if (utente instanceof Pesista)
                cont[2]++;
        }

        int utentiTot = cont[0] + cont[1] + cont[2];
        float[] perc = new float[3];
        // percentuale utenti sedentari
        perc[0] = ((float) (cont[0] * 100 / utentiTot));
        // percentuale utenti sportivi
        perc[1] = ((float) (cont[1] * 100 / utentiTot));
        // percentuale utenti pesisti
        perc[2] = ((float) (cont[2] * 100 / utentiTot));
        return perc;
    }

    @Override
    public float percTipo(String tipo, Vector<Utente> utenti) {

        float[] perc = percTipo(utenti);

        switch (tipo) {
        case "sedentari":
            return perc[0];
        case "sportivi":
            return perc[1];
        case "pesisti":
            return perc[2];
        }
        return 0;
    }

    @Override
    public float[] percGenere(Vector<Utente> utenti) {
        int[] cont = new int[2];
        for (int i = 0; i < cont.length; i++)
            cont[i] = 0;
        for (Utente utente : utenti) {
            if (utente.getSesso().get().toString().equals("M")) //E' un maschio
                cont[0]++;
            else
                cont[1]++;
        }

        int utentiTot = cont[0] + cont[1];
        float[] perc = new float[2];
        // percentuale utenti maschi
        perc[0] = ((float) (cont[0] * 100 / utentiTot));
        // percentuale utenti femmine
        perc[1] = ((float) (cont[1] * 100 / utentiTot));

        return perc;

    }

    @Override
    public float percGenere(char gender, Vector<Utente> utenti) {
        float[] perc = percGenere(utenti);

        if (gender == 'M')
            return perc[0];
        else
            return perc[1];
    }

    @Override
    public float[] percRangeEta(Vector<Utente> utenti) {
        // Range di età: x<18, 18=<x<35, 35=<x<50, 50=<x<65, x>=65

        int[] cont = new int[5];

        for (int i = 0; i < cont.length; i++)
            cont[i] = 0;
        for (Utente utente : utenti) {
            if (utente.getEta().get() < 18)
                cont[0]++;
            else if (utente.getEta().get() >= 18 && utente.getEta().get() < 35)
                cont[1]++;
            else if (utente.getEta().get() >= 35 && utente.getEta().get() < 50)
                cont[2]++;
            else if (utente.getEta().get() >= 50 && utente.getEta().get() < 65)
                cont[3]++;
            else
                cont[4]++;
        }

        int utentiTot = cont[0] + cont[1] + cont[2] + cont[3] + cont[4];

        float[] perc = new float[5];
        // percentuale utenti con eta<18
        perc[0] = ((float) (cont[0] * 100 / utentiTot));
        // percentuale utenti con 18=<eta<35 
        perc[1] = ((float) (cont[1] * 100 / utentiTot));
        // percentuale utenti con 35=<eta<50
        perc[2] = ((float) (cont[2] * 100 / utentiTot));
        // percentuale utenti con 50=<eta<65
        perc[3] = ((float) (cont[3] * 100 / utentiTot));
        // percentuale utenti con eta>=65
        perc[4] = ((float) (cont[4] * 100 / utentiTot));
        return perc;
    }

    @Override
    public float percRangeEta(int eta, Vector<Utente> utenti) {
        float[] perc = percRangeEta(utenti);

        if (eta < 18)
            return perc[0];
        else if (eta >= 18 && eta < 35)
            return perc[1];
        else if (eta >= 35 && eta < 50)
            return perc[2];
        else if (eta >= 50 && eta < 65)
            return perc[3];
        else
            return perc[4];
    }

    @Override
    public float[] percCondizioni(Vector<Utente> utenti) {
        int[] cont = new int[7];
        for (int i = 0; i < cont.length; i++)
            cont[i] = 0;

        for (Utente utente : utenti) {
            String cond = null;
            if (utente instanceof Sedentario) {
                Vector<Misurazione> ultimaMis = ((Sedentario) utente).getMisurazioni(1);
                float bmi = ultimaMis.get(0).getBmi();
                cond = ParamNutr.condCorp(bmi);
            }
            else if (utente instanceof Sportivo) {
                Vector<Misurazione> ultimaMis = ((Sportivo) utente).getMisurazioni(1);
                float bmi = ultimaMis.get(0).getBmi();
                cond = ParamNutr.condCorp(bmi);
            }
            else if (utente instanceof Pesista) {
                Vector<Misurazione> ultimaMis = ((Pesista) utente).getMisurazioni(1);
                float bmi = ultimaMis.get(0).getBmi();
                cond = ParamNutr.condCorp(bmi);
            }
            switch (cond) {
            case "GRAVE MAGREZZA":
                cont[0]++;
                break;
            case "SOTTOPESO":
                cont[1]++;
                break;
            case "NORMOPESO":
                cont[2]++;
                break;
            case "SOVRAPPESO":
                cont[3]++;
                break;
            case "OBESITÀ CLASSE I (lieve)":
                cont[4]++;
                break;
            case "OBESITÀ CLASSE II (media)":
                cont[5]++;
                break;
            case "OBESITÀCLASSE III (grave)":
                cont[6]++;
                break;
            }

        }
        int utentiTot = 0;
        for (int i = 0; i < cont.length; i++)
            utentiTot += cont[i];

        float[] perc = new float[7];
        for (int i = 0; i < cont.length; i++) {
            perc[i] = ((float) (cont[i] * 100 / utentiTot));
        }
        return perc;
    }

    @Override
    public float percCondizioni(String condizione, Vector<Utente> utenti) {
        float[] perc = percCondizioni(utenti);
        switch (condizione) {
        case "GRAVE MAGREZZA":
            return perc[0];
        case "SOTTOPESO":
            return perc[1];
        case "NORMOPESO":
            return perc[2];
        case "SOVRAPPESO":
            return perc[3];
        case "OBESITÀ CLASSE I (lieve)":
            return perc[4];
        case "OBESITÀ CLASSE II (media)":
            return perc[5];
        case "OBESITÀCLASSE III (grave)":
            return perc[6];
        }

        return 0;
    }

    @Override
    public float varazioneParam(String param, Vector<Misurazione> mis) {

        switch (param) {
        case "peso":
            return ((mis.firstElement().getPeso() - mis.lastElement().getPeso()) * 100) / mis.firstElement().getPeso();

        case "bmi":
            return ((mis.firstElement().getBmi() - mis.lastElement().getBmi()) * 100) / mis.firstElement().getBmi();

        case "lbm":
            return ((mis.firstElement().getLbm() - mis.lastElement().getLbm()) * 100) / mis.firstElement().getLbm();
        }
        return 0;
    }

    @Override
    public Vector<Misurazione> ultimeMis(int n, Vector<Misurazione> mis) {

        if (n > mis.size())
            return mis;
        else {
            Vector<Misurazione> misura = new Vector<Misurazione>();
            for (int i = mis.size() - n; i < mis.size(); i++) {
                misura.add(mis.get(i));
            }
            return misura;
        }
    }

    @Override
    public Misurazione paramMax(String param, Vector<Misurazione> mis) {
        switch (param) {
        case "peso":
            mis.sort((m1, m2) -> m1.getPeso().compareTo(m2.getPeso()));
            return mis.lastElement();

        case "bmi":
            mis.sort((m1, m2) -> m1.getBmi().compareTo(m2.getBmi()));
            return mis.lastElement();

        case "lbm":
            mis.sort((m1, m2) -> m1.getLbm().compareTo(m2.getLbm()));
            return mis.lastElement();
        }
        return null;
    }

    @Override
    public Misurazione paramMin(String param, Vector<Misurazione> mis) {
        switch (param) {
        case "peso":
            mis.sort((m1, m2) -> m1.getPeso().compareTo(m2.getPeso()));
            return mis.firstElement();

        case "bmi":
            mis.sort((m1, m2) -> m1.getBmi().compareTo(m2.getBmi()));
            return mis.firstElement();

        case "lbm":
            mis.sort((m1, m2) -> m1.getLbm().compareTo(m2.getLbm()));
            return mis.firstElement();
        }
        return null;
    }

    @Override
    public float paramMedia(String param, Vector<Misurazione> mis) {
        float sum = 0;

        switch (param) {
        case "peso":
            for (int i = 0; i < mis.size(); i++) {
                sum += mis.get(i).getPeso();
            }
            return sum / mis.size();

        case "bmi":
            for (int i = 0; i < mis.size(); i++) {
                sum += mis.get(i).getBmi();
            }
            return sum / mis.size();

        case "lbm":
            for (int i = 0; i < mis.size(); i++) {
                sum += mis.get(i).getLbm();
            }
            return sum / mis.size();
        }
        return 0;
    }

}
