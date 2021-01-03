/**
 * 
 */
package com.project.Health_Bot.stats;

import java.util.Vector;
import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Utente;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 *         Classe che implementa l'interfaccia Stats
 *
 */
public class StatsImpl implements Stats {

    /**
     * Restituisce la percentuale di utenti divisi per livello di att. fisica
     */
    @Override
    public Vector<Float> percTipo(Vector<Utente> user) {

        // Già fatt
        return null;
    }

    /**
     * Restituisce la percentuale di utenti di un certo livello di att. fisica
     */
    @Override
    public float percTipo(String tipo, Vector<Utente> user) {
        return 0;
    }

    @Override
    public Vector<Float> percGenere(Vector<Utente> user) {
        return null;

    }

    @Override
    public float percGenere(char gender, Vector<Utente> user) {
        return 0;

    }

    @Override
    public Vector<Float> percRangeEta(Vector<Utente> user) {
        return null;

    }

    @Override
    public float percRangeEta(int eta, Vector<Utente> user) {
        return 0;

    }

    @Override
    public Vector<Float> percCondizioni(Vector<Utente> user) {
        return null;

    }

    @Override
    public float percCondizioni(String condizione, Vector<Utente> user) {
        return 0;

    }

    @Override
    public Vector<Float> varazioneParam(Vector<Misurazione> mis) {
        return null;

    }

    @Override
    public float numeroUltimeMis(Vector<Misurazione> mis) {
        return 0;

    }

    @Override
    public Misurazione paramMax(String param, Vector<Misurazione> mis) {
        return null;

    }

    @Override
    public Misurazione paramMin(String param, Vector<Misurazione> mis) {
        return null;

    }

    @Override
    public float paramMedia(String param, Vector<Misurazione> mis) {
        return 0;

    }
}
