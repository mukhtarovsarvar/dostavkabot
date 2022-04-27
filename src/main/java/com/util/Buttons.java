package com.util;

import com.container.CompanyContainer;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Buttons {

    public void keybordNumber(SendMessage sendMessage) {
        ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        for (int i = 1; i < 10; i++) {
            row.add(Integer.valueOf(i).toString());
            if (i % 3 == 0) {
                keyboard.add(row);
                row = new KeyboardRow();
            }
        }

        String but4 = EmojiParser.parseToUnicode("⬅ Orqaga");
        String but5 = EmojiParser.parseToUnicode("🛒 Savatcha");
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button4);
        row1.add(button5);
        keyboard.add(row1);
        keyBoardMarkup.setKeyboard(keyboard);
        keyBoardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(keyBoardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void keybordLanguage(SendMessage sendMessage, User user) {

        String eng = EmojiParser.parseToUnicode(":us:" + " " + "English");
        String ru = EmojiParser.parseToUnicode(":ru:" + " " + "Русский");
        String uz = EmojiParser.parseToUnicode(":uz:" + " " + "O'zbekcha");
        KeyboardButton button = new KeyboardButton(eng);
        KeyboardButton button1 = new KeyboardButton(uz);
        KeyboardButton button2 = new KeyboardButton(ru);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button);
        row1.add(button1);
        row1.add(button2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1));
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);

    }

    public void ChooseCityUz(SendMessage sendMessage, User user) {

        KeyboardButton button1 = new KeyboardButton("Toshkent");
        KeyboardButton button2 = new KeyboardButton("Andijon");
        KeyboardButton button3 = new KeyboardButton("Termiz");
        KeyboardButton button4 = new KeyboardButton("Samarqand");
        KeyboardButton button5 = new KeyboardButton("Buxoro");
        KeyboardButton button6 = new KeyboardButton("Xorazm");

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));

        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);

    }

    public void ChooseCityEn(SendMessage sendMessage, User user) {
        KeyboardButton button1 = new KeyboardButton("Tashkent");
        KeyboardButton button2 = new KeyboardButton("Andijan");
        KeyboardButton button3 = new KeyboardButton("Termez");
        KeyboardButton button4 = new KeyboardButton("Samarkand");
        KeyboardButton button5 = new KeyboardButton("Bukhara");
        KeyboardButton button6 = new KeyboardButton("Khorezm");
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void ChooseCityRu(SendMessage sendMessage, User user) {
        KeyboardButton button1 = new KeyboardButton("Ташкент");
        KeyboardButton button2 = new KeyboardButton("Андижан");
        KeyboardButton button3 = new KeyboardButton("Термез");
        KeyboardButton button4 = new KeyboardButton("Самарканд");
        KeyboardButton button5 = new KeyboardButton("Бухара");
        KeyboardButton button6 = new KeyboardButton("Хоразм");
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void Menyukeyboard(SendMessage sendMessage, User user) {

        String but1 = EmojiParser.parseToUnicode(":shopping_bags:" + " " + "Buyurtma berish");
        String but2 = EmojiParser.parseToUnicode("🛒 Savatcha");
        //  String but3 = EmojiParser.parseToUnicode(":money_with_wings:" + " " + "Keshbek");
        String but4 = EmojiParser.parseToUnicode(":gear:" + " " + "Sozlash" + " " + ":information_source:" + " " + "Ma'lumotlar");
        // String but5 = EmojiParser.parseToUnicode(":fire:" + " " + "Aksiya");
        String but6 = EmojiParser.parseToUnicode(":telephone:" + " " + "Sayrob bilan aloqa ");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        //  KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        //   KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button4);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button6);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void MenyukeyboardRus(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":shopping_bags:" + " " + "Заказать");
        String but4 = EmojiParser.parseToUnicode(":gear:" + " " + "Настройки" + " " + ":information_source:" + " " + "Информация");
        String but5 = EmojiParser.parseToUnicode("🛒 Корзинка");
        String but6 = EmojiParser.parseToUnicode(":telephone:" + " " + "Обратная связь");
        KeyboardButton button1 = new KeyboardButton(but1);

        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(button4);
        row3.add(button5);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button6);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row3, row4));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void MenyukeyboardEng(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":shopping_bags:" + " " + "Order");
        String but2 = EmojiParser.parseToUnicode(":book:" + " " + "My orders");
        String but3 = EmojiParser.parseToUnicode(":money_with_wings:" + " " + "Cashback");
        String but4 = EmojiParser.parseToUnicode(":gear:" + " " + "Settings" + " " + ":information_source:" + " " + "Information");
        String but5 = EmojiParser.parseToUnicode(":fire:" + " " + "Promotion");
        String but6 = EmojiParser.parseToUnicode(":telephone:" + " " + "Feedback");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button2);
        row2.add(button3);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button4);
        row3.add(button5);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button6);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void foodMenyuUz(SendMessage sendMessage, User user) {

        String but1 = EmojiParser.parseToUnicode("⬅ Orqaga");
        String but2 = EmojiParser.parseToUnicode("🛒 Savatcha");
        String but3 = EmojiParser.parseToUnicode(":stew:" + " " + "Birinchi taomlar");
        String but4 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Ikkinchi taomlar");
        String but5 = EmojiParser.parseToUnicode(":oden:" + " " + "Shashliklar");
        String but6 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Salatlar");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);

    }

    public void foodMenyuRus(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode("⬅ Назад");
        String but2 = EmojiParser.parseToUnicode(":shopping_trolley:" + " " + "Корзинка");
        String but3 = EmojiParser.parseToUnicode(":stew:" + " " + "Первые блюда");
        String but4 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Вторые бляда");
        String but5 = EmojiParser.parseToUnicode(":oden:" + " " + "Шашликы");
        String but6 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Салаты");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void foodMenyuEng(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode("⬅ Back");
        String but2 = EmojiParser.parseToUnicode(":shopping_trolley:" + " " + "Basket");
        String but3 = EmojiParser.parseToUnicode(":stew:" + " " + "First meals");
        String but4 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Second meals");
        String but5 = EmojiParser.parseToUnicode(":oden:" + " " + "Shashlik");
        String but6 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Salads");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button3);
        row2.add(button4);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button5);
        row3.add(button6);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void firstFoodMenuRu(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":stew:" + " " + "Ko'za sho'rva");
        String but2 = EmojiParser.parseToUnicode(":stew:" + " " + "Biqtirma sho'rva");
        String but3 = EmojiParser.parseToUnicode(":stew:" + " " + "Bostirma sho'rva");
        String but4 = EmojiParser.parseToUnicode("⬅ Назад");
        String but5 = EmojiParser.parseToUnicode("🛒 Корзинка");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void firstFoodMenuUz(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":stew:" + " " + "Ko'za sho'rva");
        String but2 = EmojiParser.parseToUnicode(":stew:" + " " + "Biqtirma sho'rva");
        String but3 = EmojiParser.parseToUnicode(":stew:" + " " + "Bostirma sho'rva");
        String but4 = EmojiParser.parseToUnicode("⬅ Orqaga");
        String but5 = EmojiParser.parseToUnicode("🛒 Savatcha");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void secondFoodMenuUz(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Jo'ja cho'poncha");
        String but2 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Jo'ja chaxoxbili");
        String but3 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Cho'poncha");
        String but4 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Qovurg'a cho'poncha");
        String but5 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Yumshoq go'sht");
        String but6 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Qo'y g. chaxoxbili");
        String but7 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Jigar chaxoxbili");
        String but8 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Kurka go'sht");
        String but9 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Kurka chaxoxbili");
        String but10 = EmojiParser.parseToUnicode(":fries:" + " " + "Kartoshka fri");
        String but11 = EmojiParser.parseToUnicode("⬅ Orqaga");
        String but12 = EmojiParser.parseToUnicode("🛒 Savatcha");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardButton button7 = new KeyboardButton(but7);
        KeyboardButton button8 = new KeyboardButton(but8);
        KeyboardButton button9 = new KeyboardButton(but9);
        KeyboardButton button10 = new KeyboardButton(but10);
        KeyboardButton button11 = new KeyboardButton(but11);
        KeyboardButton button12 = new KeyboardButton(but12);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button7);
        row3.add(button8);
        row3.add(button9);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button10);
        KeyboardRow row5 = new KeyboardRow();
        row5.add(button11);
        row5.add(button12);


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4, row5));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void secondFoodMenuRu(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Jo'ja cho'poncha");
        String but2 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Jo'ja chaxoxbili");
        String but3 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Cho'poncha");
        String but4 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Qovurg'a cho'poncha");
        String but5 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Yumshoq go'sht");
        String but6 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Qo'y g. chaxoxbili");
        String but7 = EmojiParser.parseToUnicode(":meat_on_bone:" + " " + "Jigar chaxoxbili");
        String but8 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Kurka go'sht");
        String but9 = EmojiParser.parseToUnicode(":poultry_leg:" + " " + "Kurka chaxoxbili");
        String but10 = EmojiParser.parseToUnicode(":fries:" + " " + "Kartoshka fri");
        String but11 = EmojiParser.parseToUnicode("⬅ Назад");
        String but12 = EmojiParser.parseToUnicode("🛒 Корзинка");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardButton button7 = new KeyboardButton(but7);
        KeyboardButton button8 = new KeyboardButton(but8);
        KeyboardButton button9 = new KeyboardButton(but9);
        KeyboardButton button10 = new KeyboardButton(but10);
        KeyboardButton button11 = new KeyboardButton(but11);
        KeyboardButton button12 = new KeyboardButton(but12);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button7);
        row3.add(button8);
        row3.add(button9);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button10);
        KeyboardRow row5 = new KeyboardRow();
        row5.add(button11);
        row5.add(button12);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4, row5));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void shashlikFoodMenuUz(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":oden:" + " " + "Qiyma shashlik");
        String but2 = EmojiParser.parseToUnicode(":oden:" + " " + "Barbekyu shashlik");
        String but3 = EmojiParser.parseToUnicode(":oden:" + " " + "Dumba shashlik");
        String but4 = EmojiParser.parseToUnicode(":oden:" + " " + "O'rama shashlik");
        String but5 = EmojiParser.parseToUnicode(":oden:" + " " + "Kuskovoy mol g. shashlik");
        String but6 = EmojiParser.parseToUnicode(":oden:" + " " + "Kuskovoy qo'y g. shashlik");
        String but7 = EmojiParser.parseToUnicode(":oden:" + " " + "Jigar shashlik shashlik");
        String but8 = EmojiParser.parseToUnicode("⬅ Orqaga");
        String but9 = EmojiParser.parseToUnicode("🛒 Savatcha");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardButton button7 = new KeyboardButton(but7);
        KeyboardButton button8 = new KeyboardButton(but8);
        KeyboardButton button9 = new KeyboardButton(but9);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button7);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button8);
        row4.add(button9);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void shashlikFoodMenuRu(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":oden:" + " " + "Qiyma shashlik");
        String but2 = EmojiParser.parseToUnicode(":oden:" + " " + "Barbekyu shashlik");
        String but3 = EmojiParser.parseToUnicode(":oden:" + " " + "Dumba shashlik");
        String but4 = EmojiParser.parseToUnicode(":oden:" + " " + "O'rama shashlik");
        String but5 = EmojiParser.parseToUnicode(":oden:" + " " + "Kuskovoy mol g. shashlik");
        String but6 = EmojiParser.parseToUnicode(":oden:" + " " + "Kuskovoy qo'y g. shashlik");
        String but7 = EmojiParser.parseToUnicode(":oden:" + " " + "Jigar shashlik shashlik");
        String but8 = EmojiParser.parseToUnicode("⬅ Назад");
        String but9 = EmojiParser.parseToUnicode("🛒 Корзинка");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardButton button7 = new KeyboardButton(but7);
        KeyboardButton button8 = new KeyboardButton(but8);
        KeyboardButton button9 = new KeyboardButton(but9);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button7);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button8);
        row4.add(button9);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void saladFoodMenuUz(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Smak");
        String but2 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Grecheskiy salat");
        String but3 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Jenskiy kapriz");
        String but4 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Barf");
        String but5 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Yaponskiy salat");
        String but6 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Sezar salat");
        String but7 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Nejniy salat");
        String but8 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Chafani");
        String but9 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Mujskoy kapriz");
        String but10 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Appetit");
        String but11 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Rakford");
        String but12 = EmojiParser.parseToUnicode("⬅ Orqaga");
        String but13 = EmojiParser.parseToUnicode("🛒 Savatcha");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardButton button7 = new KeyboardButton(but7);
        KeyboardButton button8 = new KeyboardButton(but8);
        KeyboardButton button9 = new KeyboardButton(but9);
        KeyboardButton button10 = new KeyboardButton(but10);
        KeyboardButton button11 = new KeyboardButton(but11);
        KeyboardButton button12 = new KeyboardButton(but12);
        KeyboardButton button13 = new KeyboardButton(but13);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button7);
        row3.add(button8);
        row3.add(button9);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button10);
        row4.add(button11);
        KeyboardRow row5 = new KeyboardRow();
        row5.add(button12);
        row5.add(button13);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4, row5));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void saladFoodMenuRu(SendMessage sendMessage, User user) {
        String but1 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Smak");
        String but2 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Grecheskiy salat");
        String but3 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Jenskiy kapriz");
        String but4 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Barf");
        String but5 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Yaponskiy salat");
        String but6 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Sezar salat");
        String but7 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Nejniy salat");
        String but8 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Chafani");
        String but9 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Mujskoy kapriz");
        String but10 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Appetit");
        String but11 = EmojiParser.parseToUnicode(":green_salad:" + " " + "Rakford");
        String but12 = EmojiParser.parseToUnicode("⬅ Назад");
        String but13 = EmojiParser.parseToUnicode("🛒 Корзинка");
        KeyboardButton button1 = new KeyboardButton(but1);
        KeyboardButton button2 = new KeyboardButton(but2);
        KeyboardButton button3 = new KeyboardButton(but3);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardButton button6 = new KeyboardButton(but6);
        KeyboardButton button7 = new KeyboardButton(but7);
        KeyboardButton button8 = new KeyboardButton(but8);
        KeyboardButton button9 = new KeyboardButton(but9);
        KeyboardButton button10 = new KeyboardButton(but10);
        KeyboardButton button11 = new KeyboardButton(but11);
        KeyboardButton button12 = new KeyboardButton(but12);
        KeyboardButton button13 = new KeyboardButton(but13);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(button7);
        row3.add(button8);
        row3.add(button9);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(button10);
        row4.add(button11);
        KeyboardRow row5 = new KeyboardRow();
        row5.add(button12);
        row5.add(button13);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2, row3, row4, row5));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void deleteOrder(SendMessage sendMessage, Message message, List<String> foodNameList) {
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        for (String s : foodNameList) {
            List<InlineKeyboardButton> row1 = new LinkedList<>();
            InlineKeyboardButton button1 = new InlineKeyboardButton();
            button1.setText(s);
            button1.setCallbackData(s);
            InlineKeyboardButton button2 = new InlineKeyboardButton();
            button2.setText(" ➕ ");
            button2.setCallbackData("plus_" + s);
            InlineKeyboardButton button3 = new InlineKeyboardButton();
            button3.setText(" ➖ ");
            button3.setCallbackData("minus_" + s);
            InlineKeyboardButton button4 = new InlineKeyboardButton();
            button4.setText(" ❌ ");
            button4.setCallbackData("delete_" + s);
            row1.add(button1);
            row1.add(button2);
            row1.add(button3);
            row1.add(button4);
            rowList.add(row1);
        }
        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText(" 🗑 Savatni tozalash  ");
        button5.setCallbackData("clear");
        InlineKeyboardButton button6 = new InlineKeyboardButton();
        button6.setText(" 🚖 Buyurtma berish ");
        button6.setCallbackData("buyurtma");
        List<InlineKeyboardButton> row2 = new LinkedList<>();
        row2.add(button5);
        List<InlineKeyboardButton> row3 = new LinkedList<>();
        row3.add(button6);
        rowList.add(row2);
        rowList.add(row3);
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(rowList);

        sendMessage.setReplyMarkup(keyboardMarkup);

        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void deleteOrderRu(SendMessage sendMessage, Message message, List<String> foodNameList) {
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();
        for (String s : foodNameList) {
            List<InlineKeyboardButton> row1 = new LinkedList<>();
            InlineKeyboardButton button1 = new InlineKeyboardButton();
            button1.setText(s);
            button1.setCallbackData(s);
            InlineKeyboardButton button2 = new InlineKeyboardButton();
            button2.setText(" ➕ ");
            button2.setCallbackData("plus_" + s);
            InlineKeyboardButton button3 = new InlineKeyboardButton();
            button3.setText(" ➖ ");
            button3.setCallbackData("minus_" + s);
            InlineKeyboardButton button4 = new InlineKeyboardButton();
            button4.setText(" ❌ ");
            button4.setCallbackData("delete_" + s);
            row1.add(button1);
            row1.add(button2);
            row1.add(button3);
            row1.add(button4);
            rowList.add(row1);
        }
        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText(" 🗑  Очисть корзинка  ");
        button5.setCallbackData("очисть");
        InlineKeyboardButton button6 = new InlineKeyboardButton();
        button6.setText(" 🚖 Оформить заказ ");
        button6.setCallbackData("Заказ");
        List<InlineKeyboardButton> row2 = new LinkedList<>();
        row2.add(button5);
        List<InlineKeyboardButton> row3 = new LinkedList<>();
        row3.add(button6);
        rowList.add(row2);
        rowList.add(row3);
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        keyboardMarkup.setKeyboard(rowList);

        sendMessage.setReplyMarkup(keyboardMarkup);

        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void location(SendMessage sendMessage) {
        String but3 = EmojiParser.parseToUnicode("📍 Joylashuvni ko'rsatish");
        String but4 = EmojiParser.parseToUnicode("⬅ Orqaga");
        KeyboardButton button3 = new KeyboardButton(but3);
        button3.setRequestLocation(true);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);


    }

    public void locationRu(SendMessage sendMessage) {
        String but3 = EmojiParser.parseToUnicode("📍 Показать местоположение");
        String but4 = EmojiParser.parseToUnicode("⬅ Назад");
        KeyboardButton button3 = new KeyboardButton(but3);
        button3.setRequestLocation(true);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);


    }

    public void phoneNumber(SendMessage sendMessage) {
        String but3 = EmojiParser.parseToUnicode("☎ Telefon nomerni jonatish");
        String but4 = EmojiParser.parseToUnicode("⬅ Orqaga");
        KeyboardButton button3 = new KeyboardButton(but3);
        button3.setRequestContact(true);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void phoneNumberRu(SendMessage sendMessage) {
        String but3 = EmojiParser.parseToUnicode("☎ Отправить номер телефона");
        String but4 = EmojiParser.parseToUnicode("⬅ Назад");
        KeyboardButton button3 = new KeyboardButton(but3);
        button3.setRequestContact(true);
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button3);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(button4);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row1, row2));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }

    public void keybordNumberRu(SendMessage sendMessage) {
        ReplyKeyboardMarkup keyBoardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        for (int i = 1; i < 10; i++) {
            row.add(Integer.valueOf(i).toString());
            if (i % 3 == 0) {
                keyboard.add(row);
                row = new KeyboardRow();
            }
        }

        String but4 = EmojiParser.parseToUnicode("⬅ Назад");
        String but5 = EmojiParser.parseToUnicode("🛒 Корзинка");
        KeyboardButton button4 = new KeyboardButton(but4);
        KeyboardButton button5 = new KeyboardButton(but5);
        KeyboardRow row1 = new KeyboardRow();
        row1.add(button4);
        row1.add(button5);
        keyboard.add(row1);
        keyBoardMarkup.setKeyboard(keyboard);
        keyBoardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(keyBoardMarkup);
        CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
    }
}
