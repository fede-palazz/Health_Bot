package com.project.Health_Bot.dao;

import java.util.Vector;
import org.springframework.stereotype.Repository;
import com.project.Health_Bot.model.Utente;

@Repository
public class UtenteDaoImpl implements UtenteDao {

    private static Vector<Utente> utentiReg; // Lista utenti registrati
    private static Vector<Utente> utentiNonReg; // Lista utenti non registrati

    /**
     * Controlla se l'utente è già registrato nel sistema o meno
     * 
     * @param username String
     * @return boolean
     */
    @Override
    public boolean isRegistered(String username) {
        return false;
    }

}
