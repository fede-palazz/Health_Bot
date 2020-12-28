package com.project.Health_Bot.model;

import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.project.Health_Bot.util.JSONOffline;

public class Dieta {

    // vector di alimenti per ogni singolo pasto
    private Vector<Alimento> colazione;
    private Vector<Alimento> pranzo;
    private Vector<Alimento> spuntino;
    private Vector<Alimento> cena;

    public Dieta() {
        colazione = new Vector<Alimento>();
        pranzo = new Vector<Alimento>();
        spuntino = new Vector<Alimento>();
        cena = new Vector<Alimento>();
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
    public void generaDieta(float fcg) {

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
        int n = (int) (Math.random() * 3);

        // carica JSONObject da file
        JSONObject dieta = JSONOffline.caricaObj("src/main/resources/dieta.json");

        // COLAZIONE
        JSONObject listCol = (JSONObject) dieta.get("colazioni");
        JSONArray col = (JSONArray) listCol.get(String.valueOf(n + 1));

        // mette dentro il Vector colazione i vari alimenti del pasto
        getPasto(col, colazione);

        // mi calcola le kcal totali della colazione
        kcalColazione = getKcal(colazione);

        // PRANZO
        JSONObject listPra = (JSONObject) dieta.get("pranzi");
        JSONArray pra = (JSONArray) listPra.get(String.valueOf(n + 1));

        // mette dentro il Vector pranzo i vari alimenti del pasto
        getPasto(pra, pranzo);

        // mi calcola le kcal totali del pranzo
        kcalPranzo = getKcal(pranzo);

        // SPUNTINO
        JSONObject listSpu = (JSONObject) dieta.get("spuntino");
        JSONArray spu = (JSONArray) listSpu.get(String.valueOf(n + 1));

        // mette dentro il Vector spuntino i vari alimenti del pasto
        getPasto(spu, spuntino);

        // mi calcola le kcal totali dello spuntino
        kcalSpuntino = getKcal(spuntino);

        // CENA
        JSONObject listCena = (JSONObject) dieta.get("cena");
        JSONArray cen = (JSONArray) listCena.get(String.valueOf(n + 1));

        // mette dentro il Vector cena i vari alimenti del pasto
        getPasto(cen, cena);

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
     * Metodo che inserisce l'oggetto Alimento nel Vector(Alimento) del pasto scelto
     * 
     * @param ja JSONArray che contiene il pasto selezionato
     */
    private void getPasto(JSONArray ja, Vector<Alimento> pasto) {

        for (int i = 0; i < ja.size(); i++) {
            JSONObject jo = (JSONObject) ja.get(i);
            pasto.add(new Alimento((String) jo.get("nome"), ((Long) jo.get("kcal")).intValue(),
                    ((Long) jo.get("qta")).intValue()));
        }
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
