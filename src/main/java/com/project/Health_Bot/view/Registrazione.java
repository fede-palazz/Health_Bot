/**
 * 
 */
package com.project.Health_Bot.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 * Classe che modella la fase di registrazione dell'utente.
 * 
 */
public class Registrazione {

    /**
     * Restituisce la vista relativa al sesso insieme al messaggio di Welcome
     * 
     * @return mess
     */
    public static SendMessage getVistaSesso(String username) {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Ciao " + username + ". 👋😊\n"
        		+ "Benvenuto su Health_Bot! 😉\n"
                + "Prima di iniziare e poter accedere alle mie funzionalità, mi servirrebbe qualche tuo dato iniziale... \n\n"
                + "Sei un maschio ♀️ o una femmina ♂️ ?");
        // Testo dei pulsanti della tastiera
        Vector<String> pulsanti = new Vector<String>();
        pulsanti.add("M");
        pulsanti.add("F");
        mess.setReplyMarkup(Tastiera.getTastiera(pulsanti));
        return mess;
    }

    /**
     * Restituisce la vista relativa al peso
     * 
     * @return mess
     */
    public static SendMessage getVistaPeso() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Quanto pesi attualmente [Kg]? ⚖");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }

    /**
     * Restituisce la vista relativa all'altezza
     * 
     * @return mess
     */
    public static SendMessage getVistaAltezza() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Inserisci la tua altezza [cm]");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;

    }

    /**
     * Restituisce la vista relativa all'anno di nascita
     * 
     * @return mess
     */
    public static SendMessage getVistaAnno() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Inserisci il tuo anno di nascita");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    /**
     * Metodo che restituisce il livello di att. fisica selezionato dall'utente
     * 
     * @return mess
     */
    public static SendMessage getVistaAttivita() {
    	SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Seleziona il tuo livello di attività fisica 💪: ");
        // Testo dei pulsanti della tastiera
        List<Vector<String>> pulsanti = new Vector<>();
        
        Vector<String> pulsanti1 = new Vector<>();
        pulsanti1.add("Pesante 🏋️‍♀️");
        pulsanti1.add("Moderato 🏃‍♂️");
        pulsanti.add(pulsanti1);
        
        Vector<String> pulsanti2 = new Vector<>();
        pulsanti2.add("Sedentario 🧘🏿‍♀️");
        pulsanti.add(pulsanti2);
        
        mess.setReplyMarkup(Tastiera.getTastiera(pulsanti));
        return mess;
    }

    /**
     * Restituisce una vista di errore sui dati inseriti dall'utente
     * 
     * @return mess
     */
    public static SendMessage getVistaErrore() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Valore inserito non corretto. Riprovare.");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    

}
