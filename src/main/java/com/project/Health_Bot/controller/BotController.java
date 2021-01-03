/**
 * 
 */
package com.project.Health_Bot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

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
import com.project.Health_Bot.filter.GestoreFiltri;
import com.project.Health_Bot.model.Utente;
import com.project.Health_Bot.service.BotService;
import com.project.Health_Bot.stats.*;
import com.project.Health_Bot.util.JSONOffline;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Classe Controller del Bot
 *
 */
@RestController
public class BotController {

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
	 * Imposta un Listener per ricevere gli update in arrivo da Telegram
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
					} catch (InvalidUpdateException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					// SendResponse response = bot.execute(message);
				}
				return UpdatesListener.CONFIRMED_UPDATES_ALL; // Conferma tutti gli updates ricevuti
			}
		});
	}

	@PostMapping
	public String getStat(@RequestBody GestoreFiltri gest) {

		return "";

	}

	@GetMapping("/tipo")
	public JSONObject getTipo(@RequestParam("tipo") String tipo) {

		// Leggere il DB locale e caricarlo in memoria
        HashMap<String, Utente> db = JSONOffline.caricaDB();
        // Estrapolare gli utenti
        Vector<Utente> utenti = new Vector<Utente>();
        db.forEach((id, utente) -> {
            utenti.add(utente);
        });
        float type = 0;
		if (tipo.equals("sedentari")||(tipo.equals("sportivi"))||(tipo.equals("pesisti"))) {
			StatsImpl statics = new StatsImpl();
			type = statics.percTipo(tipo, utenti);
		}
		JSONObject jo = new JSONObject();
		jo.put("descrizione", "...");
		jo.put("percentuale di " + tipo, type + " %");

		return jo;

	}

	@GetMapping("/genere")
	public int getGenere(@RequestParam("genere") Character genere) {

		// Leggere il DB locale e caricarlo in memoria
        HashMap<String, Utente> db = JSONOffline.caricaDB();
        // Estrapolare gli utenti
        Vector<Utente> utenti = new Vector<Utente>();
        db.forEach((id, utente) -> {
            utenti.add(utente);
        });
        
		if (genere.equals('M') || (genere.equals('F'))) {
			StatsImpl statics = new StatsImpl();
			statics.percGenere(genere, utenti);

		}
		return 0;
	}

	@GetMapping("/rangeEta")
	public int getRangeEta(@RequestParam("eta") int eta) {
		
		
		// Leggere il DB locale e caricarlo in memoria
        HashMap<String, Utente> db = JSONOffline.caricaDB();
        // Estrapolare gli utenti
        Vector<Utente> utenti = new Vector<Utente>();
        db.forEach((id, utente) -> {
            utenti.add(utente);
        });
		
		
		
		return eta;

		
	}

	@GetMapping("/condizioni")
	public int getCondizioni(@RequestParam("condizioni") String tipo) {

		
		// Leggere il DB locale e caricarlo in memoria
        HashMap<String, Utente> db = JSONOffline.caricaDB();
        // Estrapolare gli utenti
        Vector<Utente> utenti = new Vector<Utente>();
        db.forEach((id, utente) -> {
            utenti.add(utente);
        });
        
	}

	@GetMapping("/varParam")
	public int getVarParam(@RequestParam("tipo") String tipo) {

		
		// Leggere il DB locale e caricarlo in memoria
        HashMap<String, Utente> db = JSONOffline.caricaDB();
        // Estrapolare gli utenti
        Vector<Utente> utenti = new Vector<Utente>();
        db.forEach((id, utente) -> {
            utenti.add(utente);
        });
        
	}

}
