/**
 * 
 */
package com.project.Health_Bot.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.project.Health_Bot.dao.UtenteRegDao;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;

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
/* funziona fino allo switch
	public UtenteRegDao getTipo(JSONObject utente) {
		String tipo = (String) utente.get("tipo");
		switch (tipo) {
		case "sport":
			Utente sport = new Sportivo();
			sport.setAltezza((int) utente.get("altezza"));
			break;
		case "pes":
			Utente pes = new Pesista();

			break;
		case "sed":
			Utente sed = new Sedentario();

			break;

		}

		return null;

	}*/
}
