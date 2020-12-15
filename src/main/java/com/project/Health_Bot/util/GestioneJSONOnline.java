package com.project.Health_Bot.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class GestioneJSONOnline {
	
	private JSONArray ja = null;
	private JSONObject jo = null;
	
	public GestioneJSONOnline() {
		this.jo = new JSONObject();
		this.ja = new JSONArray();
	}

	public JSONArray getArray() {
		return ja;
	}

	public void setArray(JSONArray ja) {
		this.ja = ja;
	}

	public JSONObject getObject() {
		return jo;
	}

	public void setObject(JSONObject jo) {
		this.jo = jo;
	}
	
	/**
	 * Inserisco un JSONObject nel mio JSONArray.
	 * @param jo JSONOnject
	 */
	public void insertObject(JSONObject jo) {
		this.ja.add(jo);
	}
	
	/**
	 * Metodo per salvare un oggetto in un file di testo .json.
	 * Posso scegliere se salvare un JSONObject oppure un JSONArray.
	 * 
	 * @param nome_file Nome del file in cui salvare l'oggetto.
	 * @param isObject Specifica se l'oggetto da salvare � un JSONObject oppure un JSONArray.
	 */
	public void salvaFile(String nome_file, boolean isObject) {
		try {
			PrintWriter file_output = new PrintWriter(new BufferedWriter(new FileWriter(nome_file)));
			
			if(isObject)
				file_output.println(this.jo);
			else
				file_output.println(this.ja);
			
			file_output.close();
			System.out.println("File salvato!");
		} catch (IOException e) {
			e.printStackTrace();
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
				this.jo = (JSONObject) JSONValue.parseWithException(str);	 //parse JSON Object
				System.out.println("JSONObject letto: "+ this.jo);
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
	 * Metodo per scaricare un oggetto utilizzando API.
	 * Posso scegliere se scaricare un JSONObject oppure un JSONArray.
	 * 
	 * @param url URL da cui utilizzare la chiamata API.
	 * @param isObject Specifica se l'oggetto da salvare � un JSONObject oppure un JSONArray.
	 */
	public void chiamataAPI(String url, boolean isObject) {
		try {
			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();
			
			String data = "";
			String line = "";
			try {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			  
			   while ( ( line = buf.readLine() ) != null ) {
				   data+= line;
			   }
			} finally {
			   in.close();
			}
			//System.out.println("Dati scaricati: "+data);
			if(isObject) {
				this.jo = (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object
				System.out.println("JSONObject scaricato: "+ this.jo);
			} else {
				this.ja = (JSONArray) JSONValue.parseWithException(data);	//parse JSON Array
				System.out.println("JSONArray scaricato: "+ this.ja);
				System.out.println("IL JSONArray scaricato ha "+ this.ja.size()+" elementi:");
			
				/* Esempio di array scaricato:
				 * 
				 * [{"id":"90b...",
				 * 		"type":"Full Time",
				 * 		"url":"https://jobs.github.com/...",
				 * 		"created_at":"Tue Nov 10 23:16:58 UTC 2020",
				 * 		"company":"Gemini",
				 * 		"company_url":"http://www.gemini.com",
				 * 		"location":"San Francisco, CA",
				 * 		"title":"Principal Product Security Engineer",
				 * 		"description":"\u003cp\u003e\u003cstrong\u003eHelp Us...",
				 * 		"how_to_apply":"\u003cp\u003ePlease apply via this link: ",
				 * 		"company_logo":null},
				 * {...}
				 * ]
				 */
				for(int i=0;i<this.ja.size();i++) {
					JSONObject jo = (JSONObject) this.ja.get(i);
					System.out.println(i+") "+jo.get("title"));
				}
			}
				
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
