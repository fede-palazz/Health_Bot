package com.project.Health_Bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.project.Health_Bot.dao.UtenteNonRegDao;
import com.project.Health_Bot.dao.UtenteDao;

@Service
public class BotServiceImpl implements BotService {

    @Autowired
    private UtenteDao utenteRegDao;
    @Autowired
    private UtenteNonRegDao utenteNonRegDao;

    @Override
    public void handleUpdate(Update update) {

    }

}
