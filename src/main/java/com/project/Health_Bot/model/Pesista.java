/**
 * 
 */
package com.project.Health_Bot.model;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 * Classe che modella l'utente pesista.
 *
 */
public class Pesista extends Utente {

	private static String utenteLeggero;
	
	//Costruttore.
	public Pesista(String genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età, stileDiVita);
		this.stileDiVita = utenteLeggero;
	}

}
