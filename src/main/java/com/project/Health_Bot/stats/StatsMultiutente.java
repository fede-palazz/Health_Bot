/**
 * 
 */
package com.project.Health_Bot.stats;

/**
 * Classe che contiene i metodi che generano le statistiche,
 * di tipo multiutente.
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class StatsMultiutente {

    /**
     * Metodo che stabilisce se il peso dell'utente è
     * il minore mai registrato.
     * 
     * @param pesoUtente
     * @param pesoMin
     * @return pesoUtente
     */
    public static float confrontoPesoMIN(float pesoUtente, float pesoMin) {
        if (pesoUtente < pesoMin) {
            System.out.println("Ecco il nuovo peso minimo mai registrato: " + pesoUtente);
            return pesoUtente;
        }
        return 0;
    }

    /**
     * Metodo che stabilisce se il peso dell'utente è
     * il maggiore mai registrato.
     * 
     * @param pesoUtente
     * @param pesoMax
     * @return pesoUtente
     */
    public static float confrontoPesoMAX(float pesoUtente, float pesoMax) {
        if (pesoUtente > pesoMax) {
            System.out.println("Ecco il nuovo peso massimo mai registrato: " + pesoUtente);
            return pesoUtente;
        }
        return 0;
    }

    /**
     * Metodo che stabilisce se il BMI dell'utente è
     * il minore mai registrato.
     * 
     * @param bmiUtente
     * @param bmiMin
     * @return bmiUtente
     */
    public static float confrontoBMIMin(float bmiUtente, float bmiMin) {
        if (bmiUtente < bmiMin) {
            System.out.println("Ecco il nuovo BMI minimo mai registrato: " + bmiUtente);
            return bmiUtente;
        }
        return 0;
    }

    /**
     * Metodo che stabilisce se il BMI dell'utente è
     * il maggiore mai registrato.
     * 
     * @param bmiUtente
     * @param bmiMax
     * @return bmiUtente
     */
    public static float confrontoBMIMax(float bmiUtente, float bmiMax) {
        if (bmiUtente > bmiMax) {
            System.out.println("Ecco il nuovo BMI massimo mai registrato: " + bmiUtente);
            return bmiUtente;
        }
        return 0;
    }

    /**
     * Metodo che stabilisce se il LBM dell'utente è
     * il minore mai registrato.
     * 
     * @param lbmUtente
     * @param lbmMin
     * @return lbmUtente
     */
    public static float confrontoLBMMin(float lbmUtente, float lbmMin) {
        if (lbmUtente < lbmMin) {
            System.out.println("Ecco il nuovo LBM minimo mai registrato: " + lbmUtente);
            return lbmUtente;
        }
        return 0;
    }

    /**
     * Metodo che stabilisce se il LBM dell'utente è
     * il minore mai registrato.
     * 
     * @param lbmUtente
     * @param lbmMax
     * @return lbmUtente
     */
    public static float confrontoLBMMax(float lbmUtente, float lbmMax) {
        if (lbmUtente > lbmUtente) {
            System.out.println("Ecco il nuovo LBM massimo mai registrato: " + lbmUtente);
            return lbmUtente;
        }
        return 0;
    }

}
