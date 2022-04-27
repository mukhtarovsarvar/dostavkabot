package com.delivery;

import com.MyTelegramBot;
import com.container.CompanyContainer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {

    public static void main(String[] args) {

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            MyTelegramBot myTelegramBot = new MyTelegramBot();
            CompanyContainer.MY_TELEGRAM_BOT = myTelegramBot;
            telegramBotsApi.registerBot(myTelegramBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
