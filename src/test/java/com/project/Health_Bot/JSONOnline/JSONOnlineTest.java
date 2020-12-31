package com.project.Health_Bot.JSONOnline;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Vector;

import org.json.simple.parser.ParseException;

import com.project.Health_Bot.exception.APIResponseException;
import com.project.Health_Bot.exception.FoodNotFoundException;
import com.project.Health_Bot.util.JSONOnline;
import org.junit.jupiter.api.*;

public class JSONOnlineTest {
	private float peso;
	private int altezza;
	private float bmi;
	private String cibo;

	/**
	 * Inizializza i componenti necessari a testare i metodi.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		peso = 80;
		altezza = 180;
		cibo = "apple";
	}

	/**
	 * Serve per distruggere ciò che è stato inizializzato dal metodo setUp. throws
	 * java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * metodi da testare
	 */
	@Test
	@DisplayName("Valore corretto BMI")
	public void testToBmiAPI() throws ParseException, APIResponseException {
		bmi = JSONOnline.BMI_API(peso, altezza);
		assertEquals("" + bmi, "24.69");
	}

	@Test
	@DisplayName("Vettore restituito da FOOD_API è non nullo")
	public void testToFoodAPI() throws ParseException, APIResponseException, FoodNotFoundException {
		Vector<Object> nutrienti = JSONOnline.FOOD_API(cibo);
		assertNotNull(nutrienti);
	}
	
	//TODO test eccezioni
	
}
