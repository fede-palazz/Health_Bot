/**
 * 
 */
package com.project.Health_Bot.model;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Interfaccia che modella l'oggetto misura.
 * 
 */
public interface Misura {

	/**
	 * Permette di inserire una nuova misurazione
	 * 
	 * @param peso
	 * @param lbm
	 * @param bmi
	 */
    public void inserisciMisurazione(float peso, float lbm, float bmi);
}
