/**
 * 
 */
package com.project.Health_Bot.util;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestioneJSONOnline {
	
	private FileWriter file;
	protected double i;
	
	
    /**
     * 
     * Metodo che chiama l'API del BMI
     * @return valore del BMI
     * @throws ParseException
     */
	public double BMI_API() throws ParseException {
		
		HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://body-mass-index-bmi-calculator.p.rapidapi.com/metric?weight=80+&height=1.83"))
		.header("x-rapidapi-key", "b799bcf831msha880494b27071fbp184accjsna4aba3b9c35d")
		.header("x-rapidapi-host", "body-mass-index-bmi-calculator.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
		HttpResponse<String> response = null;
		
		try {
		response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} 
		catch (IOException e) {
		e.printStackTrace();
		} 
		catch (InterruptedException e) {
		e.printStackTrace();
		}
		
		System.out.println(response.body()); //mi da una stringa java
		String risposta = response.body();
		
		//convertire da JSONString a JSONObject
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(risposta);
		
		//System.out.println(obj.get("bmi")); //mi da il valore del BMI
		return i = (double) obj.get("bmi");
		}	
		
	
    /**
     * 
     * Metodo che chiama l'API del FOOD
     * @return il JSONObject contente i valori nutrizionali del cibo scelto
     * @throws ParseException
     */
    public JSONObject FOOD_API() throws ParseException {
    	HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create("https://food-calorie-data-search.p.rapidapi.com/api/search?keyword=chicken"/* + this.cibo */))
		        .header("x-rapidapi-key", "b799bcf831msha880494b27071fbp184accjsna4aba3b9c35d")
		        .header("x-rapidapi-host", "food-calorie-data-search.p.rapidapi.com")
		        .method("GET", HttpRequest.BodyPublishers.noBody())
		        .build();
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
		    Object obj = (JSONArray) parser.parse(response.body()); 
		    JSONArray array = (JSONArray) obj;
		    
		    //prende il quinto elemento di un array
		    JSONObject jo = (JSONObject)array.get(4); 
		    
		    return jo;
			}

    
    /**
     * 
     * Metodo che formatta un JSONObject, utilizzato per far funzionare il metodo precedente
     * @param jo
     * @return jo1
     */
	public JSONObject formattazioneJSON (JSONObject jo) {
			// Casto tutti i valori a Object
			Object d0 = ((Object) jo.get("energ_kcal"));
			Object d1 = ((Object) jo.get("water"));
			Object d2 = ((Object) jo.get("protein"));
			Object d3 = ((Object) jo.get("carbohydrt"));
			Object d4 = ((Object) jo.get("lipid_tot"));
			Object d5 = ((Object) jo.get("sugar_tot"));
			
			// Creo un nuovo oggetto JSONObject, che è il formattato di jo
			JSONObject jo1 = new JSONObject();
			jo1.put("energ_kcal", d0);
			jo1.put("water", d1);
			jo1.put("protein", d2 );
			jo1.put("carbohydrt", d3);
			jo1.put("lipid_tot", d4);
			jo1.put("sugar_tot", d5);
			
			return jo1;
			}
	

	/**
	 * 
	 * Metodo che salva un JSONObject in un file di testo .json.
	 * @param nome_file
	 * @param obj
	 */
	public void salvaFile(String nome_file, JSONObject obj) {
		try {
	    //true = non sovrascive il file
		file = new FileWriter("prova1.json", true); 
		file.write(obj.toJSONString());
		verifica("Successfully Copied JSON Object to File...");
		verifica("\nJSON Object: " + obj);
		} 
		catch (IOException e) {
		e.printStackTrace();
		} 
		
		finally {
		
		try {
		file.flush(); // svuota il buffer
		file.close(); // chiude la lettura del file
		} 
		catch (IOException e) {
		e.printStackTrace();
		}
      
	   }
   
	}
	
	
	/**
	 * 
	 * Metodo per verificare che il file sia stato salvato correttamente.
	 * @param str
	 */
	static public void verifica(String str) {
		System.out.println("str");
	  }
	
	
	/**
	 * 
	 * Metodo per caricare un JSONObject salvato in un file locale.
	 * @param nome_file
	 * @return
	 */
	public static JSONObject caricaFile (String nome_file) {
		JSONParser parser = new JSONParser();
		try {
		Object obj = parser.parse(new FileReader(nome_file));
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
		}
		catch (IOException e) {
		e.printStackTrace();
		} catch (ParseException e) {
		e.printStackTrace();
		}
		
		return null;
		}
	
	
	
	
	
  }


	