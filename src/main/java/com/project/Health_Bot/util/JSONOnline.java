/**
 * 
 */
package com.project.Health_Bot.util;

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

import com.project.Health_Bot.exception.APIResponseException;

/**
 * Classe che contiene i metodi che gestiscono i file JSON in online
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class JSONOnline {


	/**
	 * 
	 * Metodo che chiama l'API del BMI
	 * 
	 * @return valore del BMI
	 * @throws ParseException
	 * @throws APIResponseException
	 */
	public float BMI_API(float peso, int altezza) throws ParseException, APIResponseException {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://body-mass-index-bmi-calculator.p.rapidapi.com/metric?weight=" + peso
						+ "&height=" + altezza))
				.header("x-rapidapi-key", "b799bcf831msha880494b27071fbp184accjsna4aba3b9c35d")
				.header("x-rapidapi-host", "body-mass-index-bmi-calculator.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;

		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			if (response == null) {
				throw new APIResponseException("API_BMI non risponde");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (APIResponseException e) {
			return ParamNutr.calcolaBMI(peso, altezza);
		}

		String risposta = response.body();

		// convertire da JSONString a JSONObject
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(risposta);

		// System.out.println(obj.get("bmi")); //mi da il valore del BMI
		float bmi = (float) obj.get("bmi");
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
	public Vector<Object> FOOD_API(String cibo) throws ParseException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://food-calorie-data-search.p.rapidapi.com/api/search?keyword=" + cibo))
				.header("x-rapidapi-key", "b799bcf831msha880494b27071fbp184accjsna4aba3b9c35d")
				.header("x-rapidapi-host", "food-calorie-data-search.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;

		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			if (response == null) {
				throw new APIResponseException("API_FOOD non risponde");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (APIResponseException e) {
			return null;
		}

		JSONParser parser = new JSONParser();
		// il parsing trasforma il dato in long o double
		JSONArray array = (JSONArray) parser.parse(response.body());

		// prende il quinto JSON Object di un array
		JSONObject jo = (JSONObject) array.get(4);

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

		return nut;
	}

}
