/**
 * 
 */
package com.project.Health_Bot.model;

public class Sportivo extends Utente {

	private static String utenteSportivo;
	
	//Costruttore.
	public Sportivo(String genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età, stileDiVita);
		this.stileDiVita = utenteSportivo;
	}

}
