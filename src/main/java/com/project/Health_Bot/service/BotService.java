/**
 * 
 */
package com.project.Health_Bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 *
 * Interfaccia contenente metodi che rappresentano 
 * la logica di business dell'applicazione.
 *
 */
public interface BotService {

    /**
     * Ricostruisce lo stato dell'applicazione in base alla richiesta dell'utente
     * 
     * @param update
     */
    public void gestisciUpdate(Update update);

    public void gestisciReg();

}
