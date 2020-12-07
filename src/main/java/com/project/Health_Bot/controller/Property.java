package com.project.Health_Bot.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {

    public static String getProp(String path, String key) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(path);
            // Crea un oggetto di tipo Properties
            prop = new Properties();
            // Carica in esso le proprietà
            prop.load(fis);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fis.close();
        }
        return prop.getProperty(key);
    }

}
