/**
 * 
 */
package com.project.Health_Bot.model;

/**
 * Classe che modella l'utente sedentario.
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux 
 *
 */
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
	 * @param annoNascita
	 * @param stileDiVita
	 */
	public Sedentario(char genere, int altezza, float peso, int annoNascita, String stileDiVita) {
		super(genere, altezza, peso, annoNascita);
		this.stileDiVita = utenteSedentario;
	}

}
