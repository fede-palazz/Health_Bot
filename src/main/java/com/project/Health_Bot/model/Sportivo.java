/**
 * 
 */
package com.project.Health_Bot.model;

public class Sportivo extends Utente {

	private static String utenteSportivo;
	private String stileDiVita;
/**
 * Costruttore di default
 */
	public Sportivo() {
	}
	
/**
 * Costruttore
 * @param genere
 * @param altezza
 * @param peso
 * @param età
 * @param stileDiVita
 */
	public Sportivo(char genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età);
		this.stileDiVita = utenteSportivo;
	}

}
