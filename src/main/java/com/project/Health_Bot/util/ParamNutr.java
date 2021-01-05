/**
 * 
 */
package com.project.Health_Bot.util;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che contiene metodi per i calcoli dei parametri
 * 
 */
public class ParamNutr {

	/**
	 * Metodo che calcola il BMI, cioè l'indice di Massa Corporeo.
	 * 
	 * @param peso 
	 * @param altezza
	 * @return valore del BMI
	 */
	public static float calcolaBMI(float peso, int altezza) {
		// L'altezza deve essere convertita in metri
		float altezzaMetr = (float) altezza / 100;
		return (float) ((float) Math.round((peso / Math.pow(altezzaMetr, 2)) * 100) / 100);
	}

	/**
	 * Metodo che calcola il BMR, cioè il fabbisogno metabolico a riposo.
	 * 
	 * @param sesso
	 * @param LBM
	 * @param altezza
	 * @param eta
	 * @return valore del BMR
	 */
	public static float calcolaBMR(char sesso, float lbm, int altezza, int eta) {
		if (sesso == 'M')
			return (float) (Math.round(((66 + (13.7 * lbm) + (5 * altezza) - (6.8 * eta)) * 100d) / 100d));
		else
			return (float) (Math.round(((65 + (9.6 * lbm) + (1.8 * altezza) - (4.7 * eta)) * 100d) / 100d));
	}

	/**
	 * Metodo che calcola l'LBM, cioè la Massa Magra in Kg.
	 * 
	 * @param sesso
	 * @param peso
	 * @param altezza
	 * @return valore dell'LBM
	 */
	public static float calcolaLBM(char sesso, float peso, int altezza) {
		if (sesso == 'M')
			return (float) (Math.round(((1.1 * peso) - 128 * (Math.pow((peso / altezza), 2))) * 100d) / 100d);

		else
			return (float) (Math.round(((1.07 * peso) - 148 * (Math.pow((peso / altezza), 2))) * 100d) / 100d);
	}

	/**
	 * Metodo che calcola l'FCG, cioè il Fabbisogno Calorico Giornaliero
	 * 
	 * @param BMR
	 * @param tipo
	 * @return valore dell'FCG
	 */
	public static int calcolaFCG(float bmr, String tipo) {
		switch (tipo) {
		case "sed":
			return (int) (1.0 * bmr);
		case "sport":
			return (int) (1.2 * bmr);
		case "pes":
			return (int) (1.4 * bmr);
		}
		return 0;

	}

	/**
	 * Metodo che calcola l'IW, cioè il peso ideale.
	 * 
	 * @param sesso
	 * @param altezza
	 * @return valore dell'IW
	 */
	public static float calcolaIW(char sesso, int altezza) {
		float altezzaMetr = (float) altezza / 100;
		if (sesso == 'M') {
			float iw = (float) altezzaMetr * altezzaMetr * (float) 22.1;
			return (float) (Math.round(iw * 100d) / 100d);
		} else {
			float iw = (float) altezzaMetr * altezzaMetr * (float) 20.6;
			return (float) (Math.round(iw * 100d) / 100d);
		}
	}

	/**
	 * Metodo che ritorna la condizione di salute dell'utente
	 * 
	 * @param bmi
	 * @return condizione utente
	 */
	public static String condCorp(float bmi) {
		if (bmi < 16) {
			return "GRAVE MAGREZZA";
		} else if (bmi >= 16 && bmi <= 18.49) {
			return "SOTTOPESO";
		} else if (bmi >= 18.5 && bmi <= 24.99) {
			return "NORMOPESO";
		} else if (bmi >= 25 && bmi <= 29.99) {
			return "SOVRAPPESO";
		} else if (bmi >= 30 && bmi <= 34.99) {
			return "OBESITÀ CLASSE I (lieve)";
		} else if (bmi >= 35 && bmi <= 39.99) {
			return "OBESITÀ CLASSE II (media)";
		} else if (bmi >= 40) {
			return "OBESITÀ CLASSE III (grave)";
		}
		return null;
	}

}
