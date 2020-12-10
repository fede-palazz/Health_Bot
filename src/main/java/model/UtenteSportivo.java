package model;

public class UtenteSportivo extends Utente {

	private static String utenteSportivo;
	
	//Costruttore.
	public UtenteSportivo(String genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età, stileDiVita);
		this.stileDiVita = utenteSportivo;
	}

}
