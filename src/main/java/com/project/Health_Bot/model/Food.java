package com.project.Health_Bot.model;

public class Food {

	protected String cibo;
	protected double Kcal;
	protected double proteine;
	protected double lipidi;
	protected double carboidrati;
	protected double zuccheri;
	
	public Food(double kcal, double proteine, double lipidi, double carboidrati, double zuccheri) {
		this.Kcal = kcal;
		this.proteine = proteine;
		this.lipidi = lipidi;
		this.carboidrati = carboidrati;
		this.zuccheri = zuccheri;
	}

	public double getKcal() {
		return Kcal;
	}

	public void setKcal(double kcal) {
		Kcal = kcal;
	}

	public double getProteine() {
		return proteine;
	}

	public void setProteine(double proteine) {
		this.proteine = proteine;
	}

	public double getLipidi() {
		return lipidi;
	}

	public void setLipidi(double lipidi) {
		this.lipidi = lipidi;
	}

	public double getCarboidrati() {
		return carboidrati;
	}

	public void setCarboidrati(double carboidrati) {
		this.carboidrati = carboidrati;
	}

	public double getZuccheri() {
		return zuccheri;
	}

	public void setZuccheri(double zuccheri) {
		this.zuccheri = zuccheri;
	}
		
}
