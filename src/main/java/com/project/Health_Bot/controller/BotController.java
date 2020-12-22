/**
 * 
 */
package com.project.Health_Bot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.project.Health_Bot.service.BotService;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 * Classe Controller del Bot.
 *
 */
@RestController
public class BotController extends TelegramLongPollingBot {

    @Autowired // Iniezione della dipendenza
    private BotService service;
    private String botUsername; // Bot username
    private String botToken; // Bot token
    
    /**
     * 
     * @param username
     * @throws Exception
     */
    public BotController(String username) throws Exception {
        this.botUsername = username;
        String path = "src/main/resources/application.properties";
        this.botToken = Property.getProp(path, "token"); // Legge il token dal file
        if (botToken.isBlank() || botToken.isEmpty())
            throw new Exception("Il token presente nel file " + path + " non può essere nullo");
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Invocato al ricevimento di un nuovo update (messaggio)
        service.handleUpdate(update);
    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

}
