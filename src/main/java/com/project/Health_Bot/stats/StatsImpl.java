package com.project.Health_Bot.stats;

import java.util.Vector;

import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Utente;

public class StatsImpl implements Stats{

	public Vector<Float> percTipo(Vector<Utente> user) {

		return null;
	}

	public float percTipo(String tipo, Vector<Utente> user) {

		return 0;
	}

	public Vector<Float> percGenere(Vector<Utente> user) {
		return null;

	}

	public float percGenere(char gender, Vector<Utente> user) {
		return 0;

	}

	public Vector<Float> percRangeEta(Vector<Utente> user){
		return null;
		
	}

	public float percRangeEta(int eta, Vector<Utente> user) {
		return 0;
		
	}

	public Vector<Float> percCondizioni(Vector<Utente> user){
		return null;
		
	}

	public float percCondizioni(String condizione, Vector<Utente> user) {
		return 0;
		
	}

	public Vector<Float> varazioneParam(Vector<Misurazione> mis){
		return null;
		
	}

	public float numeroUltimeMis(Vector<Misurazione> mis) {
		return 0;
		
	}

	public Misurazione paramMax(Vector<Misurazione> mis) {
		return null;
		
	}

	public Misurazione paramMin(Vector<Misurazione> mis) {
		return null;
		
	}

	public float paramMedia(Vector<Misurazione> mis) {
		return 0;
		
	}
}
