/**
 * 
 */
package com.project.Health_Bot.util;

/**
 * Classen che contiene metodi per i calcoli dei parametri
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class Calcoli {

	/**
	 * Metodo che calcola il BMI, cioè l'indice di Massa Corporeo.
	 * 
	 * @param peso
	 * @param altezza
	 * @return valore del BMI
	 */
	public static float calcoloBMI (float peso, int altezza) {
		return (float) (peso/(altezza*altezza));
	}
	
	/**
	 * Metodo che calcola il BMR, cioè il fabbisogno metabolico a riposo.
	 * 
	 * @param sesso
	 * @param LBM
	 * @param altezza
	 * @param Eta
	 * @return valore del BMR
	 */
	public static float calcoloBMR (char sesso, float lbm, int altezza, int Eta) {
		if (sesso == 'M') {
			return (float) (66 + (13.7*(lbm)) + (5*altezza) - (6.8*Eta));
		} else {
			return (float) (65 + (9.6*(lbm)) + (1.8*altezza) - (4.7*Eta));
		}
	}
	
	/**
	 * Metodo che calcola l'LBM, cioè la Massa Magra in Kg.
	 * 
	 * @param sesso
	 * @param peso
	 * @param altezza
	 * @return valore dell'LBM
	 */
	public static float calcoloLBM (char sesso, float peso, int altezza) {
		if (sesso == 'M') {
			return (float) ((1.1*peso) - 128*(Math.pow((peso/altezza), 2)));
		} else {
			return (float) ((1.07*peso) - 148*(Math.pow((peso/altezza), 2)));
		}
	}
	
	/**
	 * Metodo che calcola l'FCG, cioè il Fabbisogno Calorico Giornaliero
	 * 
	 * @param BMR
	 * @param tipo
	 * @return valore dell'FCG
	 */
	public static float calcoloFCG (float bmr, String tipo) {
		switch (tipo) {
		case "sed": return (float) (1.0*bmr);
		case "sport": return (float) (1.2*bmr);
		case "pes": return (float) (1.4*bmr);
		}
		return 0;
		
	}
	
	/**
	 * Metodo che calcola l'IW, cioè il peso ideale.
	 * 
	 * @param altezza
	 * @return valore dell'IW
	 */
	public static float calcoloIW (int altezza) {
		return (altezza-100) - ((altezza-150)/2);
	}
	
	
}
