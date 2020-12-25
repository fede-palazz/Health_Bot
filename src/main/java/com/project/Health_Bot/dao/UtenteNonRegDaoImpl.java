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
public class UtenteNonRegDaoImpl implements UtenteNonRegDao {

    /**
     * Insieme degli utenti in fase di registrazione al sistema
     */
    private static HashMap<String, Utente> utentiNonReg;

    public UtenteNonRegDaoImpl() {
        utentiNonReg = new HashMap<String, Utente>();
    }

    @Override
    public void registraSesso(String id, char sesso) {

    }

    @Override
    public void registraPeso(String id, float peso) {

    }

    @Override
    public void registraAltezza(String id, int altezza) {

    }

    @Override
    public void registraAnno(String id, int anno) {

    }

    @Override
    public Boolean isRegistering(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCampoVuoto(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void nuovoUtente(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Utente getUtente(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void rimuoviUtente(String id) {
        // TODO Auto-generated method stub

    }

}
