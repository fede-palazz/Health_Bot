/**
 * 
 */
package com.project.Health_Bot.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.project.Health_Bot.model.Alimento;

/**
 * Classe che contiene i metodi che gestiscono i file JSON in online
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class GestioneJSONOnline {

	private FileWriter file;
	protected double bmi;

	/**
	 * 
	 * Metodo che chiama l'API del BMI
	 * 
	 * @return valore del BMI
	 * @throws ParseException
	 */
	public double BMI_API(float peso, int altezza) throws ParseException {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://body-mass-index-bmi-calculator.p.rapidapi.com/metric?weight=" + peso
						+ "&height=" + altezza))
				.header("x-rapidapi-key", "b799bcf831msha880494b27071fbp184accjsna4aba3b9c35d")
				.header("x-rapidapi-host", "body-mass-index-bmi-calculator.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;

		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(response.body()); // mi da una stringa java
		String risposta = response.body();

		// convertire da JSONString a JSONObject
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(risposta);

		// System.out.println(obj.get("bmi")); //mi da il valore del BMI
		bmi = (float) obj.get("bmi");
		// Un modo per troncare a due cifre dopo la virgola...
		return (float) Math.round(bmi * 100) / 100;
	}

	/**
	 * 
	 * Metodo che chiama l'API del FOOD
	 * 
	 * @return il JSONObject contente i valori nutrizionali del cibo scelto
	 * @throws ParseException
	 */
	public JSONObject FOOD_API(String cibo) throws ParseException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://food-calorie-data-search.p.rapidapi.com/api/search?keyword=" + cibo))
				.header("x-rapidapi-key", "b799bcf831msha880494b27071fbp184accjsna4aba3b9c35d")
				.header("x-rapidapi-host", "food-calorie-data-search.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;

		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JSONParser parser = new JSONParser();
		// il parsing trasforma il dato in long o double
		JSONArray array = (JSONArray) parser.parse(response.body());

		// prende il quinto JSON Object di un array
		JSONObject jo = (JSONObject) array.get(4);

		return jo;
	}

	/**
	 * 
	 * Metodo che formatta un JSONObject, utilizzato per far funzionare il metodo
	 * precedente
	 * 
	 * @param jo
	 * @return jo1
	 */
	public JSONObject FoodJSON(JSONObject jo) {
		// Casto tutti i valori a Object
		Object d0 = ((Object) jo.get("energ_kcal"));
		Object d1 = ((Object) jo.get("protein"));
		Object d2 = ((Object) jo.get("carbohydrt"));
		Object d3 = ((Object) jo.get("lipid_tot"));

		Vector<Object> nut = new Vector<Object>();
		nut.add(0, d0);
		nut.add(1, d1);
		nut.add(2, d2);
		nut.add(3, d3);

		/*
		 * double[] nutr = new double [5]; nutr[0] = (double) jo.get("energ_kcal");
		 * nutr[1] = (double) jo.get("protein"); nutr[2] = (double)
		 * jo.get("carbohydrt"); nutr[3] = (double) jo.get("lipid_tot");
		 */

		// Cibo c = new Cibo();

		// Creo un nuovo oggetto JSONObject, che è il formattato di jo
		JSONObject jo1 = new JSONObject();
		jo1.put("energ_kcal", d0);
		jo1.put("lipid_tot", d1);
		jo1.put("protein", d2);
		jo1.put("carbohydrt", d3);

		return jo1;
	}

	/**
	 * 
	 * Metodo che salva un JSONObject in un file di testo .json.
	 * 
	 * @param nome_file
	 * @param obj
	 */
	public void salvaOBJFile(String nome_file, JSONObject obj) {
		try {
			// true = non sovrascive il file
			file = new FileWriter(nome_file, true);
			file.write(obj.toJSONString());
			verifica("Successfully Copied JSON Object to File...");
			verifica("\nJSON Object: " + obj);
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {

			try {
				file.flush(); // svuota il buffer
				file.close(); // chiude la lettura del file
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 
	 * Metodo per verificare che il file sia stato salvato correttamente.
	 * 
	 * @param str
	 */
	public void verifica(String str) {
		System.out.println("str");
	}

	/**
	 * 
	 * Metodo per caricare un JSONObject salvato in un file locale.
	 * 
	 * @param nome_file
	 * @return
	 */
	public JSONObject caricaOBJFile(String nome_file) {
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
	
	/**
	 * Metodo un JSONArray in un file di testo .json.
	 * 
	 * @param nome_file
	 * @param ja
	 */
	public void salvaARRAYFile(String nome_file, JSONArray ja) {

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

	public JSONArray caricaARRAYFile(String nome_file) {
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
}
