
package com.project.Health_Bot.service;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Interfaccia contenente i metodi che gestiscono la logica di business dell'applicazione.
 *
 */
public interface BotService {

    /**
     * Ricostruisce lo stato dell'applicazione in base alla richiesta dell'utente
     * 
     * @param update
     *
     */
    public SendMessage gestisciUpdate(Update update);

    /**
     * Gestisce la fase di registrazione di un nuovo utente
     * 
     * @param mess
     * @param userId
     * @return
     */
    public SendMessage gestisciReg(Message mess, String userId);

    /**
     * Gestisce la navigazione attraverso il menù principale del bot
     * 
     * @param mess
     * @param userId
     * @return
     */
    public SendMessage gestisciMenu(Message mess, String userId);

    public String Welcome();

}
