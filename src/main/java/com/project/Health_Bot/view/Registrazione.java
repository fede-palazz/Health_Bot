/**
 * 
 */
package com.project.Health_Bot.view;

import java.util.Vector;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che modella la fase di registrazione del'utente.
 * 
 */
public class Registrazione {

    /**
     * Restituisce la vista relativa al sesso insieme al messaggio di Welcome
     * 
     * @return
     */
    public static SendMessage getVistaSesso() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Benvenuto su Health_Bot! 😉\n"
                + "Prima di poter accedere alle sue funzionalità è necessario inserire qualche dato iniziale\n\n"
                + "Sei un maschio o una femmina?");
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
     * @return
     */
    public static SendMessage getVistaPeso() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Quanto pesi attualmente?");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }

    /**
     * Restituisce la vista relativa all'altezza
     * 
     * @return
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
     * @return
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
     * Restituisce una vista di errore sui dati inseriti dall'utente
     * 
     * @return
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
