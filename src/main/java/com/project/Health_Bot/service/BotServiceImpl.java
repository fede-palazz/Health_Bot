/**
 * 
 */
package com.project.Health_Bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.project.Health_Bot.dao.UtenteNonRegDao;
import com.project.Health_Bot.dao.UtenteRegDao;
import com.project.Health_Bot.view.Registrazione;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
@Service
public class BotServiceImpl implements BotService {

    /**
     * Interfaccia di accesso ai dati degli utenti non registrati
     */
    @Autowired
    private UtenteRegDao utenteRegDao;

    /**
     * Interfaccia di accesso ai dati degli utenti registrati
     */
    @Autowired
    private UtenteNonRegDao utenteNonRegDao;

    /**
     * Ricostruisce lo stato dell'applicazione
     * 
     * @param update Updates
     */
    @Override
    public SendMessage gestisciUpdate(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) { // Messaggio valido

            SendMessage response = new SendMessage();
            String chatId = update.getMessage().getChatId().toString(); // Id della chat
            String userId = update.getMessage().getFrom().getId().toString(); // Id utente

            if (utenteNonRegDao.isRegistering(userId)) {
                // Utente in fase di registrazione
                response = gestisciReg(update.getMessage(), userId);
            }
            else if (utenteRegDao.isRegistered(userId)) {
                // Utente già registrato nel sistema
                response = gestisciMenu(update.getMessage(), userId);
            }
            else {
                // Nuovo utente
                utenteNonRegDao.nuovoUtente(userId); // Registrazione

            }

            // Restituisce la risposta con il relativo chatId
            response.setChatId(chatId);
            return response;
        }
        else
            return null; // TODO 
    }

    /**
     * Gestisce la fase di registrazione di un utente
     * 
     * @param mess
     * @param userId
     */
    @Override
    public SendMessage gestisciReg(Message mess, String userId) {

        // Individuo quale campo deve essere ancora compilato ed restituisco la vista corrispondente
        switch (utenteNonRegDao.getCampoVuoto(userId)) {
        case "sesso":
            return Registrazione.getVistaSesso();
            
        case "peso":
            // Verifico se il genere ottenuto è valido
            if (mess.getText().toUpperCase() == "M" || mess.getText().toUpperCase() == "F") {
                // Lo registro e restituisco la prossima vista
                utenteNonRegDao.registraSesso(userId, mess.getText().toUpperCase().charAt(0));
                return Registrazione.getVistaPeso();
            }
            else // Input non valido
                return Registrazione.getVistaErrore();
            
        case "altezza":
            // Verifico che l'altezza ottenuta sia valida
            try {
                int altezza = Integer.parseInt(mess.getText());
                if (altezza > 30 && altezza < 280) 
                    // Registro il valore e restituisco la prossima vista
                    utenteNonRegDao.registraAltezza(userId, altezza); 
                }

            
            return Registrazione.getVistaAltezza();
            
        case "annoNascita":
            return Registrazione.getVistaAnno();
            
        default: // Tutti i campi sono compilati
            return null;
        }
    }

    @Override
    public SendMessage gestisciMenu(Message mess, String userId) {
        return null;
    }

}
