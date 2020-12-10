package util;

import java.util.Scanner;

public class EsempioJSONOffline {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        GestioneJSONOffline ge = new GestioneJSONOffline();

        System.out.println("Genero un JSONObject predefinito:");
        ge.creaObjectPredefinito();

        System.out.println("\nGenero un JSONArray aggiungendo 3 volte il JSONObject predefinito:");
        ge.insertObject(ge.getObject());
        ge.insertObject(ge.getObject());
        ge.insertObject(ge.getObject());
        System.out.println("Il JSONArray creato ha " + ge.getArray().size() + " elementi.");
        System.out.println("JSONArray: " + ge.getArray());

        int risp;
        String nome_file;
        do {
            System.out.println("\nMENU':");
            System.out.println("1)Carica un JSONObject da un file");
            System.out.println("2)Salva un JSONObject in un file");
            System.out.println("3)Carica un JSONArray da un file");
            System.out.println("4)Salva un JSONArray in un file");
            System.out.println("0)Esci");

            risp = in.nextInt();
            in.nextLine();
            switch (risp) {
            case 1:
                System.out.println("Inserisci il nome del file:");
                nome_file = in.nextLine();
                ge.caricaFile(nome_file, true);
                break;
            case 2:
                System.out.println("Inserisci il nome del file:");
                nome_file = in.nextLine();
                ge.salvaFile(nome_file, true);
                break;
            case 3:
                System.out.println("Inserisci il nome del file:");
                nome_file = in.nextLine();
                ge.caricaFile(nome_file, false);
                break;
            case 4:
                System.out.println("Inserisci il nome del file:");
                nome_file = in.nextLine();
                ge.salvaFile(nome_file, false);
                break;
            case 0:

                break;
            }

        } while (risp > 0);
        in.close();
    }

}
