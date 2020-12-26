/**
 * 
 */
package com.project.Health_Bot.stats;

import java.util.Collections;
import java.util.Vector;

/**
 * Classe che contiene i metodi che generano le statistiche,
 * per un utente singolo.
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class StatsSingole {

	// (1) Fare un metodo che entra nel JSONArray misurazioni cerca tra  
	// i vari vector di tipo Misurazione il valore del peso e li colleziona in un
	// altro vector di tipo FLOAT chiamato pesi
	
	/**
	 * Metodo che identifica il peso maggiore mai registrato dall'utente
	 * 
	 * @param pesi
	 * @return valore del peso maggiore
	 */
	public static float pesoMAX (Vector <Float> pesi) {
		// Ordino dal minore al maggiore
		// ritorno il maggiore
		Collections.sort(pesi);
		System.out.println("Ecco il peso massimo mai registrato da te: " +pesi.get(pesi.size()-1));
		return pesi.get(pesi.size()-1) ;
	}
	
	/**
	 * Metodo che identifica il peso minore mai registrato dall'utente
	 * 
	 * @param pesi
	 * @return valore del peso minore
	 */
	public static float pesoMIN (Vector <Float> pesi) {
		// Ordino dal minore al maggiore
		// ritorno il maggiore
		Collections.sort(pesi);
		System.out.println("Ecco il peso minimo mai registrato da te: " + pesi.get(0));
		return pesi.get(0) ;
	}
	
	// (2) Fare un metodo che entra nel JSONArray misurazioni cerca tra  
	// i vari vector di tipo Misurazione il valore del bmi e li colleziona in un
	// altro vector di tipo FLOAT chiamato bmi
	
	/**
	 * Metodo che identifica il bmi maggiore mai registrato dall'utente
	 * 
	 * @param bmi
	 * @return valore del bmi maggiore
	 */
	public static float bmiMAX (Vector <Float> bmi) {
		// Ordino dal minore al maggiore
		// ritorno il maggiore
		Collections.sort(bmi);
		System.out.println("Ecco il BMI massimo mai registrato da te: " +bmi.get(bmi.size()-1));
		return bmi.get(bmi.size()-1) ;
	}
	
	/**
	 * Metodo che identifica il bmi minore mai registrato dall'utente
	 * 
	 * @param bmi
	 * @return valore del bmi minore
	 */
	public static float bmiMIN (Vector <Float> bmi) {
		// Ordino dal minore al maggiore
		// ritorno il maggiore
		Collections.sort(bmi);
		System.out.println("Ecco il BMI minimo mai registrato da te: " +bmi.get(0));
		return bmi.get(0) ;
	}
	
	
	// (3) Fare un metodo che entra nel JSONArray misurazioni cerca tra  
	// i vari vector di tipo Misurazione il valore dell'lbm e li colleziona in un
	// altro vector di tipo FLOAT chiamato lbm
		
		/**
		 * Metodo che identifica l'lbm maggiore mai registrato dall'utente
		 * 
		 * @param lbm
		 * @return valore dell'lbm maggiore
		 */
		public static float lbmMAX (Vector <Float> lbm) {
			// Ordino dal minore al maggiore
			// ritorno il maggiore
			Collections.sort(lbm);
			System.out.println("Ecco l'LBM massimo mai registrato: " + lbm.get(lbm.size()-1));
			return lbm.get(lbm.size()-1) ;
		}
		
		/**
		 * Metodo che identifica l'lbm minore mai registrato dall'utente
		 * 
		 * @param lbm
		 * @return valore dell'lbm minore
		 */
		public static float lbmMIN (Vector <Float> lbm) {
			// Ordino dal minore al maggiore
			// ritorno il maggiore
			Collections.sort(lbm);
			System.out.println("Ecco l'LBM minimo mai registrato da te: " + lbm.get(0));
			return lbm.get(0) ;
		}
	
		/**
		 * Metodo che torna la media-peso dopo le ultime n pesate
		 * 
		 * @param pesi
		 * @param n
		 * @return media-peso
		 */
		public static float mediaPeso (Vector <Float> pesi, int n) {
			float sum = 0;
			
			for (int j = 0; j<n; j++) {
				sum += pesi.get(pesi.size()-1-j); // sum = sum + pesi.get(pesi.size()-1-j);
			}
			//System.out.println("Sum: " + sum);
		    System.out.println("La media delle ultime n pesature è " + sum/n);
		    return sum/n;
		}
		
		/**
		 * Metodo che torna la media-BMI dopo le ultime n pesate
		 * 
		 * @param bmi
		 * @param n
		 * @return media-BMI
		 */
		public static float mediaBMI (Vector <Float> bmi, int n) {
			float sum = 0;
			
			for (int j = 0; j<n; j++) {
				sum += bmi.get(bmi.size()-1-j); // sum = sum + bmi.get(bmi.size()-1-j);
			}
			//System.out.println("Sum: " + sum);
		    System.out.println("La media delle ultime n pesature è " + sum/n);
		    return sum/n;
		}
	
		/**
		 * Metodo che torna la media-LBM dopo le ultime n pesate
		 * 
		 * @param lbm
		 * @param n
		 * @return media-LBM
		 */
		public static float mediaLBM (Vector <Float> lbm, int n) {
			float sum = 0;
			
			for (int j = 0; j<n; j++) {
				sum += lbm.get(lbm.size()-1-j); // sum = sum + lbm.get(lbm.size()-1-j);
			}
			//System.out.println("Sum: " + sum);
		    System.out.println("La media delle ultime n pesature è " + sum/n);
		    return sum/n;
		}
	
		/**
		 * Metodo che calcola la perdita o l'incremento di peso odierno/a.
		 * 
		 * @param pesi
		 * @return incremento o perdita
		 */
		public static float perditaPeso (Vector <Float> pesi) { //Deve prendere in input il Vector pesi già formattato
			if ( pesi.get(0) > pesi.get(pesi.size()-1)) {
				System.out.println("La perdita di peso è: " + (pesi.get(0) - pesi.get(pesi.size()-1)) + "Kg");
				return pesi.get(0) - pesi.get(pesi.size()-1);
			} else {
				System.out.println("Non c'è stata una perdita di peso, bensì un incremento, pari a: " + (pesi.get(pesi.size()-1) - pesi.get(0)) + "Kg");
				return pesi.get(pesi.size()-1) - pesi.get(0);
			} 
		}

		
}
