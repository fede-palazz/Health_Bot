package com.project.Health_Bot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.project.Health_Bot.model.Utente;
import com.project.Health_Bot.util.JSONOffline;

import org.junit.jupiter.api.*;

/**
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class JSONOfflineTest {

	private String id;
	private Utente utente;
	private String tipo;
	private int num_all;

	/**
	 * Inizializza i componenti necessari a testare i metodi.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		id = "1234";
		tipo = "sed";
		num_all = 1;
	}

	/**
	 * Serve per distruggere ciò che è stato inizializzato dal metodo setUp.
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * metodi da testare
	 */
	@Test
	@DisplayName("Verifica se Utente è registrato")
	public void tesIsRegistered() {
		boolean reg = JSONOffline.isRegistered(id);
		assertFalse(reg);
	}

	@Test
	@DisplayName("Verifica se Utente è nullo")
	public void testGetUtente() {
		utente = JSONOffline.getUtente(id);
		assertNull(utente);
	}

	@Test
	@DisplayName("Verifica se l'allenamento restituito non è nullo")
	public void testGetAllenamento() {
		String allenamento = JSONOffline.getAllenamento(tipo, num_all);
		assertNotNull(allenamento);
	}
}
