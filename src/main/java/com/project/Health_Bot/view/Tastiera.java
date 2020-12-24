/**
 * 
 */
package com.project.Health_Bot.view;

import java.util.List;
import java.util.Vector;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 * Classe che rappresenta una tastiera personalizzata di risposta al bot
 *
 */
public class Tastiera {

    /**
     * Restituisce una tastiera formattata con pulsanti tutti sulla stessa riga
     * 
     * @param testoTast
     * @return
     */
    public static ReplyKeyboardMarkup getTastiera(Vector<String> testoTast) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new Vector<KeyboardRow>();

        KeyboardRow row = new KeyboardRow(); // Riga della tastiera
        for (String testo : testoTast) // Aggiunge i pulsanti alla riga
            row.add(testo);
        keyboard.add(row); // Aggiunge la riga alla tastiera
        keyboardMarkup.setKeyboard(keyboard); // Setta il layout
        keyboardMarkup.setResizeKeyboard(true); // Mostra la tastiera in modo compatto
        return keyboardMarkup;
    }

    /**
     * Restituisce una tastiera formattata con pulsanti su più righe
     * 
     * @param testoBtn
     * @return
     */
    public static ReplyKeyboardMarkup getTastiera(List<Vector<String>> testoTast) {

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new Vector<KeyboardRow>();

        testoTast.forEach((rigaTast) -> { // Per ogni riga della tastiera
            KeyboardRow row = new KeyboardRow(); // Crea una nuova riga
            rigaTast.forEach((pulsante) -> { // Per ogni pulsante di ogni riga
                row.add(pulsante);
            });
        });
        keyboardMarkup.setKeyboard(keyboard); // Setta il layout
        keyboardMarkup.setResizeKeyboard(true); // Mostra la tastiera in modo compatto
        return keyboardMarkup;
    }

    /**
     * Restituisce un oggetto che permette di rimuovere la tastiera dalla schermata del client Telegram
     * 
     * @return
     */
    public static ReplyKeyboardRemove rimuoviTastiera() {
        return new ReplyKeyboardRemove(true);
    }
}
