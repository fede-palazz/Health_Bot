/**
 * 
 */
package com.project.Health_Bot.model;

public class Sedentario extends Utente {
	
	private static String utenteSedentario;

	//Costruttore.
	public Sedentario(String genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età, stileDiVita);
		this.stileDiVita = utenteSedentario;
	}

}
