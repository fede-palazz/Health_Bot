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
	
	private JSONArray ja = null;
	private JSONObject obj = null;
	private static FileWriter file;
	protected String risposta;
	private int altezza;
	private double peso;
	private double bmi;
	
	public GestioneJSONOnline() {
		this.obj = new JSONObject();
		this.ja = new JSONArray();
	}

	public JSONArray getArray() {
		return ja;
	}

	public void setArray(JSONArray ja) {
		this.ja = ja;
	}

	public JSONObject getObject() {
		return obj;
	}

	public void setObject(JSONObject obj) {
		this.obj = obj;
	}
	
	/**
	 * Inserisco un JSONObject nel mio JSONArray.
	 * @param jo JSONOnject
	 */
	public void insertObject(JSONObject obj) {
		this.ja.add(obj);
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
		file = new FileWriter(nome_file, true); //true = non sovrascive il file
		file.write(obj.toJSONString()+"\n");

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
	 * Metodo per leggere un oggetto da un file di testo .json.
	 * Posso scegliere se caricare un JSONObject oppure un JSONArray.
	 * 
	 * @param nome_file Nome del file da cui leggere l'oggetto.
	 * @param isObject Specifica se l'oggetto da salvare � un JSONObject oppure un JSONArray.
	 */
	public void caricaFile(String nome_file, boolean isObject) {
		String data = "";
		String line = "";
		try {
			Scanner file_input = new Scanner(new BufferedReader(new FileReader(nome_file)));	  
			String str = file_input.nextLine();
			
			if(isObject) {
				this.obj = (JSONObject) JSONValue.parseWithException(str);	 //parse JSON Object
				System.out.println("JSONObject letto: "+ this.obj);
			}else{
				this.ja = (JSONArray) JSONValue.parseWithException(str);	//parse JSON Array
				System.out.println("JSONArray letto: "+ this.ja);
				System.out.println("IL JSONArray letto ha "+ this.ja.size()+" elementi!");
			}
			
			file_input.close();
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo per scaricare un JSONObject utilizzando l'API del BMI.
	 * 
	 * @throws ParseException 
	 * 
	 */
	public JSONObject BMIAPI () throws ParseException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://body-mass-index-bmi-calculator.p.rapidapi.com/metric?weight=peso&height=altezza"))
				.header("x-rapidapi-key", "b799bcf831msha880494b27071fbp184accjsna4aba3b9c35d")
				.header("x-rapidapi-host", "body-mass-index-bmi-calculator.p.rapidapi.com")
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
				System.out.println(response.body()); //mi da una stringa java
				risposta = response.body();
				JSONParser parser = new JSONParser();
				JSONObject obj = (JSONObject) parser.parse(risposta);
				System.out.println(obj); //ho il mio JSONObject
				return obj;
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
			.uri(URI.create("https://food-calorie-data-search.p.rapidapi.com/api/search?keyword=cibo"))
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
			System.out.println(response.body()); //mi da un JSONString
			risposta = response.body();
			JSONParser parser = new JSONParser();
			JSONArray ja = (JSONArray) parser.parse(risposta);
			JSONObject obj = new JSONObject();
			obj.put("Nutrienti", ja);
			return obj;
			}
			}


	