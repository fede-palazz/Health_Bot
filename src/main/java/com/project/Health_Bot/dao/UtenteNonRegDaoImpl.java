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
    private static HashMap<String, Utente> utentiNonReg = new HashMap<String, Utente>();

    @Override
    public void registraSesso(String id, char sesso) {
        utentiNonReg.get(id).setSesso(sesso);
    }

    @Override
    public void registraPeso(String id, float peso) {
        utentiNonReg.get(id).setPeso(peso);
    }

    @Override
    public void registraAltezza(String id, int altezza) {
        utentiNonReg.get(id).setAltezza(altezza);
    }

    @Override
    public void registraAnno(String id, int anno) {
        utentiNonReg.get(id).setAnnoNascita(anno);
    }

    @Override
    public Boolean isRegistering(String id) {
        return utentiNonReg.containsKey(id);
    }

    @Override
    public String getCampoVuoto(String id) {
        Utente user = utentiNonReg.get(id);
        if (user != null) {
            if (user.getSesso().isEmpty())
                return "sesso";
            else if (user.getPeso().isEmpty())
                return "peso";
            else if (user.getAltezza().isEmpty())
                return "altezza";
            else if (user.getAnnoNascita().isEmpty())
                return "annoNascita";
            else // Inserimento livello attività
                return "tipo";
        }
        else
            return null;
    }

    @Override
    public void nuovoUtente(String id) {
        utentiNonReg.put(id, new Utente());
    }

    @Override
    public Utente getUtente(String id) {
        return utentiNonReg.get(id);
    }

    @Override
    public Utente rimuoviUtente(String id) {
        return utentiNonReg.remove("id");
    }

}
