/**
 * 
 */
package com.project.Health_Bot.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.project.Health_Bot.exception.APIResponseException;
import com.project.Health_Bot.exception.FoodNotFoundException;
import com.project.Health_Bot.model.AlimentoInfo;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che contiene i metodi che gestiscono i file JSON in online
 * 
 */
public class JSONOnline {

	/**
	 * Metodo che chiama l'API del BMI
	 * 
	 * @param peso    [kg]
	 * @param altezza [cm]
	 * @return valore del BMI
	 * @throws ParseException
	 * @throws APIResponseException
	 */
	public static float BMI_API(float peso, int altezza) throws ParseException, APIResponseException {

		JSONObject jo = (JSONObject) JSONOffline.caricaObj("src/main/resources/config.json").get("bmiAPI");
		String url = jo.get("URL").toString();
		String key = jo.get("key").toString();
		String host = jo.get("host").toString();
		// L'altezza deve essere convertita da cm a m
		float altezzaMetr = (float) altezza / 100;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url + "weight=" + peso + "&height=" + altezzaMetr)).header("x-rapidapi-key", key)
				.header("x-rapidapi-host", host).method("GET", HttpRequest.BodyPublishers.noBody()).build();
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

		// mi da il valore del BMI
		try {
			float bmi = Float.parseFloat(Double.toString((double) obj.get("bmi")));
			// Un modo per troncare a due cifre dopo la virgola...
			return (float) Math.round(bmi * 100) / 100;
		} catch (Exception e) {
			return ParamNutr.calcolaBMI(peso, altezza);
		}
	}

	/**
	 * 
	 * Metodo che chiama l'API del FOOD
	 * 
	 * @param cibo inserito
	 * @return Oggetto di tipo AlimentoInfo contenente i valori nutrizionali del
	 *         cibo scelto
	 * @throws ParseException
	 * @throws APIResponseException
	 * @throws FoodNotFoundException
	 */
	public static AlimentoInfo FOOD_API(String cibo)
			throws ParseException, APIResponseException, FoodNotFoundException {

		JSONObject j0 = (JSONObject) JSONOffline.caricaObj("src/main/resources/config.json").get("foodAPI");
		String url = j0.get("URL").toString();
		String key = j0.get("key").toString();
		String host = j0.get("host").toString();

		cibo = cibo.replaceAll(" ", "%20");
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + cibo)).header("x-rapidapi-key", key)
				.header("x-rapidapi-host", host).method("GET", HttpRequest.BodyPublishers.noBody()).build();
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
		// Prende il JSONObjeect esterno
		JSONObject obj = (JSONObject) parser.parse(response.body());
		// Prende il primo array interno
		JSONArray array = (JSONArray) obj.get("items");

		if (array == null || array.isEmpty()) // Cibo inserito non valido
			throw new FoodNotFoundException("Il cibo inserito non è valido");
		// JSONObject contenente i valori nutrizionali
		JSONObject jo = (JSONObject) array.get(0);

		// Crea un alimento con le relative informazioni nutritive
		AlimentoInfo alimento = new AlimentoInfo(jo.get("name").toString());
		Double qta = (double) jo.get("serving_size_g");
		alimento.setQta(qta.intValue());

		Double kcal = (double) jo.get("calories");
		alimento.setKcal(kcal.intValue());

		alimento.setProteine((double) jo.get("protein_g"));
		alimento.setCarbo((double) jo.get("carbohydrates_total_g"));
		alimento.setLipidi((double) jo.get("fat_total_g"));

		return alimento;
	}

}
