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
     * Restituisce la vista relativa al sesso insieme al messaggio di Welcome
     * 
     * @return response
     */
    public static SendMessage getVistaSesso(long chatId, String username) {
        // 1) Inserire testo del messaggio
        String mess = ("Ciao " + username + " 👋🏻😊 Benvenuto su Health_Bot! 😉\n"
                + "Prima di iniziare e poter accedere alle mie funzionalità, mi servirebbe qualche tuo dato iniziale... \n\n"
                + "Sei un maschio ♀️ o una femmina ♂️ ?");
        // 2) Creare l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // 3) Aggiungere / togliere la tastiera
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "M", "F" }).oneTimeKeyboard(true)
                .resizeKeyboard(true);
        response.replyMarkup(tastiera);
        /*
         * Esempio:
         * Per aggiungere la tastiera:
               Keyboard tastiera = new ReplyKeyboardMarkup(
                    new String[]{"pulsante_1 riga_1", "pulsante_2 riga_2"},
                    new String[]{"pulsante_1 riga_2", "pulsante_2 riga_2"})
                    .oneTimeKeyboard(true)   // Riduce "ad icona" la tastiera una volta premuto un tasto
                    .resizeKeyboard(true);    // Visualizzazione compatta della tastiera (più carina)
                
           Per rimuovere la tastiera:
               Keyboard tastiera = new ReplyKeyboardRemove();
         */

        // 4) Restituire la risposta
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
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Pesante 🏋️🏻️️‍️", "Moderato 🏃🏻‍♂️" },
                new String[] { "Sedentario 🧘🏻‍♂️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
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
        return response;
    }

}
