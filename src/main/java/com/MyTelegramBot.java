package com;

import com.controller.MainController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;

public class MyTelegramBot extends TelegramLongPollingBot {
    private MainController mainController = new MainController();

    @Override
    public String getBotUsername() {
        return "sayrobdeliverybot";
    }

    @Override
    public String getBotToken() {
        return "5212195540:AAEJ3Eh3SOAHj6j3HrVH3FpfWCeAe5CCREU";
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                User user = message.getFrom();
                    if (message.hasText()) {
                        log(user, message.getText());
                        mainController.hasText(user, message);
                    } else if (message.hasLocation()) {
                        mainController.hasLocation(user, message);
                        Location location = message.getLocation();
                        System.out.println(location.getLatitude() +
                                " " + location.getLongitude());
                    } else if (message.hasContact()) {
                        mainController.hasContact(user, message);
                        Contact contact = message.getContact();
                        System.out.println(contact.getPhoneNumber());
                    }
                } else if (update.hasCallbackQuery()) {
                       Message message = update.getCallbackQuery().getMessage();
                    User user = update.getCallbackQuery().getFrom();
                    log(user, update.getCallbackQuery());
                    String data = update.getCallbackQuery().getData();
                    mainController.hasCallbackQuery(user, message, data);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void send(Object object) {
        try {
            if (object instanceof SendMessage) {
                execute((SendMessage) object);
            } else if (object instanceof EditMessageText) {
                execute((EditMessageText) object);
            } else if (object instanceof SendPhoto) {
                execute((SendPhoto) object);
            } else if (object instanceof SendVideo) {
                execute((SendVideo) object);
            } else if (object instanceof SendContact) {
                execute((SendContact) object);
            } else if (object instanceof SendLocation) {
                execute((SendLocation) object);
            }else if(object instanceof DeleteMessage){
                execute((DeleteMessage)object);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void log(User user, String text) {
        String str = String.format(LocalDateTime.now() + ",  userId: %d, firstName: %s, lastName: %s, text: %s",
                user.getId(), user.getFirstName(), user.getLastName(), text);
        System.out.println(str);
    }

    public void log(User user, CallbackQuery text) {
        String str = String.format(LocalDateTime.now() + ",  userId: %d, firstName: %s, lastName: %s, text: %s",
                user.getId(), user.getFirstName(), user.getLastName(), text.getData());
        System.out.println(str);
    }
}
