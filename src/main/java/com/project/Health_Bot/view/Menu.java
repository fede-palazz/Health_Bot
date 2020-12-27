/**
 * 
 */
package com.project.Health_Bot.view;

import java.util.Vector;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ReplyKeyboardRemove;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che modella la parte di menù principale dell'utente.
 * 
 */
public class Menu {

    /**
     * Tasto (0)
     * Metodo che restituisce il menù del bot
     * 
     * @return response
     */
    public static SendMessage getVistaMenu(long chatId) {
        // Testo del messaggio
        String mess = ("☦️ MENU' Health_Bot 🏥 \n" + "Di cosa hai bisogno? ");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Pulsanti del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ️🤔🙌🏻" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (1)
     * Metodo che permette di selezionare gli aggiornamenti
     * 
     * @param chatId
     * @return response
     */
    public static SendMessage getVistaAggiornamenti(long chatId) {
        // Testo del messaggio
        String mess = ("🆙 Aggiorna i tuoi parametri 👇🏻");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo dei pulsanti alla risposta
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna peso ⚖", "Aggiorna att. fisica 💪🏻" },
                new String[] { "Torna al menù 🔄" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (1.1)
     * Metodo che permette di aggornare il peso dell'utente
     * 
     * @return response
     */
    public static SendMessage getVistaAggPeso(long chatId) {
        // Testo del messaggio
        String mess = ("Qual è il tuo peso attuale? ⚖");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (1.2)
     * Metodo che fa aggiornare il livello di att. fisica selezionato dall'utente
     * 
     * @return response
     */
    public static SendMessage getVistaAttivita(long chatId) {
        // Testo del messaggio
        String mess = ("Seleziona il tuo livello di attività fisica 💪🏻: ");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo dei pulsanti alla risposta
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Pesante 🏋️🏻️‍️", "Moderato 🏃🏻‍♂️" },
                new String[] { "Sedentario 🧘🏻️", "Torna al menù 🔄" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (2)
     * Metodo che consiglia all'utente come tenersi in forma
     * 
     * @param chatId
     * @param username
     * @return response
     */
    public static SendMessage getVistaConsigli(long chatId, String username) {
        // Testo del messaggio
        String mess = ("Caro " + username + "sei molto importante per noi 🥰😎... \n"
                + "per questo abbiamo pensato di regalarti qualche consiglio per tenerti in forma! 💪🏻💪🏻"
                + "Scegli l'ambito che più ti interessa");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo dei pulsanti alla risposta
        Keyboard tastiera = new ReplyKeyboardMarkup(
                new String[] { "Dieta consigliata 😋", "Allenamento consigliato 🏋️🏻️" },
                new String[] { "Torna al menù 🔄" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (2.1)
     * Metodo che consiglia una dieta in base all'fcg dell'utente.
     * 
     * @param fcg
     * @param dieta
     * @return response
     */
    public static SendMessage getVistaDieta(long chatId, String username, float fcg, String dieta) {
        // Testo del messaggio
        String mess = ("Caro " + username + ", \n"
                + "la dieta 🍽 che ti consiglio 😋, scelta accuratamente in base al valore del tuo FCG é la seguente: \n"
                + dieta);
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto(2.2)
     * Metodo che consiglia l'allenamento in base al livello di attività dell'utente.
     * 
     * @param chatId
     * @param tipo
     * @param username
     * @param allenamento
     * @return response
     */
    public static SendMessage getVistaAllenamento(long chatId, String tipo, String username, String allenamento) {
        // Testo del messaggio
        String mess = ("Caro " + username + ", \n"
                + "dopo aver studiato attentamente il tuo tenore di attività fisica 💪🏻, siamo sicuri che il miglior allenamento per te é il seguente: \n"
                + allenamento);
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto(3.1)
     * Metodo che permette all'utente di inserire il nome di un cibo
     * 
     * @return response
     */
    public static SendMessage getVistaAlimento(long chatId) {
        // Testo del messaggio
        String mess = ("Inserisci il nome di un alimento (solo in inglese) 🍗🥚🍔");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto(3.2)
     * Metodo che restituisce i valori nutrionali di un cibo
     * 
     * @return response
     */
    public static SendMessage getVistaInfoNutr(long chatId, Vector<Object> alimento) {
        // Testo del messaggio
        String mess = ("L'alimento scelto fornisce " + alimento.get(0) + "[Kcal], ripartite in: \n" + alimento.get(2)
                + " carboidrati 🍝\n" + alimento.get(1) + " proteine 🥩\n" + alimento.get(3) + " grassi 🧈\n");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (4)
     * Restituisce la vista relativa al riepilogo
     * dei parametri salutari
     * 
     * @return response
     */
    public static SendMessage getVistaRiepilogoSalute(long chatId, String tipo, float peso, float iw, float fcg,
            float bmr, float bmi, float lbm) {
        // Testo del messaggio
        String mess = ("⛑ Riepilogo dati SALUTE ⛑\n" + "livello di attività fisica 💪🏻: " + tipo + "\n" + "peso: "
                + peso + "[Kg] ⚖\n" + "FCG: " + fcg + "[Kcal] \n" + "BMR: " + bmr + "[Kcal] \n" + "BMI: " + bmi
                + " 🔢 \n" + "LBM: " + lbm + "[Kg] \n");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (5)
     * Metodo che implementa il tasto conosci il tuo corpo
     * 
     * @param chatId
     * @param username
     * @return response
     */
    public static SendMessage getVistaConosciCorpo(long chatId, String username) {
        // Testo del messaggio
        String mess = ("Ciao " + username + " !\n" + "Sai come si vive bene ed in armonia con il mondo? 🧘🏻"
                + "Conoscendo e curando il proprio corpo, come ricorda una celebre citazione di Jim Rohn, che recita: \n"
                + " -Abbi buona cura del tuo corpo, è l'unico posto in cui devi vivere.- \n”"
                + "Per questo ho predisposto per te le seguenti funzioni, che ti permettono di diagnosticare la condizione del tuo fisico e informarti riguardo alcune statistiche, suoi tuoi progressi e in confronto agli altri utenti. ");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo dei pulsanti alla risposta
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Diagnostica 🩺", "📊Statistiche📈" },
                new String[] { "Torna al menù 🔄" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (5.1)
     * Metodo che diagnostica parametri in base al BMI ed al peso
     * 
     * @param bmi
     * @param condizione
     * @param peso
     * @param iw
     * @return response
     */
    public static SendMessage getVistaDiag(long chatId, float bmi, String condizione, float peso, float iw) {
        // Testo del messaggio
        String mess = ("Dato il tuo BMI, pari a: " + bmi + ", la tua condizione di salute è: \n" + condizione + "\n"
                + "Dato il tuo peso attuale ⚖, pari a: " + peso + ", il tuo peso ideale 🔝 sarebbe: " + iw + "[Kg] \n");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (5.2)
     * Da finire con le statistiche scelte
     * 
     * @param chatId
     * @return response
     */
    public static SendMessage getVistaStats(long chatId) {
        // Testo del messaggio
        String mess = ("📊Statistiche e 📈confronti📉");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (6)
     * Metodo che torna cinque diversi bottoni informativi
     * 
     * @return response
     */
    public static SendMessage getVistaInfo(long chatId) {
        // Testo del messaggio
        String mess = ("ℹℹℹ Ottieni le informazioni che cerchi, clicca nei pulsanti sottostanti e scopri il significato degli  indici! ℹℹℹ");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo dei pulsanti alla risposta
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "BMI", "IW‍" }, new String[] { "BMR️", "FCG" },
                new String[] { "LBM️", "Torna al menù 🔄" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (6.1)
     * Metodo che spiega cos'è il BMI e come è utilizzato nel bot
     * 
     * @return response
     */
    public static SendMessage getVistaInfoBMI(long chatId) {
        // Testo del messaggio
        String mess = ("L'indice di massa corporea (abbreviato: IMC o BMI) è un parametro utile per valutare l'adeguatezza del peso negli individui sani. \n"
                + "Per farlo, vengono messi in relazione il peso l'altezza dell'individuo attraverso una semplice operazione algebrica ➕➖, cioè il rapporto ➗ tra il peso espresso in chilogrammi ed il quadrato dell'altezza, in metri quadri. \n"
                + "Come forse hai visto, io ho già calcolato il BMI per te, in base alle tue caratteristische. 😉\n"
                + "1) Clicca sul pulsante Riepilogo salute ⛑, se vuoi sapere il valore del tuo BMI \n"
                + "2) Clicca sul pulsante Diagnostica 🩺, se vuoi sapere il tuo livello di adeguatezza fisica in base al BMI"
                + "3) Clicca sul pulsante 📊Statistiche📈, se invece vuoi conoscere alcune statistiche che riguardano il tuo BMI");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (6.2)
     * Metodo che spiega cos'è l'IW e come è utilizzato nel bot
     * 
     * @return response
     */
    public static SendMessage getVistaInfoIW(long chatId) {
        // Testo del messaggio
        String mess = ("L'indice di peso ideale (abbreviato: PI o IW) è il parametro che indica il peso migliore a cui si può aspirare in base alla propria altezza. \n"
                + "Esistono varie formule 📝 per calcolarlo, noi abbiamo implementato per te quella più utilizzata, cioè una variante della fomula di Travia. \n"
                + "Come forse hai visto, io ho già calcolato l'IW per te, in base alle tue caratteristische. 😉\n"
                + "Clicca sul pulsante Diagnostica 🩺, se vuoi sapere il valore del tuo IW, calcolato in base al tuo peso attuale");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (6.3)
     * Metodo che spiega cos'è il BMR e come è utilizzato nel bot
     * 
     * @return mess
     */
    public static SendMessage getVistaInfoBMR(long chatId) {
        // Testo del messaggio
        String mess = ("Il metabolismo basale a riposo (abbreviato: MBR o BMR) è un parametro utile per valutare la quantità di calorie consumate svolgendo le funzioni di base per garantire la sopravvivenza, come: "
                + "-la respirazione; \n" + "-la circolazione del sangue; \n"
                + "-l’elaborazione delle sostanze nutrienti; \n" + "-la riproduzione cellulare. \n"
                + "Per calcolarlo si tiene conto del sesso dell'individuo, del suo LBM (guarda l'altro tasto infromativo), della sua età e della sua altezza. \n"
                + "Come hai forse visto, io ho già calcolato il BMR per te, in base alle tue caratteristische. 😉\n"
                + "Clicca sul pulsante Riepilogo salute ⛑, se vuoi sapere il valore del tuo BMR \n");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (6.4)
     * Metodo che spiega cos'è l'FCG e come è utilizzato nel bot
     * 
     * @return response
     */
    public static SendMessage getVistaInfoFCG(long chatId) {
        // Testo del messaggio
        String mess = ("L'indice di Fabbisogno Calorico Giornaliero (abbreviato: FCG) è un parametro utile per valutare la quantità di Kcal necessarie per il tuo fabbisogno quotidiano. \n"
                + "Per calcolarlo è stata utilizzata ➕➖ l’equazione di Harris e Benedict ✖️➗, universalmente accettata in campo scientifico, che tiene conto del BMR e del tipo di attività fisica praticata dall'individuo. \n"
                + "Come forse hai visto, io ho già calcolato l'FCG per te in base, alle tue caratteristische. 😉\n"
                + "Clicca sul pulsante Riepilogo salute ⛑, se vuoi sapere il valore del tuo FCG \n");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
                        .resizeKeyboard(true); // Visualizzazione compatta della tastiera (più carina)
        response.replyMarkup(tastiera);
        return response;
    }

    /**
     * Tasto (6.5)
     * Metodo che spiega cos'è l'LBM e come è utilizzato nel bot
     * 
     * @return response
     */
    public static SendMessage getVistaInfoLBM(long chatId) {
        // Testo del messaggio
        String mess = ("L'indice di massa magra (abbreviato: LBM) è un parametro utile per rappresentare tutto ciò che resta dell'organismo dopo averlo privato del grasso di deposito (tessuto adiposo). \n"
                + "Per calcolarlo è stata utilizzata la formula di James 📝, che tiene conto del sesso, dell'altezza e del peso dell'individuo. \n"
                + "Come forse hai visto, io ho già calcolato l'LBM per te, in base alle tue caratteristische. 😉\n"
                + "1) Clicca sul pulsante Riepilogo salute ⛑, se vuoi sapere il valore del tuo LBM \n"
                + "2) Clicca sul pulsante 📊Statistiche📈, se invece vuoi conoscere alcune statistiche che riguardano il tuo LBM \n");
        // Crea l'oggetto di risposta
        SendMessage response = new SendMessage(chatId, mess);
        // Aggiungo la tastiera del menù
        Keyboard tastiera = new ReplyKeyboardMarkup(new String[] { "Aggiorna parametri 🆙👇🏻", "Consigli ☺️🙂" },
                new String[] { "Info nutrizionali 🍽‍️", "Riepilogo salute ⛑" },
                new String[] { "‍️Conosci il tuo corpo 🧘🏻‍♂️️", "Info generali ℹ️" }).oneTimeKeyboard(true) // Riduce "ad icona" la tastiera una volta premuto un tasto
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
        //Rimuove la tastiera
        Keyboard tastiera = new ReplyKeyboardRemove();
        response.replyMarkup(tastiera);
        return response;
    }

}
