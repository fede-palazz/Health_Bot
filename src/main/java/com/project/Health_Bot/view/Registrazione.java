/**
 * 
 */
package com.project.Health_Bot.view;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;

/**
 * @author FedePalaz & GiovanniNovelli9 & Baldellaux
 * 
 * Classe che modella la fase di registrazione del'utente.
 * 
 */
public class Registrazione {
	
	String chatId;
	Object messageId;

	/**
	 * Metodo che chiede all'utente il genere
	 * 
	 * @return
	 */
    public SendMessage getVistaSesso() {
		return null;
		
	}
	
    /**
     * Metodo che chiede all'utente il peso
     * 
     * @return
     */
    public SendMessage getVistaPeso() {
		return null;
		
	}
    
    /**
     * Metodo che chiede all'utente l'altezza
     * 
     * @return
     */
    public SendMessage getVistaAltezza() {
		return null;
		
	}
    
    /**
     * Metodo che chiede all'utente la sua data di nascita
     * 
     * @return
     */
    public SendMessage getVistaAnno() {
		return null;
		
	}
    
    /**
     * 
     * @param chatId
     * @param messageId
     * @return
     */
    public EditMessageReplyMarkup eliminaKeyboard (String chatId , int messageId ) {
		EditMessageReplyMarkup editMessage = new EditMessageReplyMarkup();
	    editMessage.setChatId(chatId);
		editMessage.setMessageId(messageId);
		editMessage.setReplyMarkup(null);
    	return editMessage;
    }
    
	
}
