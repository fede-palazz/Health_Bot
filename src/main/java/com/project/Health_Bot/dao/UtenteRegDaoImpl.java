
package com.project.Health_Bot.dao;

import java.util.HashMap;
import org.springframework.stereotype.Repository;
import com.project.Health_Bot.model.Utente;

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
        return utentiReg.containsKey(id);
    }

    @Override
    public Utente inserisciUtente(String id, Utente user) {
        utentiReg.put(id, user);
        return utentiReg.get(id);
    }

    @Override
    public void inserisciMisurazione(String id, float peso, float lbm, float bmi) {

    }

}
