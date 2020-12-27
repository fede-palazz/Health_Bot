
package com.project.Health_Bot.dao;

import java.util.HashMap;
import org.springframework.stereotype.Repository;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
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
        Utente user = utentiReg.get(id);
        if (user instanceof Sedentario) {
            // Utente Sedentario
            ((Sedentario) user).inserisciMisurazione(peso, lbm, bmi);
        }
        else if (user instanceof Sportivo) {
            // Utente Sportivo
            ((Sportivo) user).inserisciMisurazione(peso, lbm, bmi);
        }
        else if (user instanceof Pesista) {
            // Utente Pesista
            ((Pesista) user).inserisciMisurazione(peso, lbm, bmi);
        }
        // TODO Togliere metodo da Utente ed utilizzare qui typeof con casting
    }

}
