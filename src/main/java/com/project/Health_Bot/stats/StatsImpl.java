package com.project.Health_Bot.stats;

import java.util.Vector;

import com.project.Health_Bot.model.Misurazione;
import com.project.Health_Bot.model.Pesista;
import com.project.Health_Bot.model.Sedentario;
import com.project.Health_Bot.model.Sportivo;
import com.project.Health_Bot.model.Utente;

public class StatsImpl implements Stats {

	public Vector<Float> percTipo(Vector<Utente> utenti) {
		int[] cont = new int[3];
		for (int i = 0; i < cont.length; i++)
			cont[i] = 0;
		for (Utente utente : utenti) {
			if (utente instanceof Sedentario)
				cont[0]++;
			else if (utente instanceof Sportivo)
				cont[1]++;
			else if (utente instanceof Pesista)
				cont[2]++;
		}
		int utentiTot = cont[0] + cont[1] + cont[2];
		Vector<Float> perc = new Vector<Float>();
		// percentuale utenti sedentari
		perc.add((float) (cont[0] * 100 / utentiTot));
		// percentuale utenti sportivi
		perc.add((float) (cont[1] * 100 / utentiTot));
		// percentuale utenti pesisti
		perc.add((float) (cont[2] * 100 / utentiTot));
		return perc;
	}

	public float percTipo(String tipo, Vector<Utente> user) {

		switch(tipo) {
		case "sed":
			break;
		case "sport":
			break;
		case "pes":
			break;
		}
		return 0;
	}

	public Vector<Float> percGenere(Vector<Utente> utenti) {
		int[] cont = new int[2];
		for (int i = 0; i < cont.length; i++)
			cont[i] = 0;
		for (Utente utente : utenti) {
			if (utente instanceof Maschio)
				cont[0]++;
			else if (utente instanceof Sportivo)
				cont[1]++;

		}
		int utentiTot = cont[0] + cont[1];
		Vector<Float> perc = new Vector<Float>();
		// percentuale utenti maschi
		perc.add((float) (cont[0] * 100 / utentiTot));
		// percentuale utenti femmine
		perc.add((float) (cont[1] * 100 / utentiTot));

		return perc;

	}

	public float percGenere(char gender, Vector<Utente> user) {
		return 0;

	}

	public Vector<Float> percRangeEta(Vector<Utente> user) {
		return null;

	}

	public float percRangeEta(int eta, Vector<Utente> user) {
		return 0;

	}

	public Vector<Float> percCondizioni(Vector<Utente> user) {
		return null;

	}

	public float percCondizioni(String condizione, Vector<Utente> user) {
		return 0;

	}

	public Vector<Float> varazioneParam(Vector<Misurazione> mis) {
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
