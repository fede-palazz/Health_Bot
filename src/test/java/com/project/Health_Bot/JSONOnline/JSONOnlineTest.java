package com.project.Health_Bot.JSONOnline;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.project.Health_Bot.exception.APIResponseException;
import com.project.Health_Bot.exception.FoodNotFoundException;
import com.project.Health_Bot.model.AlimentoInfo;
import com.project.Health_Bot.util.JSONOnline;

public class JSONOnlineTest {
    private float peso;
    private int altezza;
    private float bmi;
    private String cibo_corretto;
    private String cibo_sbagliato;

    /**
     * Inizializza i componenti necessari a testare i metodi.
     * 
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        peso = 80;
        altezza = 180;
        cibo_corretto = "apple";
        cibo_sbagliato = "penguin";
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
        AlimentoInfo nutrienti = JSONOnline.FOOD_API(cibo_corretto);
        assertNotNull(nutrienti);
    }

    @Test
    @DisplayName("Corretta generazione dell'eccezione FoodNotFoundException")
    void testFoodNotFoundException() {

        FoodNotFoundException e = assertThrows(FoodNotFoundException.class, () -> {
            JSONOnline.FOOD_API(cibo_sbagliato);
        });

        assertEquals("Il cibo inserito non è valido", e.getMessage());
    }

}
