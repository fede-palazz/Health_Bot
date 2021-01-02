/**
 * 
 */
package com.project.Health_Bot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.project.Health_Bot.exception.InvalidUpdateException;
import com.project.Health_Bot.filter.GestoreFiltri;
import com.project.Health_Bot.service.BotService;
import com.project.Health_Bot.util.JSONOffline;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 *         Classe Controller del Bot
 *
 */
@RestController
public class BotController {

    @Autowired
    private BotService service;
    private TelegramBot bot;
    private String botToken;

    /**
     * Costruttore
     */
    public BotController() {
        botToken = JSONOffline.getBotToken();
        bot = new TelegramBot(botToken);
        riceviUpdate();
    }

    /**
     * Imposta un Listener per ricevere gli update in arrivo da Telegram
     */
    private void riceviUpdate() {
        bot.setUpdatesListener(new UpdatesListener() {

            @Override
            public int process(List<Update> updates) {
                for (Update update : updates) {
                    try {
                        // Per ogni update riceve ed invia la lista dei messaggi di risposta
                        for (SendMessage message : service.gestisciUpdate(update))
                            if (message != null)
                                bot.execute(message);
                    }
                    catch (InvalidUpdateException e) {
                        e.printStackTrace();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    //SendResponse response = bot.execute(message);
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL; // Conferma tutti gli updates ricevuti
            }
        });
    }

    @PostMapping
    public String getStat(@RequestBody GestoreFiltri gest) {

        return "";

    }

}
