package com.project.Health_Bot.dao;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.project.Health_Bot.model.Utente;

@Repository
public class UtenteNonRegDaoImpl implements UtenteNonRegDao {

    /**
     * Insieme utenti in fase di registrazione al sistema
     */
    private static HashMap<String, Utente> utentiNonReg;

    /**
     * Aggiunge un nuovo utente al sistema (attributi nulli)
     * 
     * @param id
     * @param username
     */
    private void registraUtente(String id, String username) {
        // TODO Auto-generated method stub

    }

    @Override
    public void registraSesso(String id, char sesso) {
        // TODO Auto-generated method stub

    }

    @Override
    public void registraPeso(String id, float peso) {
        // TODO Auto-generated method stub

    }

    @Override
    public void registraAltezza(String id, int altezza) {
        // TODO Auto-generated method stub

    }

    @Override
    public void registraAnno(String id, int anno) {
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<String> getCampoVuoto(String id) {
        // TODO Auto-generated method stub
        return null;
    }

}
