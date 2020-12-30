/**
 * 
 */
package com.project.Health_Bot.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.project.Health_Bot.dao.UtenteNonRegDao;
import com.project.Health_Bot.dao.UtenteRegDao;
import com.project.Health_Bot.exception.APIResponseException;
import com.project.Health_Bot.exception.FoodNotFoundException;
import com.project.Health_Bot.exception.InvalidUpdateException;
import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;
import com.project.Health_Bot.util.JSONOnline;
import com.project.Health_Bot.util.ParamNutr;
import com.project.Health_Bot.view.Menu;
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
     * Se è true significa che l'utente ha richiesto le info nutrizionali di un alimento
     */
    private static HashMap<String, Boolean> richiestaInfoNutr = new HashMap<String, Boolean>();

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
            // Determinazione dell'username
            String username;
            if ((username = update.message().from().username()) == null)
                if ((username = update.message().from().firstName()) == null)
                    username = "utente";

            if (utenteNonRegDao.isRegistering(userId)) {
                // Utente in fase di registrazione, è presente nell'hash_map degli utenti che si stanno registrando 
                return gestisciReg(update.message().text(), userId, chatId);
            }
            else if (utenteRegDao.isRegistered(userId)) {
                // Utente già registrato nel sistema, è presente nell'hash_map degli utenti che si sono già registrati 
                return gestisciMenu(update.message().text(), userId, username, chatId);
            }
            else {
                // Nuovo utente
                utenteNonRegDao.nuovoUtente(userId); // Registrazione
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
        // Individuo quale campo deve essere ancora compilato e restituisco la vista corrispondente
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
                view.add(Menu.getVistaMenu(chatId));
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
                view.add(Menu.getVistaMenu(chatId));
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
                view.add(Menu.getVistaMenu(chatId));
                return view;

            default: // Non ha premuto un pulsante
                view.add(Registrazione.getVistaErrore(chatId));
                return view;
            }
        }
        return null;
    }

    @Override
    public List<SendMessage> gestisciMenu(String mess, String userId, String username, long chatId) {
        List<SendMessage> view = new Vector<SendMessage>();
        Utente utente = utenteRegDao.getUtente(userId);

        String tipo = utenteRegDao.getTipo(utente);

        // Ultima misurazione registrata
        Misurazione ultimaMisura = utenteRegDao.getUltimaMisurazione(utente);
        float bmi = 0, lbm = 0;
        if (!ultimaMisura.isEmpty()) {
            bmi = ultimaMisura.getBmi();
            lbm = ultimaMisura.getLbm();
        }
        float bmr = ParamNutr.calcolaBMR(utente.getSesso().get(), lbm, utente.getAltezza().get(),
                utente.getEta().get());
        int fcg = ParamNutr.calcolaFCG(bmr, tipo);
        float iw = ParamNutr.calcolaIW(utente.getSesso().get(), utente.getAltezza().get());
        Float peso = utenteRegDao.getUltimaMisurazione(utente).getPeso();

        switch (mess) {

        case "Aggiorna parametri 🔄": // tasto (1)
            view.add(Menu.getVistaAggiornamenti(chatId));
            return view;

        case "Aggiorna peso ⚖": // Tasto (1.1)
            // Inserisce una misurazione vuota o svuota l'ultima giornaliera
            utenteRegDao.inserisciMisurazione(userId);
            view.add(Menu.getVistaAggPeso(chatId));
            return view;

        case "Aggiorna att. fisica 💪🏻": // Tasto (1.2)
            view.add(Menu.getVistaAttivita(chatId));
            return view;

        case "Consigli ️🙌🏻": // Tasto (2)
            view.add(Menu.getVistaConsigli(chatId, username));
            return view;

        case "Dieta consigliata 😋": // Tasto (2.1)
            view.add(Menu.getVistaDieta(chatId, username, fcg, utenteRegDao.getDieta(utente, fcg)));
            view.add(Menu.getVistaMenu(chatId));
            return view;

        case "Allenamento consigliato 🏋🏻": // Tasto (2.2)
            view.add(Menu.getVistaAllenamento(chatId, utenteRegDao.getTipo(utente), username,
                    utenteRegDao.getAllenamento(utente)));
            return view;

        case "Torna al menù ⬅️":
            view.add(Menu.getVistaMenu(chatId));
            return view;

        case "Info nutrizionali 🍽‍️": // Tasto (3)
            // Aggiorno lo stato di richiestaInfoNutr
            richiestaInfoNutr.put(userId, true);
            view.add(Menu.getVistaAlimento(chatId));
            return view;

        case "Riepilogo salute ⛑": // Tasto (4)
            view.add(Menu.getVistaRiepilogoSalute(chatId, tipo, peso, iw, fcg, bmr, bmi, lbm));
            view.add(Menu.getVistaMenu(chatId));
            return view;

        case "‍️Conosci il tuo corpo 🧘🏻‍♂️️": // Tasto (5)
            view.add(Menu.getVistaConosciCorpo(chatId, username));
            return view;

        case "Diagnostica 🩺": // Tasto (5.1)
            String condizione = ParamNutr.condCorp(bmi);

            view.add(Menu.getVistaDiag(chatId, bmi, condizione, peso, iw));
            view.add(Menu.getVistaMenu(chatId));
            return view;

        case "📊Statistiche📈": // Tasto (5.2)
            view.add(Menu.getVistaStats(chatId));
            view.add(Menu.getVistaMenu(chatId));
            return view;

        case "Info generali ℹ️": // Tasto (6)
            view.add(Menu.getVistaInfo(chatId));
            return view;

        case "BMI": // Tasto (6.1)
            view.add(Menu.getVistaInfoBMI(chatId));
            return view;

        case "IW‍": // Tasto (6.2)
            view.add(Menu.getVistaInfoIW(chatId));
            return view;

        case "BMR️": // Tasto (6.3)
            view.add(Menu.getVistaInfoBMR(chatId));
            return view;

        case "FCG": // Tasto (6.4)
            view.add(Menu.getVistaInfoFCG(chatId));
            return view;

        case "LBM": // Tasto (6.5)
            view.add(Menu.getVistaInfoLBM(chatId));
            return view;

        // Verificare che il tipo di utente non sia lo stesso del pulsante premuto (in tal caso non fare nulla)    
        case "Pesante 🏋🏻":
            if (tipo != "pes") {
                // Elimina l'utente dal DB in memoria
                utenteRegDao.rimuoviUtente(userId);
                // Ricrea l'utente cambiandone il tipo
                utenteRegDao.inserisciUtente(userId, new Pesista(utente.getSesso().get(), utente.getAltezza().get(),
                        utente.getPeso().get(), utente.getAnnoNascita().get()));
                // Reinserisco le misurazioni salvate
                for (Misurazione misura : utenteRegDao.getMisurazioni(utente))
                    utenteRegDao.inserisciMisurazione(userId, misura);
                // Salvo il DB in memoria su file
                utenteRegDao.salvaDB();
                // Restituisce le viste di operazione completata
                view.add(Menu.getVistaAttivitaSucc(chatId));
                view.add(Menu.getVistaMenu(chatId));
                return view;
            }
            else {
                view.add(Menu.getVistaAttivitaSucc(chatId));
                view.add(Menu.getVistaMenu(chatId));
                return view;
            }

        case "Moderato 🏃🏻‍♂️":
            if (tipo != "sport") {
                // Elimina l'utente dal DB in memoria
                utenteRegDao.rimuoviUtente(userId);
                // Ricrea l'utente cambiandone il tipo
                utenteRegDao.inserisciUtente(userId, new Sportivo(utente.getSesso().get(), utente.getAltezza().get(),
                        utente.getPeso().get(), utente.getAnnoNascita().get()));
                // Reinserisco le misurazioni salvate
                for (Misurazione misura : utenteRegDao.getMisurazioni(utente))
                    utenteRegDao.inserisciMisurazione(userId, misura);
                // Salvo il DB in memoria su file
                utenteRegDao.salvaDB();
                // Restituisce le viste di operazione completata
                view.add(Menu.getVistaAttivitaSucc(chatId));
                view.add(Menu.getVistaMenu(chatId));
                return view;
            }
            else {
                view.add(Menu.getVistaAttivitaSucc(chatId));
                view.add(Menu.getVistaMenu(chatId));
                return view;
            }
        case "Sedentario 🧘🏻️":
            if (tipo != "sed") {
                // Elimina l'utente dal DB in memoria
                utenteRegDao.rimuoviUtente(userId);
                // Ricrea l'utente cambiandone il tipo
                utenteRegDao.inserisciUtente(userId, new Sedentario(utente.getSesso().get(), utente.getAltezza().get(),
                        utente.getPeso().get(), utente.getAnnoNascita().get()));
                // Reinserisco le misurazioni salvate
                for (Misurazione misura : utenteRegDao.getMisurazioni(utente))
                    utenteRegDao.inserisciMisurazione(userId, misura);
                // Salvo il DB in memoria su file
                utenteRegDao.salvaDB();
                // Restituisce le viste di operazione completata
                view.add(Menu.getVistaAttivitaSucc(chatId));
                view.add(Menu.getVistaMenu(chatId));
                return view;
            }
            else {
                view.add(Menu.getVistaAttivitaSucc(chatId));
                view.add(Menu.getVistaMenu(chatId));
                return view;
            }

        }
        // Casi particolari
        // 1 - Utente ha inserito il nome di un cibo --> chiama API Food
        if (richiestaInfoNutr.get(userId) != null && richiestaInfoNutr.get(userId)) {
            // mess = nomeCibo
            try {
                richiestaInfoNutr.put(userId, false);
                view.add(Menu.getVistaInfoNutr(chatId, JSONOnline.FOOD_API(mess)));
                view.add(Menu.getVistaMenu(chatId));
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            catch (APIResponseException e) {
                // API non risponde
                view.add(Menu.getVistaInfoNutrFail(chatId));
            }
            catch (FoodNotFoundException e) {
                // Nome alimento inserito non valido
                view.add(Menu.getVistaInfoNutrFail(chatId));
            }
            return view;
        }
        // 2 - Utente vuole aggiornare il peso (nuova misurazione)
        if (utenteRegDao.getUltimaMisurazione(utente).isEmpty()) {
            // mess = nuovo peso
            try {
                float pesoNuovo = Float.parseFloat(mess);
                lbm = ParamNutr.calcolaLBM(utente.getSesso().get(), pesoNuovo, utente.getAltezza().get());
                bmi = JSONOnline.BMI_API(pesoNuovo, utente.getAltezza().get());
                // Aggiorna la misurazione
                utenteRegDao.inserisciMisurazione(userId, pesoNuovo, lbm, bmi);
                // Salvo lo stato del DB in locale
                utenteRegDao.salvaDB();
                // Ritorno la vista del menù
                view.add(Menu.getVistaPesoSucc(chatId));
                view.add(Menu.getVistaMenu(chatId));
            }
            catch (Exception e) {
                view.add(Menu.getVistaErrore(chatId));
            }
            return view;
        }
        // 3 - Se inserisce un testo qualsiasi restituisco il menù
        view.add(Menu.getVistaMenu(chatId));

        return view;

    }

}
