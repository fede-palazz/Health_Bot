/**
 * 
 */
package com.project.Health_Bot.model;

public class Food {

	protected String cibo;
	protected double energ_kcal;
	protected double protein;
	protected double lipid_tot;
	protected double carbohydrt;
	protected double sugar_tot;
	
	public Food(String cibo, double energ_kcal, double protein, double lipid_tot, double carbohydrt, double sugar_tot) {
		this.cibo = cibo;
		this.energ_kcal = energ_kcal;
		this.protein = protein;
		this.lipid_tot = lipid_tot;
		this.carbohydrt = carbohydrt;
		this.sugar_tot = sugar_tot;
	}

	public String getCibo() {
		return cibo;
	}

	public void setCibo(String cibo) {
		this.cibo = cibo;
	}

	public double getEnerg_kcal() {
		return energ_kcal;
	}

	public void setEnerg_kcal(double energ_kcal) {
		this.energ_kcal = energ_kcal;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getLipid_tot() {
		return lipid_tot;
	}

	public void setLipid_tot(double lipid_tot) {
		this.lipid_tot = lipid_tot;
	}

	public double getCarbohydrt() {
		return carbohydrt;
	}

	public void setCarbohydrt(double carbohydrt) {
		this.carbohydrt = carbohydrt;
	}

	public double getSugar_tot() {
		return sugar_tot;
	}

	public void setSugar_tot(double sugar_tot) {
		this.sugar_tot = sugar_tot;
	}
	
	
	
}
