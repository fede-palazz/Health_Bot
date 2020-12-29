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
public class ParamNutr {

    /**
     * Metodo che calcola il BMI, cioè l'indice di Massa Corporeo.
     * 
     * @param peso
     * @param altezza
     * @return valore del BMI
     */
    public static float calcolaBMI(float peso, int altezza) {
        return (float) ((float) Math.round((peso / Math.pow(altezza, 2)) * 100) / 100);
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
            return (float) (Math
                    .round(((66 + (13.7 * (lbm)) + (5 * altezza) - (6.8 * eta)) / Math.pow(altezza, 2)) * 100d) / 100d);
        else
            return (float) (Math.round(
                    ((65 + (9.6 * (lbm)) + (1.8 * altezza) - (4.7 * eta)) / Math.pow(altezza, 2)) * 100d) / 100d);
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
     * @param altezza
     * @return valore dell'IW
     */
    public static float calcolaIW(char sesso, int altezza) {
        if (sesso == 'M')
            return (float) (Math.pow(altezza / 100, 2) * 22.1);
        else
            return (float) (Math.pow(altezza / 100, 2) * 20.6);
    }

    /**
     * Metodo che ritorna la condizione di salute dell'utente
     * 
     * @param bmi
     * @return condizione utente
     */
    public static String condCorp(float bmi) {
        if (bmi < 16) {
            System.out.println("La tua condizone è: GRAVE MAGREZZA");
            return "GRAVE MAGREZZA";
        }
        else if (bmi >= 16 && bmi <= 18.49) {
            System.out.println("La tua condizone è: SOTTOPESO");
            return "SOTTOPESO";
        }
        else if (bmi >= 18.5 && bmi <= 24.99) {
            System.out.println("La tua condizone è: NORMOPESO");
            return "NORMOPESO";
        }
        else if (bmi >= 25 && bmi <= 29.99) {
            System.out.println("La tua condizone è: SOVRAPPESO");
            return "SOVRAPPESO";
        }
        else if (bmi >= 30 && bmi <= 34.99) {
            System.out.println("La tua condizone è: OBESITÀ CLASSE I (lieve)");
            return "OBESITÀ CLASSE I (lieve)";
        }
        else if (bmi >= 35 && bmi <= 39.99) {
            System.out.println("La tua condizone è: OBESITÀ CLASSE II (media)");
            return "OBESITÀ CLASSE II (media)";
        }
        else if (bmi >= 40) {
            System.out.println("La tua condizone è: OBESITÀCLASSE III (grave)");
            return "OBESITÀCLASSE III (grave)";
        }
        return null;
    }

}
