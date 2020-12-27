/**
 * 
 */
package com.project.Health_Bot.service;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Interfaccia contenente i metodi che gestiscono la logica di business dell'applicazione.
 *
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
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
     * @param chatId
     * @return
     */
    public SendMessage gestisciReg(String mess, String userId, long chatId);

    /**
     * Gestisce la navigazione attraverso il menù principale del bot
     * 
     * @param mess
     * @param userId
     * @param chatId
     * @return
     */
    public SendMessage gestisciMenu(String mess, String userId, long chatId);

    public String Welcome();

}
