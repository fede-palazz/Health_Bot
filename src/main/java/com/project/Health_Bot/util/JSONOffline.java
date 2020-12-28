/**
 * 
 */
package com.project.Health_Bot.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.project.Health_Bot.model.Alimento;
import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;

/**
 * Gestisce la lettura/scrittura di un file JSON locale
 *
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 */
public class JSONOffline {

    /**
     * Percorso del DB degli utenti
     */
    private final static String pathUtenti = "src/main/resources/utenti.json";

    /**
     * Percorso del file contenente gli allenamenti
     */
    private final static String pathAllenamenti = "src/main/resources/allenamenti.json";

    /**
     * Percorso del file contenente le diete
     */
    private final static String pathDieta = "src/main/resources/dieta.json";

    /**
     * Percorso del file contenente le info sul BOT e sulle chiamate alle API
     */
    private final static String pathConfig = "src/main/resources/config.json";

    /**
     * Oggetto FileWriter utilizzato per leggere/scrivere su file JSON
     */
    private static FileWriter file;

    /**
     * Restituisce il JSONArray letto dal file specificato
     * 
     * @param nome_file
     * @return
     */
    public static JSONArray caricaArray(String nome_file) {
        // caricare JSONObject salvato in locale su un file .JSON
        JSONParser parser = new JSONParser();
        JSONArray ja = null;
        try {
            Object obj = parser.parse(new FileReader(nome_file));
            ja = (JSONArray) obj;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return ja;
    }

    /**
     * Restituisce il JSONObject letto dal file specificato
     * 
     * @param nome_file
     * @return
     */
    public static JSONObject caricaObj(String nome_file) {
        // caricare JSONObject salvato in locale su un file .JSON
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(nome_file));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Controlla se nel DB è presente un utente con un dato id
     * 
     * @param id
     * @return
     */
    public static Boolean isRegistered(String id) {
        JSONArray ja = caricaArray(pathUtenti);
        // Analizza array
        for (int i = 0; i < ja.size(); i++) {
            JSONObject jo = (JSONObject) ja.get(i);
            // Analizza ogni JSONObj
            for (int j = 0; j < jo.size(); j++) {
                if (jo.get("id").equals(id)) // Utente trovato nel DB
                    return true;
            }
        }
        return false; // Utente non registrato
    }

    /**
     * Restituisce un utente salvato nel DB con le proprie misurazioni
     * 
     * @param id
     * @return
     */
    public static Utente getUtente(String id) {
        JSONArray ja = caricaArray(pathUtenti);
        // Analizza array
        for (int i = 0; i < ja.size(); i++) {
            JSONObject jo = (JSONObject) ja.get(i);
            // Analizza ogni JSONObj
            for (int j = 0; j < jo.size(); j++) {
                if (jo.get("id").equals(id)) { // Utente trovato nel DB
                    JSONObject user = (JSONObject) jo.get("utente");
                    Utente utente = null;
                    // Determino il tipo di utente
                    switch (user.get("tipo").toString()) {
                    case "pes":
                        utente = new Pesista(user.get("sesso").toString().charAt(0),
                                Integer.parseInt(user.get("altezza").toString()),
                                Float.parseFloat(user.get("peso").toString()),
                                Integer.parseInt(user.get("annoNascita").toString()));
                        break;
                    case "sport":
                        utente = new Sportivo(user.get("sesso").toString().charAt(0),
                                Integer.parseInt(user.get("altezza").toString()),
                                Float.parseFloat(user.get("peso").toString()),
                                Integer.parseInt(user.get("annoNascita").toString()));
                        break;
                    case "sed":
                        utente = new Sedentario(user.get("sesso").toString().charAt(0),
                                Integer.parseInt(user.get("altezza").toString()),
                                Float.parseFloat(user.get("peso").toString()),
                                Integer.parseInt(user.get("annoNascita").toString()));
                        break;
                    }
                    // Aggiungo le misurazioni salvate
                    JSONArray misurazioni = (JSONArray) user.get("misurazioni");
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); // Oggetto formattatore di date
                    // Per ogni misurazione nel vettore delle misurazioni
                    for (Object misura : misurazioni) {
                        if (misura instanceof JSONObject) {
                            // Leggo i singoli valori della misurazione dal file JSON
                            Misurazione mis = null;
                            try {
                                mis = new Misurazione(Float.parseFloat(((JSONObject) misura).get("peso").toString()),
                                        Float.parseFloat(((JSONObject) misura).get("lbm").toString()),
                                        Float.parseFloat(((JSONObject) misura).get("bmi").toString()),
                                        (Date) df.parse(((JSONObject) misura).get("data").toString()));
                            }
                            catch (java.text.ParseException e) {
                                e.printStackTrace();
                            }
                            // Aggiungo la misura alle misurazioni dell'utente
                            if (utente instanceof Sedentario)
                                ((Sedentario) utente).inserisciMisurazione(mis);
                            else if (utente instanceof Sportivo)
                                ((Sportivo) utente).inserisciMisurazione(mis);
                            else if (utente instanceof Pesista)
                                ((Pesista) utente).inserisciMisurazione(mis);
                        }
                    }
                    return utente;
                }
            }
        }
        return null;
    }

    /**
     * Rimuove un utente dal DB in memoria
     * 
     * @param id
     */
    public static void rimuoviUtente(String id) {
        JSONArray ja = caricaArray(pathUtenti);
        int indice = 0;
        // Analizza array
        for (int i = 0; i < ja.size(); i++) {
            JSONObject jo = (JSONObject) ja.get(i);
            // Analizza ogni JSONObj
            for (int j = 0; j < jo.size(); j++) {
                if (jo.get("id").equals(id)) {// Utente trovato nel DB
                    indice = j; // Indice dell'utente nell'array
                    break;
                }
            }
        }
        ja.remove(indice); // Rimuovo l'utente dall'array
    }

    /**
     * Converte un oggetto Utente in un JSONObject
     * 
     * @param user
     * @return
     */
    @SuppressWarnings("unchecked")
    public static JSONObject getUtenteObj(Utente user) {
        // Creo il JSONObject relativo all'utente
        JSONObject utenteObj = new JSONObject();
        utenteObj.put("sesso", user.getSesso().get().toString());
        utenteObj.put("peso", user.getPeso().get());
        utenteObj.put("altezza", user.getAltezza().get());
        utenteObj.put("annoNascita", user.getAnnoNascita().get());

        Vector<Misurazione> misure = null;
        if (user instanceof Sedentario) {
            utenteObj.put("tipo", "sed");
            misure = ((Sedentario) user).getMisurazioni();
        }
        else if (user instanceof Sportivo) {
            utenteObj.put("tipo", "sport");
            misure = ((Sportivo) user).getMisurazioni();
        }
        else if (user instanceof Pesista) {
            utenteObj.put("tipo", "pes");
            misure = ((Pesista) user).getMisurazioni();
        }
        // Creo JSONArray misurazioni
        JSONArray misureArray = new JSONArray();
        for (Misurazione misura : misure) {
            JSONObject misuraObj = new JSONObject();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); // Oggetto formattatore di date
            // Creo il JSONObject relativo alla singola misura
            misuraObj.put("data", df.format(misura.getData()));
            misuraObj.put("peso", misura.getPeso());
            misuraObj.put("lbm", misura.getLbm());
            misuraObj.put("bmi", misura.getBmi());
            // Lo aggiungo all'array di JSONObject
            misureArray.add(misuraObj);
        }
        // Lo inserisco nel JSONObject
        utenteObj.put("misurazioni", misureArray);
        return utenteObj;
    }

    /**
     * Salva sul file JSON locale il DB in memoria
     * 
     * @param db
     */
    @SuppressWarnings("unchecked")
    public static void salvaDB(HashMap<String, Utente> db) {

        JSONArray ja = new JSONArray();
        db.forEach((id, utente) -> {
            JSONObject user = new JSONObject();
            user.put("id", id);
            user.put("utente", getUtenteObj(utente));
            ja.add(user);
        });
        salvaJSONArray(pathUtenti, ja);
    }

    /**
     * Restituisce il DB salvato in locale
     * 
     * @return
     */
    public static HashMap<String, Utente> caricaDB() {

        HashMap<String, Utente> db = new HashMap<String, Utente>();
        // Carico il DB in un JSONArray
        JSONArray dbArray = caricaArray(pathUtenti);
        for (Object utente : dbArray) {
            if (utente instanceof JSONObject) {
                String id = (((JSONObject) utente).get("id")).toString();
                Utente user = getUtente(id);
                db.put(id, user);
            }
        }
        return db;
    }

    /**
     * Metodo per salvare un JSONArray in un file locale.
     * 
     * @param nome_file
     * @param ja
     */
    public static void salvaJSONArray(String nome_file, JSONArray ja) {

        try {
            // true = non sovrascive il file
            file = new FileWriter(nome_file, false);
            file.write(ja.toJSONString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                file.flush();
                file.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo che carica l'allenamento dal file e lo restituisce
     * 
     * @param tipo Stile di vita (sed, sport, pes)
     * @param n    variabile generata randomicamente
     * @return String un possibile allenamento
     */
    public static String getAllenamento(String tipo, int n) {

        JSONArray array = caricaArray(pathAllenamenti);

        switch (tipo) {
        case "pes":
            // mi prende allenamenti PESISTA
            JSONObject allenamentiPesista = (JSONObject) array.get(0);
            JSONObject listPes = (JSONObject) allenamentiPesista.get("allenamentiPesista");
            return (String) listPes.get(String.valueOf(n + 1));

        case "sport":
            // mi prende allenamenti SPORTIVO
            JSONObject allenamentiSportivo = (JSONObject) array.get(1);
            JSONObject listSport = (JSONObject) allenamentiSportivo.get("allenamentiSportivo");
            return (String) listSport.get(String.valueOf(n + 1));

        case "sed":
            // mi prende allenamenti SEDENTARIO
            JSONObject allenamentiSedentario = (JSONObject) array.get(2);
            JSONObject listSed = (JSONObject) allenamentiSedentario.get("allenamentiSedentario");
            return (String) listSed.get(String.valueOf(n + 1));

        }
        return null;
    }

    /**
     * Carica una dieta da file e la restituice
     * 
     * @return Lista di pasti
     */
    public static List<Vector<Alimento>> getDieta(int n, int numPasti) {

        List<Vector<Alimento>> pasti = new Vector<Vector<Alimento>>();
        // Aggiunge liste colazione, pranzo, spuntino, cena
        for (int i = 0; i < numPasti; i++)
            pasti.add(new Vector<Alimento>());
        // carica JSONObject da file
        JSONObject dieta = JSONOffline.caricaObj(pathDieta);

        // COLAZIONE
        // Lista colazioni
        JSONObject listCol = (JSONObject) dieta.get("colazioni");
        // Colazione specifica
        JSONArray col = (JSONArray) listCol.get(String.valueOf(n + 1));

        // mette dentro il Vector colazione i vari alimenti del pasto
        getPasto(col, pasti.get(0));

        // PRANZO
        // Lista pranzi
        JSONObject listPra = (JSONObject) dieta.get("pranzi");
        // Pranzo specifico
        JSONArray pra = (JSONArray) listPra.get(String.valueOf(n + 1));

        // mette dentro il Vector pranzo i vari alimenti del pasto
        getPasto(pra, pasti.get(1));

        // SPUNTINO
        // Lista spuntini
        JSONObject listSpu = (JSONObject) dieta.get("spuntino");
        // Spuntino specifico
        JSONArray spu = (JSONArray) listSpu.get(String.valueOf(n + 1));

        // mette dentro il Vector spuntino i vari alimenti del pasto
        getPasto(spu, pasti.get(2));

        // CENA
        // Lista cene
        JSONObject listCena = (JSONObject) dieta.get("cena");
        // Cena specifica
        JSONArray cen = (JSONArray) listCena.get(String.valueOf(n + 1));

        // mette dentro il Vector cena i vari alimenti del pasto
        getPasto(cen, pasti.get(3));

        // Restituisce i pasti generati
        return pasti;
    }

    /**
     * Inserisce l'oggetto Alimento nel Vector(Alimento) del pasto scelto
     * 
     * @param ja JSONArray che contiene il pasto selezionato
     */
    @SuppressWarnings("unused")
    private static void getPasto(JSONArray ja, Vector<Alimento> pasto) {

        for (int i = 0; i < ja.size(); i++) {
            JSONObject jo = (JSONObject) ja.get(i);
            pasto.add(new Alimento((String) jo.get("nome"), ((Long) jo.get("kcal")).intValue(),
                    ((Long) jo.get("qta")).intValue()));
        }
    }

    /**
     * Restituisce il token del bot
     * 
     * @return token
     */
    public static String getBotToken() {
        JSONObject jo = caricaObj(pathConfig);
        JSONObject bot = (JSONObject) jo.get("bot");

        return (String) bot.get("token").toString();
    }

}
