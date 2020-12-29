
package com.project.Health_Bot.dao;

import java.util.HashMap;
import java.util.Vector;
import org.springframework.stereotype.Repository;
import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;
import com.project.Health_Bot.util.JSONOffline;

/**
 * Interfaccia di accesso agli utenti registrati al sistema
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
@Repository
public class UtenteRegDaoImpl implements UtenteRegDao {

    /**
     * Insieme utenti registrati al sistema
     */
    private static HashMap<String, Utente> utentiReg = new HashMap<String, Utente>();

    @Override
    public boolean isRegistered(String id) {
        if (utentiReg.containsKey(id)) // Utente registrato caricato nel DB in memoria
            return true;
        else {
            // Bisogna verificare se l'utente è salvato nel DB locale e, in caso, caricarlo in memoria
            if (JSONOffline.isRegistered(id)) {
                inserisciUtente(id, JSONOffline.getUtente(id));
                return true;
            }
            return false;
        }
    }

    @Override
    public Utente inserisciUtente(String id, Utente user) {
        utentiReg.put(id, user);
        return utentiReg.get(id);
    }

    public void rimuoviUtente(String id) {
        utentiReg.remove(id);
    }

    @Override
    public void aggiornaPeso(String id, float peso) {
        utentiReg.get(id).setPeso(peso);
    }

    @Override
    public void aggiornaAltezza(String id, int altezza) {
        utentiReg.get(id).setAltezza(altezza);
    }

    @Override
    public void inserisciMisurazione(String id, float peso, float lbm, float bmi) {
        Utente user = utentiReg.get(id);
        switch (getTipo(user)) {
        case "sed":
            ((Sedentario) user).inserisciMisurazione(peso, lbm, bmi);
            break;
        case "sport":
            ((Sportivo) user).inserisciMisurazione(peso, lbm, bmi);
            break;
        case "pes":
            ((Pesista) user).inserisciMisurazione(peso, lbm, bmi);
            break;
        }
    }

    public void inserisciMisurazione(String id) {
        Utente user = utentiReg.get(id);
        switch (getTipo(user)) {
        case "sed":
            ((Sedentario) user).inserisciMisurazione();
            break;
        case "sport":
            ((Sportivo) user).inserisciMisurazione();
            break;
        case "pes":
            ((Pesista) user).inserisciMisurazione();
            break;
        }
    }

    @Override
    public Utente getUtente(String id) {
        return utentiReg.get(id);
    }

    @Override
    public Misurazione getUltimaMisurazione(Utente user) {
        Vector<Misurazione> mis = null;
        switch (this.getTipo(user)) {
        case "sed":
            mis = ((Sedentario) user).getMisurazioni();
            break;
        case "sport":
            mis = ((Sportivo) user).getMisurazioni();
            break;
        case "pes":
            mis = ((Pesista) user).getMisurazioni();
            break;
        }
        if (mis.size() > 0)
            return mis.get(mis.size() - 1);
        else
            return null;
    }

    public String getTipo(Utente user) {
        if (user instanceof Sedentario)
            return "sed";
        else if (user instanceof Sportivo)
            return "sport";
        else if (user instanceof Pesista)
            return "pes";
        else
            return null;
    }

    @Override
    public boolean isLastMisEmpty(Utente user) {
        if (this.getUltimaMisurazione(user).isEmpty())
            // Misurazione vuota
            return true;
        else
            return false;
    }

}
