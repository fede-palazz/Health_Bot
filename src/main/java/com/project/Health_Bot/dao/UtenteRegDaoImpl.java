/**
 * 
 */
package com.project.Health_Bot.dao;

import java.util.HashMap;
import org.springframework.stereotype.Repository;
import com.project.Health_Bot.model.Utente;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
@Repository
public class UtenteRegDaoImpl implements UtenteRegDao {

    /**
     * Insieme utenti registrati al sistema
     */
    private static HashMap<String, Utente> utentiReg;

    public UtenteRegDaoImpl() {
        utentiReg = new HashMap<String, Utente>();
    }

    @Override
    public boolean isRegistered(String id) {

        return false;
    }

    @Override
    public Utente inserisciUtente(String id, Utente user) {
        utentiReg.put(id, user);
        return utentiReg.get(id);
    }

}
