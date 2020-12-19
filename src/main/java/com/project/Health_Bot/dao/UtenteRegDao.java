package com.project.Health_Bot.dao;

public interface UtenteRegDao {

    /**
     * Restituisce "True" se l'utente specificato è già registrato nel sistema
     * Restituisce "False" se l'utente non è registrato nel sistema o lo è parzialmente
     * 
     * @param id
     */
    public boolean isRegistered(String id);
}
