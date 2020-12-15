package com.project.Health_Bot.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.client.RestTemplate;

// Interfaccia per JSON
// file JSON Repository locale per i dati salvati

public interface JSON_Parser {

	JSONParser parser = new JSONParser();
	JSONObject obj = null;
	private static void getEmployees() {
		
		final String url = "https://api.openweathermap.org/data/2.5/find?q=Ancona,IT&units=metric&APPID=68c805f91c78f1242f846589a0330896";
		RestTemplate restTemplate = new RestTemplate(); //oggetto che serve per consumare un API REST esterna
		String result = restTemplate.getForObject(url,String.class);
		System.out.println(result); //per vedere se ha funzionato
	}

	
	
	
}
