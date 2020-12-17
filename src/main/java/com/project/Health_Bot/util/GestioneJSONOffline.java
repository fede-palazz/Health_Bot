package com.project.Health_Bot.util;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestioneJSONOffline {

	private static FileWriter file;
    /**
     * Metodo per salvare un JSONObject in un file (txt, json, ecc...)
     * 
     * @param nome_file Nome del file in cui salvare l'oggetto.
     * @param Obj Il JSONObject da fornire in ingresso 
     */
    public static void salvaFile(String nome_file, JSONObject obj) {
        
		try {
			  
	            // Constructs a FileWriter given a file name, using the platform's default charset
	            file = new FileWriter(nome_file, true); //true = non sovrascive il file
	            file.write(obj.toJSONString());
	            //verifica("Successfully Copied JSON Object to File...");
	            //verifica("\nJSON Object: " + obj);
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	 
	        } finally {
	 
	            try {
	                file.flush();
	                file.close();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	 
	    static public void verifica(String str) {
	        System.out.println("str");
	    }
	

    /**     
     * Metodo per leggere un JSONObject da un file.  
     * 
     * @param nome_file Nome del file da cui leggere l'oggetto.
     * @return JSONObject Oggetto JSON caricato dal file
     */
    
	    public static JSONObject caricaFile (String nome_file) {
	    	//caricare JSONObject salvato in locale su un file .JSON
	        JSONParser parser = new JSONParser();
	
			try {
				Object obj = parser.parse(new FileReader(nome_file));
	 
				// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
				JSONObject jsonObject = (JSONObject) obj;
				return jsonObject;
	        
	        }catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			return null; 
	    	
	    }
}
