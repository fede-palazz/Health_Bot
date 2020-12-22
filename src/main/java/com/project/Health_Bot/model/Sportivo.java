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
 * @param annoNascita
 * @param stileDiVita
 */
	public Sportivo(char genere, int altezza, float peso, int annoNascita, String stileDiVita) {
		super(genere, altezza, peso, annoNascita);
		this.stileDiVita = utenteSportivo;
	}

}
