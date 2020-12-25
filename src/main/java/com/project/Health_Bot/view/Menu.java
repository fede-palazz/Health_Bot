/**
 * 
 */
package com.project.Health_Bot.view;

import java.util.List;
import java.util.Vector;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che modella la parte di menù principale dell'utente.
 * 
 */
public class Menu {

    /**
     * Metodo che restituisce il menù del bot
     * 
     * @return
     */
    public static SendMessage getVistaAttivita() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("MENU' Health_Bot");
        // Testo dei pulsanti della tastiera
        List<Vector<String>> pulsanti = new Vector<>();

        Vector<String> pulsanti1 = new Vector<>();
        pulsanti1.add("Aggiorna peso");
        pulsanti1.add("Aggiorna att. fisica 💪");
        pulsanti.add(pulsanti1);

        Vector<String> pulsanti2 = new Vector<>();
        pulsanti2.add("Info nutrizionali");
        pulsanti2.add("Riepilogo salute ⛑");
        pulsanti.add(pulsanti2);

        Vector<String> pulsanti3 = new Vector<>();
        pulsanti3.add("Diagnostica BMI");
        pulsanti3.add("Statistiche");
        pulsanti.add(pulsanti3);

        Vector<String> pulsanti4 = new Vector<>();
        pulsanti4.add("Dieta consigliata 😋");
        pulsanti4.add("Info ℹ️");
        pulsanti.add(pulsanti4);

        mess.setReplyMarkup(Tastiera.getTastiera(pulsanti));
        return mess;
    }

    /**
     * Metodo che permette di aggornare il peso dell'utente
     * 
     * @return
     */
    public static SendMessage getVistaAggPeso() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Qual è il tuo peso attuale? ⚖");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }

    /**
     * Metodo che fa aggiornare il livello di att. fisica selezionato dall'utente
     * 
     * @return
     */
    public static SendMessage getVistaAggAttivita() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Aggiorna il tuo livello di attività fisica 💪: ");
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
     * Restituisce la vista relativa alle informazioni nutrizionali di un alimento
     * 
     * @return
     */
    public static SendMessage getVistaAlimento() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Inserisci il nome di un alimento (solo inglese)");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }

    /**
     * Restituisce la vista relativa al riepilogo
     * dei parametri salutari
     * 
     * @return
     */
    public static SendMessage getVistaRiepilogoSalute(String tipo, float peso, float iw, float fcg, float bmi,
            float lbm) {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Riepilogo SALUTE \n" + "livello di attività fisica 💪: " + tipo + "\n" + "peso: " + peso
                + "[Kg] \n" + "FCG: " + fcg + "[Kcal] \n" + "BMI: " + bmi + "\n" + "LBM: " + lbm + "[Kg] \n");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }

    /**
     * Metodo che diagnostica parametri in base al BMI ed al peso
     * 
     * @param bmi
     * @param condizione
     * @param peso
     * @param iw
     * @return
     */
    public static SendMessage getVistaDiagBMI(float bmi, String condizione, float peso, float iw) {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Dato il tuo BMI, pari a: " + bmi + ", la tua condizione di salute è: \n" + condizione + "\n"
                + "Dato il tuo peso, pari a: " + peso + ", il tuo peso ideale 🔝 sarebbe: " + iw + "[Kg] \n");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }

    // metodo statistiche

}
