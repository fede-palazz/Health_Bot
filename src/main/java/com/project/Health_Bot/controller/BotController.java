/**
 * 
 */
package com.project.Health_Bot.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.project.Health_Bot.exception.InvalidUpdateException;
import com.project.Health_Bot.filter.FiltriMis;
import com.project.Health_Bot.filter.FiltriUser;
import com.project.Health_Bot.filter.FiltroData;
import com.project.Health_Bot.filter.GestoreFiltri;
import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;
import com.project.Health_Bot.service.BotService;
import com.project.Health_Bot.stats.StatsImpl;
import com.project.Health_Bot.util.JSONOffline;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Classe Controller del Bot
 *
 */
@RestController
public class BotController {

    /**
     * Oggetti necessari per far funzionare il controller
     */
    @Autowired
    private BotService service;
    private TelegramBot bot;
    private String botToken;

    /**
     * Costruttore
     */
    public BotController() {
        botToken = JSONOffline.getBotToken();
        bot = new TelegramBot(botToken);
        riceviUpdate();
    }

    /**
     * Imposta un Listener per ricevere gli update in arrivo da Telegramz
     */
    private void riceviUpdate() {
        bot.setUpdatesListener(new UpdatesListener() {

            @Override
            public int process(List<Update> updates) {
                for (Update update : updates) {
                    try {
                        // Per ogni update riceve ed invia la lista dei messaggi di risposta
                        for (SendMessage message : service.gestisciUpdate(update))
                            if (message != null)
                                bot.execute(message);
                    }
                    catch (InvalidUpdateException e) {
                        e.printStackTrace();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    // SendResponse response = bot.execute(message);
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL; // Conferma tutti gli updates ricevuti
            }
        });
    }

    /**
     * Rotta POST che restituisce le statistiche generali degli utenti filtrate secondo i parametri
     * forniti
     * 
     * @param gest
     * @return statistiche generali filtrate
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/stats")
    public JSONObject getStat(@RequestBody GestoreFiltri gest) {

        // Verifica che i parametri dei filtri siano corretti
        gest.convalidaFiltri();

        // Lista utenti totali
        Vector<Utente> utenti = JSONOffline.getUtenti();
        int utentiTot = utenti.size();

        // Filtra la lista di utenti in base ai filtri user
        for (FiltriUser filtro : gest.getFiltriUser())
            filtro.filtra(utenti);

        // Filtra gli utenti in base ai filtri sulle misurazioni
        for (FiltriMis filtro : gest.getFiltriMis()) {
            if (!(filtro instanceof FiltroData)) { // Inibisce filtro data
                Iterator<Utente> iter = utenti.iterator();
                while (iter.hasNext()) {
                    Utente utente = iter.next();
                    // Ottiene tutte le misurazioni di un utente
                    Vector<Misurazione> misure = null;
                    if (utente instanceof Sedentario)
                        misure = ((Sedentario) utente).getMisurazioni();
                    else if (utente instanceof Sportivo)
                        misure = ((Sportivo) utente).getMisurazioni();
                    else if (utente instanceof Pesista)
                        misure = ((Pesista) utente).getMisurazioni();

                    int num = misure.size(); // Numero misurazioni non filtrate
                    filtro.filtra(misure);
                    if (misure.size() < num) {
                        iter.remove();
                    }
                }
            }
        }
        // JSONObject di risposta
        JSONObject response = new JSONObject();
        if (utenti.isEmpty())
            return response;
        // Richiede le statistiche delle GET passando il vettore di utenti filtrato
        response.put("Età", this.getRangeEta(utenti));
        response.put("Genere", this.getGenere(utenti));
        response.put("Condizione", this.getCondizioni(utenti));
        response.put("Livello attività", this.getLvlAtt(utenti));
        response.put("Utenti selezionati", utenti.size() * 100 / utentiTot + "%");
        return response;
    }

    /**
     * Rotta GET che restituisce le statistiche sul livello di attività fisica degli utenti
     * 
     * @param utenti
     * @return statistiche livello attività fisica
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/lvlAtt")
    public JSONArray getLvlAtt(Vector<Utente> utenti) {
        // Carica tutti gli utenti se non specificati come parametro
        if (utenti.isEmpty())
            utenti = JSONOffline.getUtenti();
        String[] tipo = { "Sedentario", "Moderata", "Pesante" };
        StatsImpl stats = new StatsImpl();
        float[] perc = stats.percTipo(utenti);
        JSONArray ja = new JSONArray();
        for (int i = 0; i < perc.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("Livello attività", tipo[i]);
            jo.put("Percentuale", perc[i] + "%");
            ja.add(jo);
        }
        return ja;
    }

    /**
     * Rotta GET che restituisce le statistiche sul genere degli utenti
     * 
     * @param utenti
     * @return statistiche genere
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/genere")
    public JSONArray getGenere(Vector<Utente> utenti) {
        // Carica tutti gli utenti se non specificati come parametro
        if (utenti.isEmpty())
            utenti = JSONOffline.getUtenti();
        String[] genere = { "M", "F" };
        StatsImpl stats = new StatsImpl();
        float[] perc = stats.percGenere(utenti);
        JSONArray ja = new JSONArray();

        for (int i = 0; i < perc.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("Genere", genere[i]);
            jo.put("Percentuale", perc[i] + "%");
            ja.add(jo);
        }
        return ja;
    }

    /**
     * Rotta GET che restituisce le statistiche sull'età degli utenti
     * 
     * @param utenti
     * @return statistiche età
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/rangeEta")
    public JSONArray getRangeEta(Vector<Utente> utenti) {
        // Carica tutti gli utenti se non specificati come parametro
        if (utenti.isEmpty())
            utenti = JSONOffline.getUtenti();
        String[] rangeEta = { "0-17", "18-34", "35-49", "50-64", "65 in sù" };
        StatsImpl stats = new StatsImpl();
        float[] perc = stats.percRangeEta(utenti);
        JSONArray ja = new JSONArray();

        for (int i = 0; i < perc.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("Range di età", rangeEta[i]);
            jo.put("Percentuale", perc[i] + "%");
            ja.add(jo);
        }
        return ja;
    }

    /**
     * Rotta GET che restituisce le statistiche sulle condizioni fisiche degli utenti
     * 
     * @param utenti
     * @return statistiche condizione
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/condizioni")
    public JSONArray getCondizioni(Vector<Utente> utenti) {
        // Carica tutti gli utenti se non specificati come parametro
        if (utenti.isEmpty())
            utenti = JSONOffline.getUtenti();
        String[] condizioni = { "GRAVE MAGREZZA", "SOTTOPESO", "NORMOPESO", "SOVRAPPESO", "OBESITÀ CLASSE I (lieve)", "OBESITÀ CLASSE II (media)", "OBESITÀ CLASSE III (grave)" };
        StatsImpl stats = new StatsImpl();
        float[] perc = stats.percCondizioni(utenti); // Percentuali condizioni utenti
        JSONArray ja = new JSONArray();

        for (int i = 0; i < perc.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("Range di età", condizioni[i]);
            jo.put("Percentuale", perc[i] + "%");
            ja.add(jo);
        }
        return ja;
    }

    /**
     * Rotta GET che restituisce le ultime n misurazioni registrate
     * 
     * @param n numero misurazioni da restituire
     * @return ultime n misurazioni
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/ultMis")
    public JSONArray getUltMis(@RequestParam("num") int n) {
        Vector<Utente> utenti = JSONOffline.getUtenti();
        Vector<Misurazione> mis = JSONOffline.getMisura(utenti);
        // Ordina per data
        mis.sort((m1, m2) -> m1.getData().compareTo(m2.getData()));
        StatsImpl statics = new StatsImpl();
        // Restituisce le ultime n misurazioni
        Vector<Misurazione> ultimeMis = statics.ultimeMis(n, mis);
        // Le restituisce in un JSONArray
        JSONArray ja = new JSONArray();
        for (Misurazione misura : ultimeMis)
            ja.add(JSONOffline.getMisureObj(misura));
        return ja;
    }

    /**
     * Rotta POST che restituisce le ultime n misurazioni registrate avendo applicato i filtri impostati
     * 
     * @param n    numero misurazioni da restituire
     * @param gest gestore filtri
     * @return ultime n misurazioni filtrate
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/ultMis")
    public JSONArray getUltMisFiltr(@RequestParam("num") int n, @RequestBody GestoreFiltri gest) {
        // Verifica che i parametri dei filtri siano corretti
        gest.convalidaFiltri();
        // Utenti nel DB
        Vector<Utente> utenti = JSONOffline.getUtenti();
        // Filtra gli utenti
        gest.filtraUser(utenti);
        // Misurazioni di tutti gli utenti
        Vector<Misurazione> mis = JSONOffline.getMisura(utenti);

        // Filtra le misurazioni
        gest.filtraMis(mis);

        StatsImpl statics = new StatsImpl();
        // Restituisce le ultime n misurazioni
        Vector<Misurazione> ultimeMis = statics.ultimeMis(n, mis);
        // Le restituisce in un JSONArray
        JSONArray ja = new JSONArray();
        for (Misurazione misura : ultimeMis)
            ja.add(JSONOffline.getMisureObj(misura));
        return ja;
    }

}
