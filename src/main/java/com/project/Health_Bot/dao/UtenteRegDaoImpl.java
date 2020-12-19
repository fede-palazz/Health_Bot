package com.project.Health_Bot.dao;

import java.util.HashMap;
import org.springframework.stereotype.Repository;
import com.project.Health_Bot.model.Utente;

@Repository
public class UtenteRegDaoImpl implements UtenteRegDao {

    /**
     * Insieme utenti registrati al sistema
     */
    private static HashMap<String, Utente> utentiReg;

    @Override
    public boolean isRegistered(String id) {
        // TODO Auto-generated method stub
        return false;
    }

}
