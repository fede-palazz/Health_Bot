package model;

public class UtenteSedentario extends Utente {
	
	private static String utenteSedentario;

	//Costruttore.
	public UtenteSedentario(String genere, int altezza, double peso, int età, String stileDiVita) {
		super(genere, altezza, peso, età, stileDiVita);
		this.stileDiVita = utenteSedentario;
	}

}
