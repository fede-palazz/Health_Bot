package com.project.Health_Bot.model;

public class Pesista extends Utente {

	private static String utenteLeggero;
	
	//Costruttore.
	public Pesista(String genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età, stileDiVita);
		this.stileDiVita = utenteLeggero;
	}

}
