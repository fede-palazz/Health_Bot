/**
 * 
 */
package com.project.Health_Bot.model;

public class Sedentario extends Utente {
	
	private static String utenteSedentario;
	private String stileDiVita;

	/**
	 * Costruttore di default
	 */
	public Sedentario() {

	}
	
	/**
	 * Costruttore
	 * @param genere
	 * @param altezza
	 * @param peso
	 * @param età
	 * @param stileDiVita
	 */
	public Sedentario(char genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età);
		this.stileDiVita = utenteSedentario;
	}

}
