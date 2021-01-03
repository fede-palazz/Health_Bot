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

    // Multiutente
    /**
     * Restituisce in un array la percentuale di utenti per ogni livello di attività fisica.
     * 
     * @param utenti
     * @return array di percentuali
     */
    public float[] percTipo(Vector<Utente> utenti);

    /**
     * Restituisce la singola percentuale di utenti per ogni livello di attività fisica scelto.
     * 
     * @param tipo
     * @param utenti
     * @return percentuale scelta
     */
    public float percTipo(String tipo, Vector<Utente> utenti);

    /**
     * Restituisce in un array la percentuale di utenti maschili e femminili.
     * 
     * @param utenti
     * @return array di percentuali
     */
    public float[] percGenere(Vector<Utente> utenti);

    /**
     * Restituisce la singola percentuale di utenti per genere.
     * 
     * @param gender
     * @param utenti
     * @return percentuale scelta
     */
    public float percGenere(char gender, Vector<Utente> utenti);

    /**
     * Restituisce in un array la percentuale di utenti suddivisi per range di età.
     * 
     * @param utenti
     * @return array di percentuali
     */
    public float[] percRangeEta(Vector<Utente> utenti);

    /**
     * Restituisce la singola percentuale relativa al range dell'età scelta.
     * 
     * @param eta
     * @param utenti
     * @return percentuale scelta
     */
    public float percRangeEta(int eta, Vector<Utente> utenti);

    /**
     * Restituisce in un array la percentuale di utenti suddivisi per condizione fisica.
     * 
     * @param utenti
     * @return array di percentuali
     */
    public float[] percCondizioni(Vector<Utente> utenti);

    /**
     * Restituisce la singola percentuale relativa alla condizione fisica scelta.
     * 
     * @param condizione
     * @param utenti
     * @return percentuale scelta
     */
    public float percCondizioni(String condizione, Vector<Utente> utenti);
    // Fine multiutente

    // Utente singolo
    /**
     * Restituisce la percentuale riguardante la variazione rispetto al parametro selezionato.
     * 
     * @param param
     * @param mis
     * @return percentuale scelta
     */
    public float varazioneParam(String param, Vector<Misurazione> mis);

    /**
     * Restituisce le ultime n misurazioni scelte dall'utente.
     * 
     * @param n
     * @param mis
     * @return Vector di misurazioni
     */
    public Vector<Misurazione> ultimeMis(int n, Vector<Misurazione> mis); // Per le rotte

    /**
     * Restituisce il valore massimo del parametro selezionato, tra le misurazioni del singolo utente.
     * 
     * @param param
     * @param mis
     * @return max del param scelto
     */
    public Misurazione paramMax(String param, Vector<Misurazione> mis);

    /**
     * Restituisce il valore minimo del parametro selezionato, tra le misurazioni del singolo utente.
     * 
     * @param param
     * @param mis
     * @return min del param scelto
     */
    public Misurazione paramMin(String param, Vector<Misurazione> mis);

    /**
     * Restituisce la media aritmetica del parametro selezionato.
     * 
     * @param param
     * @param mis
     * @return media aritmetica
     */
    public float paramMedia(String param, Vector<Misurazione> mis);
    // Fine utente singolo

}
