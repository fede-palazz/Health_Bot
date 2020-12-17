package com.project.Health_Bot.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestioneJSONOnline {
	
	private FileWriter file;
	protected double i;
	
	
   /**
	 * Metodo per scaricare un JSONObject utilizzando l'API del BMI.
	 * 
	 * @throws ParseException 
	 * 
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
     * Metodo per scaricare un JSONObject utilizzando API del FOOD.
     *
     *
     * @param url URL da cui utilizzare la chiamata API.
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
		    Object obj = (JSONArray) parser.parse(response.body()); // il parsing trasfmora il dato in long o double
		    JSONArray array = (JSONArray) obj;
		    
		    JSONObject jo = (JSONObject)array.get(4); //prende il quinto elemento di un array
		    
		    return jo;
			}

    
   /** 
	*
	* Prende in input i dati dal JSONObject
	* formattazione JSON ({ "cibo":"apple", "kcal":"valore diz.",...}
	* salvare la formattazione in JSONObject
	* return JSONObject
	* 
	*/
	public JSONObject formattazioneJSON (JSONObject jo) {
			// Casto tutti i valori a Object
			Object d0 = ((Object) jo.get("energ_kcal"));
			Object d1 = ((Object) jo.get("water"));
			Object d2 = ((Object) jo.get("protein"));
			Object d3 = ((Object) jo.get("carbohydrt"));
			Object d4 = ((Object) jo.get("lipid_tot"));
			Object d5 = ((Object) jo.get("sugar_tot"));
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
	* Metodo per salvare un oggetto in un file di testo .json.
	*
	* @param nome_file Nome del file in cui salvare l'oggetto.
	* @param Obj JSONObject da inserire.
	*/
	public void salvaFile(String nome_file, JSONObject obj) {
		try {
		// Constructs a FileWriter given a file name, using the platform's default charset
		file = new FileWriter("prova1.json", true); //true = non sovrascive il file
		file.write(obj.toJSONString());
		verifica("Successfully Copied JSON Object to File...");
		verifica("\nJSON Object: " + obj);
		} 
		catch (IOException e) {
		e.printStackTrace();
		} 
		finally {
		try {
		file.flush();
		file.close();
		} 
		catch (IOException e) {
		e.printStackTrace();
		}
      }
   }
	
	
	/**
	*
	* Metodo per verificare che il file sia stato salvato.
	* 
	*/
	static public void verifica(String str) {
		System.out.println("str");
	  }
	
	/**
	* Metodo per caricare un oggetto in un file di testo .json.
	*
	* @param nome_file Nome del file in cui salvare l'oggetto.
	* @param Obj JSONObject .
	*/
	public static void caricaFile (String nome_file) {
		//caricare JSONObject salvato in locale su un file .JSON
		JSONParser parser = new JSONParser();
		try {
		Object obj = parser.parse(new FileReader(nome_file));
		// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
		JSONObject jsonObject = (JSONObject) obj;
		System.out.println(jsonObject);
		}catch (IOException e) {
		e.printStackTrace();
		} catch (ParseException e) {
		e.printStackTrace();
		}
		}
	
  }


	