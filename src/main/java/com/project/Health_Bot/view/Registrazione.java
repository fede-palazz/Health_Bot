/**
 * 
 */
package com.project.Health_Bot.view;

import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ReplyKeyboardRemove;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che modella la fase di registrazione dell'utente.
 * 
 */
public class Registrazione {

    /**
     * Restituisce la vista iniziale
     * 
     * @param chatId
     * @param username
     * @return response
     */
    public static SendMessage getVistaWelcome(long chatId, String username) {
        String mess = ("Ciao " + username + " 👋🏻😊 Benvenuto su Health_Bot! 😉\n"
                + "Prima di iniziare e poter accedere alle mie funzionalità, mi servirebbe qualche tuo dato iniziale...");
        SendMessage response = new SendMessage(chatId, mess);
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Restituisce la vista relativa al sesso
     * 
     * @return response
     */
    public static SendMessage getVistaSesso(long chatId) {
        String mess = ("Sei un maschio ♀️ o una femmina ♂️ ?");
        SendMessage response = new SendMessage(chatId, mess);
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "M", "F" }).resizeKeyboard(true);
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Restituisce la vista relativa al peso
     * 
     * @return response
     */
    public static SendMessage getVistaPeso(long chatId) {
        // Testo del messaggio
        String mess = ("Quanto pesi attualmente? ⚖ [Kg]");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Restituisce la vista relativa all'altezza
     * 
     * @return response
     */
    public static SendMessage getVistaAltezza(long chatId) {
        // Testo del messaggio
        String mess = ("Inserisci la tua altezza 📏  [cm]");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Restituisce la vista relativa all'anno di nascita
     * 
     * @return response
     */
    public static SendMessage getVistaAnno(long chatId) {
        // Testo del messaggio
        String mess = ("Inserisci il tuo anno di nascita 👶🏻");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Metodo che restituisce il livello di att. fisica selezionato dall'utente
     * 
     * @return response
     */
    public static SendMessage getVistaAttivita(long chatId) {
        // Testo del messaggio
        String mess = ("Seleziona il tuo livello di attività fisica 💪🏻: ");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo dei pulsanti alla risposta
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Pesante 🏋🏻", "Moderato 🏃🏻‍♂️" },
                new String[] { "Sedentario 🧘🏻‍♂️" }).resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Restituisce la vista relativa alla completa registrazione dell'utente
     * 
     * @param chatId
     * @return response
     */
    public static SendMessage getVistaRegistrato(long chatId) {
        // Testo del messaggio
        String mess = ("Registrazione completata! \n"
                + "Ora potrai accedere al menù principale e divertirti un po' con me 😊😊");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Restituisce una vista di errore sui dati inseriti dall'utente
     * 
     * @return response
     */
    public static SendMessage getVistaErrore(long chatId) {
        // Testo del messaggio
        String mess = ("Valore inserito non corretto ❌ \n" + "Riprovare!");
        // Creo l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

}
