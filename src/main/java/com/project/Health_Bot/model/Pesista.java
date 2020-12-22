/**
 * 
 */
package com.project.Health_Bot.model;

/**
 * Classe che modella l'utente pesista.
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class Pesista extends Utente {

	private static String utenteLeggero;
	private String stileDiVita;

	/**
	 * Costruttore di default
	 */
	public Pesista() {

	}

	/**
	 * Costruttore
	 * 
	 * @param genere
	 * @param altezza
	 * @param peso
	 * @param età
	 * @param stileDiVita
	 */
	public Pesista(char genere, int altezza, float peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età);
		this.stileDiVita = utenteLeggero;
	}

}
