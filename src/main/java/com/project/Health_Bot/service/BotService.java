/**
 * 
 */
package com.project.Health_Bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Interfaccia contenente i metodi che gestiscono la logica di business dell'applicazione.
 *
 */
public interface BotService {

    /**
     * Ricostruisce lo stato dell'applicazione in base alla richiesta dell'utente
     * 
     * @param update
     */
    public SendMessage gestisciUpdate(Update update);

    public SendMessage gestisciReg(Message mess, String userId);

    public SendMessage gestisciMenu(Message mess, String userId);

}
