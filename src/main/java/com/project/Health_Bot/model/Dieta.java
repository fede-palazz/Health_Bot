/**
 * 
 */
package com.project.Health_Bot.model;

import java.util.List;
import java.util.Vector;
import com.project.Health_Bot.util.JSONOffline;

/**
 * Classe che modella l'oggetto dieta
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class Dieta {

    // vector di alimenti per ogni singolo pasto
    private Vector<Alimento> colazione;
    private Vector<Alimento> pranzo;
    private Vector<Alimento> spuntino;
    private Vector<Alimento> cena;
    /**
     * Numero pasti giornalieri
     */
    private int numPasti;
    /**
     * Numero di possibili pasti diversi generabili per ogni pasto
     */
    private int tipiPasti;

    /**
     * Costruttore
     */
    public Dieta() {
        colazione = new Vector<Alimento>();
        pranzo = new Vector<Alimento>();
        spuntino = new Vector<Alimento>();
        cena = new Vector<Alimento>();
        tipiPasti = 3;
        numPasti = 4;
    }

    public Vector<Alimento> getColazione() {
        return colazione;
    }

    public Vector<Alimento> getPranzo() {
        return pranzo;
    }

    public Vector<Alimento> getSpuntino() {
        return spuntino;
    }

    public Vector<Alimento> getCena() {
        return cena;
    }

    /**
     * Genera una dieta calcolata accuratamente in base al valore del FCG
     * dell'utente
     * 
     * @param fcg Fabbisogno calorico giornaliero
     */
    public void generaDieta(int fcg) {

        // kcal dieta standard per ogni pasto
        int kcalColazione = 0;
        int kcalPranzo = 0;
        int kcalSpuntino = 0;
        int kcalCena = 0;
        int ktot = 0;

        // kcal dieta per ogni pasto in base al fcg dell'utente
        int calcol = 0;
        int calpra = 0;
        int calspu = 0;
        int calcen = 0;

        // svuota Vector
        colazione.clear();
        pranzo.clear();
        spuntino.clear();
        cena.clear();

        // numero da 0 e 2 inclusi casuale
        int n = (int) (Math.random() * tipiPasti);

        // Genera la dieta e la carica nelle quattro liste
        List<Vector<Alimento>> pasti = JSONOffline.getDieta(n, numPasti);
        for (int i = 0; i < numPasti; i++) {
            switch (i) {
            case 0: // Colazione
                for (Alimento al : pasti.get(i))
                    colazione.add(al);
                break;
            case 1: // Pranzo
                for (Alimento al : pasti.get(i))
                    pranzo.add(al);
                break;
            case 2: // Spuntino
                for (Alimento al : pasti.get(i))
                    spuntino.add(al);
                break;
            case 3: // Cena
                for (Alimento al : pasti.get(i))
                    cena.add(al);
                break;
            }
        }

        // mi calcola le kcal totali della colazione
        kcalColazione = getKcal(colazione);

        // mi calcola le kcal totali del pranzo
        kcalPranzo = getKcal(pranzo);

        // mi calcola le kcal totali dello spuntino
        kcalSpuntino = getKcal(spuntino);

        // mi calcola le kcal totali della cena
        kcalCena = getKcal(cena);

        ktot = kcalCena + kcalColazione + kcalPranzo + kcalSpuntino;

        // Proporzione per ogni pasto (4 pasti)
        for (int i = 0; i < 4; i++) {
            // nuove calorie calcolate in base al fcg
            calcol = (int) ((fcg * kcalColazione) / ktot);
            calpra = (int) ((fcg * kcalPranzo) / ktot);
            calspu = (int) ((fcg * kcalSpuntino) / ktot);
            calcen = (int) ((fcg * kcalCena) / ktot);
        }

        // mi aggiorna i valori delle kcal e quantita in base al fcg dell'utente
        setAlimento(colazione, calcol, kcalColazione);

        setAlimento(pranzo, calpra, kcalPranzo);

        setAlimento(spuntino, calspu, kcalSpuntino);

        setAlimento(cena, calcen, kcalCena);

    }

    /**
     * Metodo che setta il Vector con i nuovi elementi (kcal, quantita') calcolati
     * in base al fcg dell'utente
     * 
     * @param pasto
     * @param newkcal
     * @param oldkcal
     */
    private void setAlimento(Vector<Alimento> pasto, int newkcal, int oldkcal) {

        for (int i = 0; i < pasto.size(); i++) {
            int nuovekcal = (newkcal * pasto.get(i).getKcal()) / oldkcal;
            int nuoveqta = (nuovekcal * pasto.get(i).getQta()) / pasto.get(i).getKcal();

            pasto.get(i).setKcal(nuovekcal);
            pasto.get(i).setQta(nuoveqta);
        }
    }

    /**
     * Metodo che calcola le Kcal di un pasto
     * 
     * @param pasto
     * @return
     */
    private int getKcal(Vector<Alimento> pasto) {
        int n = 0;
        for (int i = 0; i < pasto.size(); i++)
            n += pasto.get(i).getKcal();
        return n;
    }

    /**
     * Metodo toString()
     */
    @Override
    public String toString() {
        String colaz = null;
        for (Alimento al : colazione)
            colaz += al.toString();
        return colaz;
    }

}
