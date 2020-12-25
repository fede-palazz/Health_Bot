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
<<<<<<< HEAD
	
	/**
	 * Metodo che restituisce il menù del bot
	 * 
	 * @return mess
	 */
	public static SendMessage getVistaAttivita() {
    	SendMessage mess = new SendMessage();
=======

    /**
     * Metodo che restituisce il menù del bot
     * 
     * @return
     */
    public static SendMessage getVistaAttivita() {
        SendMessage mess = new SendMessage();
>>>>>>> 6229d9ab7353f7aa94a8b15943afc2721ebe5a41
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
        pulsanti3.add("Diagnostica");
        pulsanti3.add("Statistiche");
        pulsanti.add(pulsanti3);

        Vector<String> pulsanti4 = new Vector<>();
        pulsanti4.add("Dieta consigliata 😋");
        pulsanti4.add("Info generali ℹ️");
        pulsanti.add(pulsanti4);

        mess.setReplyMarkup(Tastiera.getTastiera(pulsanti));
        return mess;
    }
<<<<<<< HEAD
	
	/**
	 * Metodo che permette di aggornare il peso dell'utente
	 * 
	 * @return mess
	 */
	public static SendMessage getVistaAggPeso() {
=======

    /**
     * Metodo che permette di aggornare il peso dell'utente
     * 
     * @return
     */
    public static SendMessage getVistaAggPeso() {
>>>>>>> 6229d9ab7353f7aa94a8b15943afc2721ebe5a41
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
     * @return mess
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
     * Metodo che permette all'utente di inserire il nome di un cibo
     * 
     * @return mess
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
     * Metodo che restituisce i valori nutrionali di un cibo
     * 
     * @return mess
     */
    public static SendMessage getVistaAlimentoVal(float Kcaltot, float carbo, float prot, float lip) {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("L'alimento scelto fornisce " + Kcaltot + "[Kcal], ripartite in: \n"
        		+ carbo + "carboidrati \n"
        		+ prot + "proteine \n"
        		+ lip + "grassi \n");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    /**
     * Restituisce la vista relativa al riepilogo
     * dei parametri salutari
     * 
     * @return mess
     */
<<<<<<< HEAD
    public static SendMessage getVistaRiepilogoSalute(String tipo, float peso, float iw, float fcg, float bmr, float bmi, float lbm) {	
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Riepilogo SALUTE \n"
        		+ "livello di attività fisica 💪: " + tipo + "\n"
        		+ "peso: " + peso + "[Kg] \n"
        		+ "FCG: " + fcg + "[Kcal] \n"
        		+ "BMR: " + bmr + "[Kcal] \\n"
        		+ "BMI: " + bmi + "\n"
        		+ "LBM: " + lbm + "[Kg] \n");
=======
    public static SendMessage getVistaRiepilogoSalute(String tipo, float peso, float iw, float fcg, float bmi,
            float lbm) {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Riepilogo SALUTE \n" + "livello di attività fisica 💪: " + tipo + "\n" + "peso: " + peso
                + "[Kg] \n" + "FCG: " + fcg + "[Kcal] \n" + "BMI: " + bmi + "\n" + "LBM: " + lbm + "[Kg] \n");
>>>>>>> 6229d9ab7353f7aa94a8b15943afc2721ebe5a41
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
     * @return mess
     */
    public static SendMessage getVistaDiag(float bmi, String condizione, float peso, float iw) {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
<<<<<<< HEAD
        mess.setText("Dato il tuo BMI, pari a: " + bmi + ", la tua condizione di salute è: \n" 
        		+ condizione + "\n"
        		+ "Dato il tuo peso attuale, pari a: " + peso + ", il tuo peso ideale 🔝 sarebbe: " + iw + "[Kg] \n");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    
    // Da finire con le statistiche scelte
    public static SendMessage getVistaStats() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Statistiche e confronti");
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    /**
     * Metodo che consiglia una dieta in base all'fcg dell'utente.
     * 
     * @param fcg
     * @param dieta
     * @return mess
     */
    public static SendMessage getVistaDieta(float fcg, String dieta) {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("La dieta consigliata, scelta in base al valore del tuo FCG é : \n" + dieta );
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    /**
     * Metodo che torna quattro diversi bottoni informativi
     * 
     * @return mess
     */
    public static SendMessage getVistaInfo() {
    	SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Ottieni le informazioni che cerchi, clicca nei pulsanti sottostanti e scopri il significato degli  indici!");
        // Testo dei pulsanti della tastiera
        List<Vector<String>> pulsanti = new Vector<>();
        
        Vector<String> pulsanti1 = new Vector<>();
        pulsanti1.add("BMI");
        pulsanti1.add("IW‍");
        pulsanti.add(pulsanti1);
        
        Vector<String> pulsanti2 = new Vector<>();
        pulsanti2.add("BMR️");
        pulsanti2.add("FCG");
        pulsanti.add(pulsanti2);
        
        Vector<String> pulsanti3 = new Vector<>();
        pulsanti3.add("LBM️");
        pulsanti.add(pulsanti3);
        
        mess.setReplyMarkup(Tastiera.getTastiera(pulsanti));
        return mess;
    }
    
    /**
     * Metodo che spiega cos'è il BMI e come è utilizzato nel bot
     * 
     * @return mess
     */
    public static SendMessage getVistaInfoBMI() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("L'indice di massa corporea (abbreviato: IMC o BMI) è un parametro utile per valutare l'adeguatezza del peso negli individui sani. \n"
        		+ "Per farlo, vengono messi in relazione il peso l'altezza dell'individuo attraverso una semplice operazione algebrica, cioè il rapporto tra il peso espresso in chilogrammi ed il quadrato dell'altezza, in metri quadri. \n" 
        		+ "Come forse hai visto, io ho già calcolato il BMI per te, in base alle tue caratteristische. 😉\n"
        		+ "1) Clicca sul pulsante Riepilogo salute ⛑, se vuoi sapere il valore del tuo BMI \n"
        		+ "2) Clicca sul pulsante Diagnostica, se vuoi sapere il tuo livello di adeguatezza fisica in base al BMI"
        		+ "3) Clicca sul pulsante Statistiche, se invece vuoi conoscere alcune statistiche che riguardano il tuo BMI"
        		);
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    /**
     * Metodo che spiega cos'è l'IW e come è utilizzato nel bot
     * 
     * @return mess
     */
    public static SendMessage getVistaInfoIW() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("L'indice di peso ideale (abbreviato: PI o IW) è il parametro che indica il peso migliore a cui si può aspirare in base alla propria altezza. \n"
        		+ "Esistono varie formula per calcolarlo, noi abbiamo implementato per te quella più utilizzata, cioè una variante della fomula di Travia. \n" 
        		+ "Come forse hai visto, io ho già calcolato l'IW per te, in base alle tue caratteristische. 😉\n"
        		+ "Clicca sul pulsante Diagnostica, se vuoi sapere il valore del tuo IW, calcolato in base al tuo peso attuale"
        		);
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    /**
     * Metodo che spiega cos'è il BMR e come è utilizzato nel bot
     * 
     * @return mess
     */
    public static SendMessage getVistaInfoBMR() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("Il metabolismo basale a riposo (abbreviato: MBR o BMR) è un parametro utile per valutare la quantità di calorie consumate svolgendo le funzioni di base per garantire la sopravvivenza, come: "
        		+ "-la respirazione; \n"
        		+ "-la circolazione del sangue; \n" 
        		+ "-l’elaborazione delle sostanze nutrienti; \n" 
        		+ "-la riproduzione cellulare. \n"
        		+ "Per calcolarlo si tiene conto del sesso dell'individuo, del suo LBM (guarda l'altro tasto infromativo), della sua età e della sua altezza. \n" 
        		+ "Come hai forse visto, io ho già calcolato il BMR per te, in base alle tue caratteristische. 😉\n"
        		+ "Clicca sul pulsante Riepilogo salute ⛑, se vuoi sapere il valore del tuo BMR \n"
        		);
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    /**
     * Metodo che spiega cos'è l'FCG e come è utilizzato nel bot
     * 
     * @return mess
     */
    public static SendMessage getVistaInfoFCG() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("L'indice di Fabbisogno Calorico Giornaliero (abbreviato: FCG) è un parametro utile per valutare la quantità di Kcal necessarie per il tuo fabbisogno quotidiano. \n"
        		+ "Per calcolarlo è stata utilizzata l’equazione di Harris e Benedict, universalmente accettata in campo scientifico, che tiene conto del BMR e del tipo di attività fisica praticata dall'individuo. \n" 
        		+ "Come forse hai visto, io ho già calcolato l'FCG per te in base, alle tue caratteristische. 😉\n"
        		+ "1) Clicca sul pulsante Riepilogo salute ⛑, se vuoi sapere il valore del tuo FCG \n"
        		);
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
    
    /**
     * Metodo che spiega cos'è l'LBM e come è utilizzato nel bot
     * 
     * @return mess
     */
    public static SendMessage getVistaInfoLBM() {
        SendMessage mess = new SendMessage();
        // Testo del messaggio
        mess.setText("L'indice di massa magra (abbreviato: LBM) è un parametro utile per rappresentare tutto ciò che resta dell'organismo dopo averlo privato del grasso di deposito (tessuto adiposo). \n"
        		+ "Per calcolarlo è stata utilizzata la formula di James, che tiene conto del sesso, dell'altezza e del peso dell'individuo. \n" 
        		+ "Come forse hai visto, io ho già calcolato l'LBM per te, in base alle tue caratteristische. 😉\n"
        		+ "1) Clicca sul pulsante Riepilogo salute ⛑, se vuoi sapere il valore del tuo LBM \n"
        		+ "2) Clicca sul pulsante Statistiche, se invece vuoi conoscere alcune statistiche che riguardano il tuo LBM \n"
        		);
=======
        mess.setText("Dato il tuo BMI, pari a: " + bmi + ", la tua condizione di salute è: \n" + condizione + "\n"
                + "Dato il tuo peso, pari a: " + peso + ", il tuo peso ideale 🔝 sarebbe: " + iw + "[Kg] \n");
>>>>>>> 6229d9ab7353f7aa94a8b15943afc2721ebe5a41
        // Rimuove l'eventuale tastiera visualizzata
        mess.setReplyMarkup(Tastiera.rimuoviTastiera());
        return mess;
    }
<<<<<<< HEAD
    
    
=======

    // metodo statistiche

>>>>>>> 6229d9ab7353f7aa94a8b15943afc2721ebe5a41
}
