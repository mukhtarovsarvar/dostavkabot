package com.controller;

import com.container.CompanyContainer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class OrderController {

    public void hasOrder(User user, Message message, SendMessage sendMessage){
        String text = message.getText();
        if (text.equals("\uD83D\uDECD Buyurtma berish")) {
            StringBuilder builder = new StringBuilder();
            builder.append("<a href=\"https://telegra.ph/Sayrob-Restaurant-Menu-02-19\"");
            builder.append(">Sayrob menyu</a>");
            sendMessage.setText("Tanlang \n" + builder.toString());
            sendMessage.setParseMode("HTML");
            CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
        }else if(text.equals("\uD83D\uDECD Order")){
            StringBuilder builder = new StringBuilder();
            builder.append("<a href=\"https://telegra.ph/Sayrob-Restaurant-Menu-02-19\"");
            builder.append(">Sayrob menu</a>");
            sendMessage.setText("Select \n" + builder.toString());
            sendMessage.setParseMode("HTML");
            CompanyContainer.buttons.foodMenyuEng(sendMessage, user);
        }else if (text.equals("\uD83D\uDECD Заказать")){
            StringBuilder builder = new StringBuilder();
            builder.append("<a href=\"https://telegra.ph/Sayrob-Restaurant-Menu-02-19\"");
            builder.append(">Sayrob меню</a>");
            sendMessage.setText("Выберите \n" + builder.toString());
            sendMessage.setParseMode("HTML");
            CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
        }
    }

}
