/**
 * 
 */
package com.project.Health_Bot.JSONOnline;

import java.util.Vector;

import org.json.simple.parser.ParseException;

import com.project.Health_Bot.exception.APIResponseException;
import com.project.Health_Bot.util.JSONOnline;

import junit.framework.*;

/**
 * 
 * Classe che contiene i metodi che gestiscono i file JSON in online
 * 
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 */
public class JSONOnlineTest extends TestCase{
	
	private float peso;
	private int altezza;
	private float bmi;
	private String cibo;

	public JSONOnlineTest(String name) {
		super(name);
	}

	// inserisci i metodi da testare
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new JSONOnlineTest("testToBmiAPI"));
		suite.addTest(new JSONOnlineTest("testToFoodAPI"));
		return suite;
	}

	// setUp delle variabili
	public void setUp() {
		peso = 80;
		altezza = 180;
		cibo = "apple";
	}

	public void tearDown() {
	}

	// elenco metodi
	public void testToBmiAPI() throws ParseException, APIResponseException {
		bmi = JSONOnline.BMI_API(peso, altezza);
		assertEquals("" + bmi, "24.69");
	}

	public void testToFoodAPI() throws ParseException, APIResponseException {
		Vector<Object> nutrienti = JSONOnline.FOOD_API(cibo);
		assertNotNull(nutrienti);
	}
	
}

