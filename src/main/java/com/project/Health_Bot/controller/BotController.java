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

import com.project.Health_Bot.exception.FilterArgumentException;
import com.project.Health_Bot.exception.InvalidParamException;
import com.project.Health_Bot.exception.InvalidUpdateException;

import com.project.Health_Bot.filter.GestoreFiltri;
import com.project.Health_Bot.model.Misura;
import com.project.Health_Bot.model.Misurazione;
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

	@SuppressWarnings("unchecked")
	@GetMapping("/tipo")
	public JSONObject getTipo(@RequestParam("tipo") String tipo) {

		Vector<Utente> utenti = JSONOffline.getUtenti();
		float type = 0;
		if (tipo.equals("sed") || (tipo.equals("sport")) || (tipo.equals("pes"))) {
			StatsImpl statics = new StatsImpl();
			type = statics.percTipo(tipo, utenti);
		} else
			throw new InvalidParamException("Tipo inserito inesistente");

		JSONObject jo = new JSONObject();
		jo.put("descrizione", "percentuale di: ");
		jo.put(tipo, type + " %");

		return jo;

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/genere")
	public JSONObject getGenere(@RequestParam("genere") Character genere) {

		Vector<Utente> utenti = JSONOffline.getUtenti();
		float type = 0;
		if (genere.equals('M') || (genere.equals('F'))) {
			StatsImpl statics = new StatsImpl();
			type = statics.percGenere(genere, utenti);
		} else
			throw new InvalidParamException("Genere inserito non valido");

		JSONObject jo = new JSONObject();
		jo.put("descrizione", "percentuale di ");
		jo.put(genere, type + " %");

		return jo;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/rangeEta")
	public JSONObject getRangeEta(@RequestParam("eta") int eta) {

		Vector<Utente> utenti = JSONOffline.getUtenti();

		float type = 0;
		StatsImpl statics = new StatsImpl();
		type = statics.percRangeEta(eta, utenti);

		JSONObject jo = new JSONObject();
		jo.put("descrizione", "...");
		jo.put("percentuale di " + eta, type + " %");

		return jo;

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/condizioni")
	public JSONObject getCondizioni(@RequestParam("condizioni") String condizione) {

		Vector<Utente> utenti = JSONOffline.getUtenti();
		float type = 0;
		if (condizione.equals("magro") || condizione.equals("sott") || condizione.equals("norm")
				|| condizione.equals("sovr") || condizione.equals("ob1") || condizione.equals("ob2")
				|| condizione.equals("ob3")) {
			StatsImpl statics = new StatsImpl();
			type = statics.percCondizioni(condizione, utenti);
		} else
			throw new InvalidParamException("Condizione inserita non valida");
		JSONObject jo = new JSONObject();
		jo.put("descrizione", "...");
		jo.put("percentuale di " + condizione, type + " %");

		return jo;
	}
//TODO
	@GetMapping("/varParam")
	public JSONObject getVarParam(@RequestParam("param") String param) {

		Vector<Utente> utenti = JSONOffline.getUtenti();
		Vector<Misurazione> mis = JSONOffline.getMisura(utenti);
		
		float type = 0;
		if (param.equals("peso")) { //|| param.equals("bmi") || param.equals("lbm")){
			StatsImpl statics = new StatsImpl();
			type = statics.varazioneParam(param, mis);
		} else
			throw new InvalidParamException("Condizione inserita non valida");
		
		JSONObject jo = new JSONObject();
		jo.put("descrizione", "...");
		jo.put("percentuale di " + param, type + " %");

		return jo;
	}
	
	@GetMapping("/ultMis")
	public Vector<Misurazione> getUltMis(@RequestParam("lastMis") int n){
		
		Vector<Utente> utenti = JSONOffline.getUtenti();
		Vector<Misurazione> mis = JSONOffline.getMisura(utenti);
		//ordino per data
	    mis.sort((m1, m2) -> m1.getData().compareTo(m2.getData()));

		StatsImpl statics = new StatsImpl();
		return statics.ultimeMis(n, mis);
				
	}

}
