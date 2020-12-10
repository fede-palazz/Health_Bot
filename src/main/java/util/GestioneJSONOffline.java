package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GestioneJSONOffline {

    private JSONArray ja = null;
    private JSONObject jo = null;

    public GestioneJSONOffline() {
        this.jo = new JSONObject();
        this.ja = new JSONArray();
    }

    /**
     * Metodo che genera un JSONObject predefinito
     */
    public void creaObjectPredefinito() {
        JSONObject obj = new JSONObject();
        obj.put("name", "foo");
        obj.put("num", new Integer(100));
        obj.put("balance", new Double(1000.21));
        obj.put("is_vip", new Boolean(true));
        obj.put("nickname", null);
        System.out.println("JSONObject predefinito: " + obj);
        this.jo = obj;
    }

    public JSONArray getArray() {
        return ja;
    }

    public void setArray(JSONArray ja) {
        this.ja = ja;
    }

    public JSONObject getObject() {
        return jo;
    }

    public void setObject(JSONObject jo) {
        this.jo = jo;
    }

    /**
     * Inserisco un JSONObject nel mio JSONArray.
     * 
     * @param jo JSONOnject
     */
    public void insertObject(JSONObject jo) {
        this.ja.add(jo);
    }

    /**
     * Metodo per salvare un oggetto serializzabile in un file binario. Posso
     * scegliere se salvare un JSONObject oppure un JSONArray.
     * 
     * @param nome_file Nome del file in cui salvare l'oggetto.
     * @param isObject  Specifica se l'oggetto da salvare � un JSONObject oppure un
     *                  JSONArray.
     */
    public void salvaFile(String nome_file, boolean isObject) {
        try {
            ObjectOutputStream file_output = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(nome_file)));

            if (isObject)
                file_output.writeObject(this.jo);
            else
                file_output.writeObject(this.ja);

            file_output.close();
            System.out.println("File salvato!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo per leggere un oggetto serializzabile da un file binario. Posso
     * scegliere se caricare un JSONObject oppure un JSONArray.
     * 
     * @param nome_file Nome del file da cui leggere l'oggetto.
     * @param isObject  Specifica se l'oggetto da salvare � un JSONObject oppure un
     *                  JSONArray.
     */
    public void caricaFile(String nome_file, boolean isObject) {
        try {
            ObjectInputStream file_input = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(nome_file)));

            if (isObject) {
                this.jo = (JSONObject) file_input.readObject();
                System.out.println("JSONObject letto: " + this.jo);
            }
            else {
                this.ja = (JSONArray) file_input.readObject();
                System.out.println("JSONArray letto: " + this.ja);
                System.out.println("IL JSONArray letto ha " + this.ja.size() + " elementi!");
            }

            file_input.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
