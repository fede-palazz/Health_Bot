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
 *         Interfaccia che modella le statistiche
 *
 */
public interface Stats {

    public Vector<Float> percTipo(Vector<Utente> user);

    public float percTipo(String tipo, Vector<Utente> user);

    public Vector<Float> percGenere(Vector<Utente> user);

    public float percGenere(char gender, Vector<Utente> user);

    public Vector<Float> percRangeEta(Vector<Utente> user);

    public float percRangeEta(int eta, Vector<Utente> user);

    public Vector<Float> percCondizioni(Vector<Utente> user);

    public float percCondizioni(String condizione, Vector<Utente> user);

    public Vector<Float> varazioneParam(Vector<Misurazione> mis);

    public float numeroUltimeMis(Vector<Misurazione> mis);

    public Misurazione paramMax(String param, Vector<Misurazione> mis);

    public Misurazione paramMin(String param, Vector<Misurazione> mis);

    public float paramMedia(String param, Vector<Misurazione> mis);

}
