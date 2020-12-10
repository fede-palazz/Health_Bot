package model;
/*
 * questa classe è astratta poichè deve modellare 3 possibili stili di vita.
 * per ogni stile di vita ho dei metodi in comune ma diversi tra loro -> uso abstract 
 * 
 */
public abstract class Utente {

	protected String genere;
	protected int altezza; // aletzza in cm
	protected double peso; // peso in Kg
	protected int età; 
	protected String stileDiVita;
	
	// Costruttore.
	public Utente(String genere, int altezza, double peso, int età, String stileDiVita) {
		this.genere = genere;
		this.altezza = altezza;
		this.peso = peso;
		this.età = età;
		this.stileDiVita = stileDiVita;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEtà() {
		return età;
	}

	public void setEtà(int età) {
		this.età = età;
	}

	public String getStileDiVita() {
		return stileDiVita;
	}

	public void setStileDiVita(String stileDiVita) {
		this.stileDiVita = stileDiVita;
	}
	
	
	
	
	
}
