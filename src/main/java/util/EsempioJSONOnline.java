package util;

import java.util.Scanner;

public class EsempioJSONOnline {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		GestioneJSONOnline ge = new GestioneJSONOnline();
		
		int risp;
		String nome_file;
		String url;
		do {
			System.out.println("\nMENU':");
			System.out.println("1)Scarica un JSONObject tramite API");
			System.out.println("2)Carica un JSONObject da un file di testo .json");
			System.out.println("3)Salva un JSONObject in un file di testo .json");
			System.out.println("4)Scarica un JSONArray tramite API");
			System.out.println("5)Carica un JSONArray da un file di testo .json");
			System.out.println("6)Salva un JSONArray in un file di testo .json");
			System.out.println("0)Esci");
			
			risp = in.nextInt();
			in.nextLine();
			switch(risp) {
			case 1:
				System.out.println("Uso un API del sito jobs.github.com.");
				System.out.println("Scarico informazioni di una particolare offerta di lavoro...");
				url = "https://jobs.github.com/positions/1301c4ee-a659-41c1-9906-45b084b7d639.json"; 
				ge.chiamataAPI(url, true);
				break;
			case 2:
				System.out.println("Inserisci il nome del file:");
				nome_file = in.nextLine();
				ge.caricaFile(nome_file, true);
				break;
			case 3:
				System.out.println("Inserisci il nome del file:");
				nome_file = in.nextLine();
				ge.salvaFile(nome_file, true);
				break;
			case 4:
				System.out.println("Uso un API del sito jobs.github.com.");
				System.out.println("Cerco offerte di lavoro a San Francisco, che richiedono il linguaggio Phyton...");
				url = "https://jobs.github.com/positions.json?description=python&location=sf"; 
				ge.chiamataAPI(url, false);
				break;
			case 5:
				System.out.println("Inserisci il nome del file:");
				nome_file = in.nextLine();
				ge.caricaFile(nome_file, false);
				break;
			case 6:
				System.out.println("Inserisci il nome del file:");
				nome_file = in.nextLine();
				ge.salvaFile(nome_file, false);
				break;
			case 0:
				
				break;
			}
			
		}while(risp>0);

	}

}
