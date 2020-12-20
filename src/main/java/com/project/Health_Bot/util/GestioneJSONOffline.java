/**
 * 
 */
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
    * Metodo che salva un JSONObject in un file di testo .json.
    * @param nome_file 
    * @param obj
    */
    public static void salvaFile(String nome_file, JSONObject obj) {
        
		try {
			    //true = non sovrascive il file
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
     * @param str
     */
    static public void verifica(String str) {
        System.out.println("str");
    }
	

   /**
    * Metodo per caricare un JSONObject salvato in un file locale.
    * @param nome_file
    * @return
    */
    
	    public static JSONObject caricaFile (String nome_file) {
	    	//caricare JSONObject salvato in locale su un file .JSON
	        JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader(nome_file));
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
