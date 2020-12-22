/**
 * 
 */
package com.project.Health_Bot.dao;

import java.util.HashMap;
import java.util.Optional;
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

    /**
     * Aggiunge un nuovo utente al sistema (attributi nulli)
     * 
     * @param id
     * @param username
     */
    private void registraUtente(String id, String username) {
        
    	
    }
    
    /**
     * 
     */
    @Override
    public void registraSesso(String id, char sesso) {

    	
    }
    
    /**
     * 
     */
    @Override
    public void registraPeso(String id, float peso) {
        

    }
    
    /**
     * 
     */
    @Override
    public void registraAltezza(String id, int altezza) {
       

    }
    
    /**
     * 
     */
    @Override
    public void registraAnno(String id, int anno) {
        

    }
    
    /**
     * 
     */
    @Override
    public Optional<String> getCampoVuoto(String id) {
        
        return null;
    }

}
