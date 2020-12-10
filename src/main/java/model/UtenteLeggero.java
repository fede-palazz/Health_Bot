package model;

public class UtenteLeggero extends Utente {

	private static String utenteLeggero;
	
	//Costruttore.
	public UtenteLeggero(String genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età, stileDiVita);
		this.stileDiVita = utenteLeggero;
	}

}
