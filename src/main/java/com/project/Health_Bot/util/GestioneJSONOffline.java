/**
 * 
 */
package com.project.Health_Bot.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.project.Health_Bot.dao.UtenteRegDao;
import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;

/**
 * Classe che contiene i metodi che gestiscono i file JSON in offline
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class GestioneJSONOffline {

	private static FileWriter file;

	/**
	 * Metodo che salva un JSONObject in un file di testo .json.
	 * 
	 * @param nome_file
	 * @param obj
	 */
	public static void salvaOBJFile(String nome_file, JSONObject obj) {

		try {
			// true = non sovrascive il file
			file = new FileWriter(nome_file, true);
			file.write(obj.toJSONString());
			verifica("Successfully Copied JSON Object to File...");
			verifica("\nJSON Object: " + obj);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				file.flush();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo per verificare che il file sia stato salvato correttamente.
	 * 
	 * @param str
	 */
	static public void verifica(String str) {
		System.out.println("str");
	}

	/**
	 * Metodo per caricare un JSONObject salvato in un file locale.
	 * 
	 * @param nome_file
	 * @return
	 */

	public static JSONObject caricaOBJFile(String nome_file) {
		// caricare JSONObject salvato in locale su un file .JSON
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(nome_file));
			JSONObject jsonObject = (JSONObject) obj;
			return jsonObject;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void salvaARRAYFile(String nome_file, JSONArray ja) {

		try {
			// true = non sovrascive il file
			file = new FileWriter(nome_file, true);
			file.write(ja.toJSONString());
			verifica("Successfully Copied JSON Array to File...");
			verifica("\nJSONArray: " + ja);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				file.flush();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo per caricare un JSONArray salvato in un file locale.
	 * 
	 * @param nome_file
	 * @return JSONArray
	 */

	public static JSONArray caricaARRAYFile(String nome_file) {
		// caricare JSONObject salvato in locale su un file .JSON
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(nome_file));
			JSONArray ja = (JSONArray) obj;
			return ja;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Metodo che ci da il JSONObject Utente
	 * 
	 * @param id
	 * @param ja
	 * @return
	 */
	public UtenteRegDao getUtente(String id, JSONArray ja) {

		// analizza oggetti dentro array
		for (int i = 0; i < ja.size(); i++) {
			JSONObject jo = (JSONObject) ja.get(i);
			// analizza parametri dentro l'oggetto scelto dal primo for
			for (int j = 0; j < jo.size(); j++) {
				if (jo.get("id").equals(id))
					return (UtenteRegDao) jo.get("utente");
			}
		}
		return null;
	}
	/*
	 * funziona fino allo switch public UtenteRegDao getTipo(JSONObject utente) {
	 * String tipo = (String) utente.get("tipo"); switch (tipo) { case "sport":
	 * Utente sport = new Sportivo(); sport.setAltezza((int) utente.get("altezza"));
	 * break; case "pes": Utente pes = new Pesista();
	 * 
	 * break; case "sed": Utente sed = new Sedentario();
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 */

	/*
	 * Per la creazione del JSONArray contenente le informazioni relatve agli utenti
	 * già registrati, si utilizza un metodo che si estende a matriosca, partendo da
	 * "dentro". Creo lo storico; lo inserisco dentro il JSONArray misurazioni;
	 * inserisco misurazioni dentro utente; inserisco dunque utente dentro il
	 * general; inserisco il general dentro un JSONArray totale.
	 */

	/**
	 * Metodo che ritorna un JSONArray, dopo aver ricevuto in input un JSONObject.
	 * 
	 * @param generale
	 * @return totale
	 */
	public JSONArray setArray(JSONObject generale) {
		JSONArray totale = new JSONArray();
		totale.add(generale);
		return totale;
	}

	/**
	 * Metodo che ritorna un JSONObject, dopo aver ricevuto in input un JSONObject e
	 * l'id dell'utente selezionato.
	 * 
	 * @param utente
	 * @param id
	 * @return generale
	 */
	public JSONObject setGenerale(Utente utente, String id) {
		JSONObject generale = new JSONObject();
		generale.put("id", id);
		generale.put("utente", utente);
		return generale;
	}

	/**
	 * Metodo che ritorna un JSONObject, dopo aver ricevuto in input tutti i
	 * parametri che descrivono l'utente, tra cui lo storico delle misurazioni.
	 * 
	 * @param username
	 * @param sesso
	 * @param pesoAttuale
	 * @param altezza
	 * @param annoNascita
	 * @param stileDiVita
	 * @param misurazioni
	 * @return utente
	 */
	private JSONObject setUtente(String username, char sesso, float pesoAttuale, int altezza, int annoNascita,
			String stileDiVita, JSONArray misurazioni) {

		JSONObject utente = new JSONObject();

		// inserire JSONOBJ dati dentro JSONArray misurazioni
		utente.put("username", username);
		utente.put("sesso", sesso);
		utente.put("pesoAttuale", pesoAttuale);
		utente.put("altezza", altezza);
		utente.put("annoNascita", annoNascita);
		utente.put("stileDiVita", stileDiVita);
		utente.put("misurazioni", misurazioni);

		return utente;

	}

	/**
	 * Metodo che ritorna un JSONObect, dopo aver ricevuto in input il vector mis di
	 * tipo Misurazione. Lo storico é l'insieme delle misurazioni compiute
	 * dall'utente.
	 * 
	 * @param mis
	 * @return
	 */
	private JSONObject setStorico(Vector<Misurazione> mis) {
		JSONObject storico = new JSONObject();

		storico.put("peso", mis.get(0));
		storico.put("data", mis.get(1));
		storico.put("lbm", mis.get(2));
		storico.put("bmi", mis.get(3));

		return storico;

	}

	/**
	 * Metodo che carica l'allenamento dal file e lo restituisce
	 * 
	 * @param tipo Stile di vita (sed, sport, pes)
	 * @param n    variabile generata randomicamente
	 * @return String un possibile allenamento
	 */
	public static String getAllenamento(String tipo, int n) {

		JSONArray array = caricaARRAYFile("resources/allenamenti.json");

		switch (tipo) {
		case "pes":
			// mi prende allenamenti PESISTA
			JSONObject allenamentiPesista = (JSONObject) array.get(0);
			JSONObject listPes = (JSONObject) allenamentiPesista.get("allenamentiPesista");
			return (String) listPes.get(String.valueOf(n + 1));

		case "sport":
			// mi prende allenamenti SPORTIVO
			JSONObject allenamentiSportivo = (JSONObject) array.get(1);
			JSONObject listSport = (JSONObject) allenamentiSportivo.get("allenamentiSportivo");
			return (String) listSport.get(String.valueOf(n + 1));

		case "sed":
			// mi prende allenamenti SEDENTARIO
			JSONObject allenamentiSedentario = (JSONObject) array.get(2);
			JSONObject listSed = (JSONObject) allenamentiSedentario.get("allenamentiSedentario");
			return (String) listSed.get(String.valueOf(n + 1));

		}
		return null;
	}

}
