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
import com.project.Health_Bot.exception.FoodNotFoundException;

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
    public static float BMI_API(float peso, int altezza) throws ParseException, APIResponseException {

        JSONObject jo = (JSONObject) JSONOffline.caricaObj("src/main/resources/config.json").get("bmiAPI");
        String url = jo.get("URL").toString();
        String key = jo.get("key").toString();
        String host = jo.get("host").toString();
        // L'altezza deve essere convertita da cm a m
        float altezzaMetr = (float) altezza / 100;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "weight=" + peso + "&height=" + altezzaMetr)).header("x-rapidapi-key", key)
                .header("x-rapidapi-host", host).method("GET", HttpRequest.BodyPublishers.noBody()).build();
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
        try {
            float bmi = Float.parseFloat(Double.toString((double) obj.get("bmi")));
            // Un modo per troncare a due cifre dopo la virgola...
            return (float) Math.round(bmi * 100) / 100;
        }
        catch (Exception e) {
            return ParamNutr.calcolaBMI(peso, altezza);
        }
    }

    /**
     * 
     * Metodo che chiama l'API del FOOD
     * 
     * @return il JSONObject contente i valori nutrizionali del cibo scelto
     * @throws ParseException
     * @throws APIResponseException
     * @throws FoodNotFoundException 
     */
    public static Vector<Object> FOOD_API(String cibo) throws ParseException, APIResponseException, FoodNotFoundException {

        JSONObject j0 = (JSONObject) JSONOffline.caricaObj("src/main/resources/config.json").get("foodAPI");
        String url = j0.get("URL").toString();
        String key = j0.get("key").toString();
        String host = j0.get("host").toString();

        cibo = cibo.replaceAll(" ", "%20");
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
        // Prende il JSONObjeect esterno
        JSONObject obj = (JSONObject) parser.parse(response.body());
        // Prende il primo array interno
        JSONArray array = (JSONArray) obj.get("items");

        if (array == null || array.isEmpty()) // Cibo inserito non valido
            throw new FoodNotFoundException("Il cibo inserito non è valido");
        // JSONObject contenente i valori nutrizionali
        JSONObject jo = (JSONObject) array.get(0);

        // Casto tutti i valori a Object
        Object name = jo.get("name");
        Object qta = jo.get("serving_size_g"); // Qta in grammi
        Object kcal = jo.get("calories");
        Object protein = jo.get("protein_g");
        Object carbo = jo.get("carbohydrates_total_g");
        Object lipid = jo.get("fat_total_g");

        Vector<Object> nut = new Vector<Object>();
        nut.add(name);
        nut.add(qta);
        nut.add(kcal);
        nut.add(protein);
        nut.add(carbo);
        nut.add(lipid);

        return nut;
    }

}
