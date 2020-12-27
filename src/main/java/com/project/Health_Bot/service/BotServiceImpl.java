/**
 * 
 */
package com.project.Health_Bot.service;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.project.Health_Bot.dao.UtenteNonRegDao;
import com.project.Health_Bot.dao.UtenteRegDao;
import com.project.Health_Bot.exception.InvalidUpdateException;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;
import com.project.Health_Bot.view.Registrazione;

/**
 * Classe che implementa l'interfaccia BotService
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

    @Override
    public SendMessage gestisciUpdate(Update update) throws InvalidUpdateException {

        if (update.message() != null && !update.message().text().isEmpty()) { // Messaggio ricevuto valido

            SendMessage response; // Risposta
            long chatId = update.message().chat().id(); // Id della chat
            String userId = update.message().from().id().toString(); // Id utente

            if (utenteNonRegDao.isRegistering(userId)) {
                // Utente in fase di registrazione
                response = gestisciReg(update.message().text(), userId, chatId);
            }
            else if (utenteRegDao.isRegistered(userId)) {
                // Utente già registrato nel sistema
                response = gestisciMenu(update.message().text(), userId, chatId);
            }
            else {
                // Nuovo utente
                utenteNonRegDao.nuovoUtente(userId); // Registrazione
                // Determinazione dell'username
                String username;
                if ((username = update.message().from().username()) == null)
                    if ((username = update.message().from().firstName()) == null)
                        username = "utente";
                response = Registrazione.getVistaSesso(chatId, username); // Vista iniziale
            }

            // Restituisce la risposta con il relativo chatId
            return response;
        }
        else // Messaggio ricevuto non valido
            throw new InvalidUpdateException("Update ricevuto nullo o non valido");
    }

    @Override
    public SendMessage gestisciReg(String mess, String userId, long chatId) {

        // Individuo quale campo deve essere ancora compilato ed restituisco la vista corrispondente
        switch (utenteNonRegDao.getCampoVuoto(userId)) {
        case "sesso":
            // Verifico se il genere ottenuto è valido

            if (mess.toUpperCase().equals("M") || mess.toUpperCase().equals("F")) {
                // Lo registro e restituisco la prossima vista
                utenteNonRegDao.registraSesso(userId, mess.toUpperCase().charAt(0));
                return Registrazione.getVistaPeso(chatId);
            }
            else // Sesso inserito non valido
                return Registrazione.getVistaErrore(chatId);

        case "peso":
            // Verifico che il peso ottenuto sia valido
            try {
                float peso = Float.parseFloat(mess.replace(',', '.'));
                if (peso > 0 && peso < 300) {
                    // Peso valido
                    utenteNonRegDao.registraPeso(userId, peso);
                    return Registrazione.getVistaAltezza(chatId);
                }
            }
            catch (Exception e) {
                // Peso inserito non valido
                return Registrazione.getVistaErrore(chatId);
            }
        case "altezza":
            // Verifico che l'altezza ottenuta sia valida
            try {
                int altezza = Integer.parseInt(mess.replace(',', '.'));
                if (altezza > 30 && altezza < 280) {
                    // Registro il valore e restituisco la prossima vista
                    utenteNonRegDao.registraAltezza(userId, altezza);
                    return Registrazione.getVistaAnno(chatId);
                }
            }
            catch (Exception e) {
                // Altezza inserita non valida
                return Registrazione.getVistaErrore(chatId);
            }

        case "annoNascita":
            // Verifico l'anno inserito sia valido
            try {
                int annoNascita = Integer.parseInt(mess);
                int annoCorrente = Calendar.getInstance().get(Calendar.YEAR);
                if ((annoCorrente - annoNascita) >= 0 && (annoCorrente - annoNascita) < 120) {
                    // Registro il valore e restituisco la prossima vista
                    utenteNonRegDao.registraAnno(userId, annoNascita);
                    return Registrazione.getVistaAttivita(chatId);
                }
                else
                    return Registrazione.getVistaErrore(chatId);
            }
            catch (Exception e) {
                // Anno di nascita inserito non valido
                return Registrazione.getVistaErrore(chatId);
            }

        case "tipo": // Inserimento livello attività fisica
            Utente user;
            switch (mess) {

            case "Sedentario 🧘🏻‍♂️":
                // Rimuove l'utente dalla lista di quelli in fase di registrazione
                user = utenteNonRegDao.rimuoviUtente(userId);
                // Aggiunge l'utente alla lista di quelli registrati
                utenteRegDao.inserisciUtente(userId, new Sedentario(user.getSesso().get(), user.getAltezza().get(),
                        user.getPeso().get(), user.getAnnoNascita().get()));
                // TODO Aggiunge una misurazione iniziale
                // TODO Restituisce la vista del menu principale
                return new SendMessage(chatId, "Ti sei registrato!");
            //break;

            case "Moderato 🏃🏻‍♂️":
                // Rimuove l'utente dalla lista di quelli in fase di registrazione
                user = utenteNonRegDao.rimuoviUtente(userId);
                // Aggiunge l'utente alla lista di quelli registrati
                utenteRegDao.inserisciUtente(userId, new Sportivo(user.getSesso().get(), user.getAltezza().get(),
                        user.getPeso().get(), user.getAnnoNascita().get()));
                // TODO Aggiunge una misurazione iniziale
                // TODO Restituisce la vista del menu principale
                return new SendMessage(chatId, "Ti sei registrato!");
            //break;
            case "Pesante 🏋️🏻️️":
                // Rimuove l'utente dalla lista di quelli in fase di registrazione
                user = utenteNonRegDao.rimuoviUtente(userId);
                // Aggiunge l'utente alla lista di quelli registrati
                utenteRegDao.inserisciUtente(userId, new Pesista(user.getSesso().get(), user.getAltezza().get(),
                        user.getPeso().get(), user.getAnnoNascita().get()));
                // TODO Aggiunge una misurazione iniziale
                // TODO Restituisce la vista del menu principale
                return new SendMessage(chatId, "Ti sei registrato!");
            //break;
            }
        }
        return null;

    }

    @Override
    public SendMessage gestisciMenu(String mess, String userId, long chatId) {

        return null;
    }

}
