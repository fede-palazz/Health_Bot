package com.project.Health_Bot.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotController extends TelegramLongPollingBot {

    private String botUsername; // Bot username
    private String token; // Bot token

    public BotController(String username) throws Exception {
        this.botUsername = username;
        String path = "src/main/resources/application.properties";
        this.token = Property.getProp(path, "token"); // Legge il token dal file
        if (token.isBlank() || token.isEmpty())
            throw new Exception("Il token presente nel file " + path + " non può essere nullo");
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
