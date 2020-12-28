/**
 * 
 */
package com.project.Health_Bot.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.project.Health_Bot.exception.APIResponseException;

/**
 * Classe che contiene i metodi che gestiscono i file JSON in online
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class JSONOnline {

    /**
     * 
     * Metodo che chiama l'API del BMI
     * 
     * @return valore del BMI
     * @throws ParseException
     * @throws APIResponseException
     */
    public float BMI_API(float peso, int altezza) throws ParseException, APIResponseException {

        JSONOffline.caricaObj("src/main/resources/config.json");
        JSONObject jo = (JSONObject) JSONOffline.caricaObj("src/main/resources/config.json").get("bmiAPI");
        String url = ((JSONObject) jo.get("URL")).toString();
        String key = ((JSONObject) jo.get("key")).toString();
        String host = ((JSONObject) jo.get("host")).toString();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + peso + "&height=" + altezza))
                .header("x-rapidapi-key", key).header("x-rapidapi-host", host)
                .method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response == null) {
                throw new APIResponseException("API_BMI non risponde");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (APIResponseException e) {
            return ParamNutr.calcolaBMI(peso, altezza);
        }

        String risposta = response.body();

        // convertire da JSONString a JSONObject
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(risposta);

        // System.out.println(obj.get("bmi")); //mi da il valore del BMI
        float bmi = (float) obj.get("bmi");
        // Un modo per troncare a due cifre dopo la virgola...
        return (float) Math.round(bmi * 100) / 100;
    }

    /**
     * 
     * Metodo che chiama l'API del FOOD
     * 
     * @return il JSONObject contente i valori nutrizionali del cibo scelto
     * @throws ParseException
     */
    public Vector<Integer> FOOD_API(String cibo) throws ParseException {

        JSONOffline.caricaObj("src/main/resources/config.json");
        JSONObject j0 = (JSONObject) JSONOffline.caricaObj("src/main/resources/config.json").get("foodAPI");
        String url = ((JSONObject) j0.get("URL")).toString();
        String key = ((JSONObject) j0.get("key")).toString();
        String host = ((JSONObject) j0.get("host")).toString();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + cibo)).header("x-rapidapi-key", key)
                .header("x-rapidapi-host", host).method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response == null) {
                throw new APIResponseException("API_FOOD non risponde");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (APIResponseException e) {
            return null;
        }

        JSONParser parser = new JSONParser();
        // il parsing trasforma il dato in long o double
        JSONArray array = (JSONArray) parser.parse(response.body());
        if (array.isEmpty())
            return null;
        JSONObject jo = null;
        if (array.size() >= 4) {
            // prende il quinto JSON Object di un array
            jo = (JSONObject) array.get(4);
        }
        else {
            // prende il quinto JSON Object di un array
            jo = (JSONObject) array.get(0);
        }
        // Casto tutti i valori a Object
        int kcal = (Integer.parseInt(((JSONObject) jo.get("energ_kcal")).toString()));
        int protein = (Integer.parseInt(((JSONObject) jo.get("protein")).toString()));
        int carbo = (Integer.parseInt(((JSONObject) jo.get("carbohydrt")).toString()));
        int lipid = (Integer.parseInt(((JSONObject) jo.get("lipid_tot")).toString()));

        Vector<Integer> nut = new Vector<Integer>();
        nut.add(kcal);
        nut.add(protein);
        nut.add(carbo);
        nut.add(lipid);

        return nut;
    }

}
