/**
 * 
 */
package com.project.Health_Bot.service;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;
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
import com.project.Health_Bot.util.ParamNutr;
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
    public List<SendMessage> gestisciUpdate(Update update) throws InvalidUpdateException {

        if (update.message() != null && !update.message().text().isEmpty()) { // Messaggio ricevuto valido

            long chatId = update.message().chat().id(); // Id della chat
            String userId = update.message().from().id().toString(); // Id utente

            if (utenteNonRegDao.isRegistering(userId)) {
                // Utente in fase di registrazione
                return gestisciReg(update.message().text(), userId, chatId);
            }
            else if (utenteRegDao.isRegistered(userId)) {
                // Utente già registrato nel sistema
                return gestisciMenu(update.message().text(), userId, chatId);
            }
            else {
                // Nuovo utente
                utenteNonRegDao.nuovoUtente(userId); // Registrazione
                // Determinazione dell'username
                String username;
                if ((username = update.message().from().username()) == null)
                    if ((username = update.message().from().firstName()) == null)
                        username = "utente";
                // Restituisce le vista di benvenuto ed inserimento del sesso
                List<SendMessage> response = new Vector<SendMessage>(); // Messaggi di risposta
                response.add(Registrazione.getVistaWelcome(chatId, username));
                response.add(Registrazione.getVistaSesso(chatId));
                return response;
            }
        }
        else // Messaggio ricevuto non valido
            throw new InvalidUpdateException("Update ricevuto nullo o non valido");
    }

    @Override
    public List<SendMessage> gestisciReg(String mess, String userId, long chatId) {

        List<SendMessage> view = new Vector<SendMessage>();
        // Individuo quale campo deve essere ancora compilato ed restituisco la vista corrispondente
        switch (utenteNonRegDao.getCampoVuoto(userId)) {
        case "sesso":
            // Verifico se il genere ottenuto è valido

            if (mess.toUpperCase().equals("M") || mess.toUpperCase().equals("F")) {
                // Lo registro e restituisco la prossima vista
                utenteNonRegDao.registraSesso(userId, mess.toUpperCase().charAt(0));
                view.add(Registrazione.getVistaPeso(chatId));
                return view;
            }
            else // Sesso inserito non valido
                view.add(Registrazione.getVistaErrore(chatId));
            return view;

        case "peso":
            // Verifico che il peso ottenuto sia valido
            try {
                float peso = Float.parseFloat(mess.replace(',', '.'));
                if (peso > 0 && peso < 300) {
                    // Peso valido
                    utenteNonRegDao.registraPeso(userId, peso);
                    view.add(Registrazione.getVistaAltezza(chatId));
                    return view;
                }
            }
            catch (Exception e) {
                // Peso inserito non valido
                view.add(Registrazione.getVistaErrore(chatId));
                return view;
            }
        case "altezza":
            // Verifico che l'altezza ottenuta sia valida
            try {
                int altezza = Integer.parseInt(mess.replace(',', '.'));
                if (altezza > 30 && altezza < 280) {
                    // Registro il valore e restituisco la prossima vista
                    utenteNonRegDao.registraAltezza(userId, altezza);
                    view.add(Registrazione.getVistaAnno(chatId));
                    return view;
                }
            }
            catch (Exception e) {
                // Altezza inserita non valida
                view.add(Registrazione.getVistaErrore(chatId));
                return view;
            }

        case "annoNascita":
            // Verifico l'anno inserito sia valido
            try {
                int annoNascita = Integer.parseInt(mess);
                int annoCorrente = Calendar.getInstance().get(Calendar.YEAR);
                if ((annoCorrente - annoNascita) >= 0 && (annoCorrente - annoNascita) < 120) {
                    // Registro il valore e restituisco la prossima vista
                    utenteNonRegDao.registraAnno(userId, annoNascita);
                    view.add(Registrazione.getVistaAttivita(chatId));
                    return view;
                }
                else {
                    view.add(Registrazione.getVistaErrore(chatId));
                    return view;
                }
            }
            catch (Exception e) {
                // Anno di nascita inserito non valido
                view.add(Registrazione.getVistaErrore(chatId));
                return view;
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
                // Aggiunge una misurazione iniziale
                utenteRegDao.inserisciMisurazione(userId, user.getPeso().get(),
                        ParamNutr.calcolaLBM(user.getSesso().get(), user.getPeso().get(), user.getAltezza().get()),
                        ParamNutr.calcolaBMI(user.getPeso().get(), user.getAltezza().get()));
                // Restituisce la vista di registrazione completata
                view.add(Registrazione.getVistaRegistrato(chatId));
                // TODO Restituisce la vista del menu principale
                return view;

            case "Moderato 🏃🏻‍♂️":
                // Rimuove l'utente dalla lista di quelli in fase di registrazione
                user = utenteNonRegDao.rimuoviUtente(userId);
                // Aggiunge l'utente alla lista di quelli registrati
                utenteRegDao.inserisciUtente(userId, new Sportivo(user.getSesso().get(), user.getAltezza().get(),
                        user.getPeso().get(), user.getAnnoNascita().get()));
                // Aggiunge una misurazione iniziale
                utenteRegDao.inserisciMisurazione(userId, user.getPeso().get(),
                        ParamNutr.calcolaLBM(user.getSesso().get(), user.getPeso().get(), user.getAltezza().get()),
                        ParamNutr.calcolaBMI(user.getPeso().get(), user.getAltezza().get()));
                // Restituisce la vista di registrazione completata
                view.add(Registrazione.getVistaRegistrato(chatId));
                // TODO Restituisce la vista del menu principale
                return view;

            case "Pesante 🏋🏻":
                // Rimuove l'utente dalla lista di quelli in fase di registrazione
                user = utenteNonRegDao.rimuoviUtente(userId);
                // Aggiunge l'utente alla lista di quelli registrati
                utenteRegDao.inserisciUtente(userId, new Pesista(user.getSesso().get(), user.getAltezza().get(),
                        user.getPeso().get(), user.getAnnoNascita().get()));
                // Aggiunge una misurazione iniziale
                utenteRegDao.inserisciMisurazione(userId, user.getPeso().get(),
                        ParamNutr.calcolaLBM(user.getSesso().get(), user.getPeso().get(), user.getAltezza().get()),
                        ParamNutr.calcolaBMI(user.getPeso().get(), user.getAltezza().get()));
                // Restituisce la vista di registrazione completata
                view.add(Registrazione.getVistaRegistrato(chatId));
                // TODO Restituisce la vista del menu principale
                return view;

            default:
                view.add(Registrazione.getVistaErrore(chatId));
                return view;

            }
        }
        return null;

    }

    @Override
    public List<SendMessage> gestisciMenu(String mess, String userId, long chatId) {

        return null;
    }

}
