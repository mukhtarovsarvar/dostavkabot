package com.controller;

import com.container.CompanyContainer;
import com.entity.FoodAmount;
import com.entity.Order;
import com.enums.Botstate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

public class FirstFoodController {

    public void firstFood(User user, Message message, SendMessage sendMessage, Order currentOrder) {
        List<Order> orderList = CompanyContainer.orderList;
        String text = message.getText();
        if (text.contains("\uD83C\uDF72 Ko'za sho'rva")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setBotstate(Botstate.Koza);
            orderList.add(order);
            sendMessage.setText("Nomi: " + foodAmount.getFoodName() + "\n" + "Narxi: " +
                    foodAmount.getAmount() + "\n Soni: " + foodAmount.getCount() +
                    "\n  TANALNG ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.contains("Biqtirma sho'rva")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setOrderId(CompanyContainer.nextId());
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.Biqtirma);
            orderList.add(order);

            sendMessage.setText("Nomi: " + foodAmount.getFoodName() + "\n" + "Narxi: " +
                    foodAmount.getAmount() + "\n Soni: " + foodAmount.getCount() +
                    "\n  TANALNG ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF72 Bostirma sho'rva")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.Bostirma);
            orderList.add(order);
            sendMessage.setText("Nomi: " + foodAmount.getFoodName() + "\n" + "Narxi: " +
                    foodAmount.getAmount() + "\n Soni: " + foodAmount.getCount() +
                    "\n  TANALNG ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        }

    }

    public void firstFoodRu(User user, Message message, SendMessage sendMessage, List<Order> orderList) {

        String text = message.getText();
        if (text.contains("\uD83C\uDF72 Ko'za sho'rva")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setBotstate(Botstate.Koza);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);
        } else if (text.contains("Biqtirma sho'rva")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setOrderId(CompanyContainer.nextId());
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.Biqtirma);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);
        } else if (text.equals("\uD83C\uDF72 Bostirma sho'rva")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.Bostirma);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);
        }

    }

    public void secondFood(User user, Message message, SendMessage sendMessage, Order currentOrder) {
        List<Order> orderList = CompanyContainer.orderList;
        String text = message.getText();
        if (text.contains("Jo'ja cho'poncha")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);

        } else if (text.equals("\uD83C\uDF56 Cho'poncha")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setOrderId(CompanyContainer.nextId());
            order.setAmount(0);
            order.setBotstate(Botstate.Choponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF56 Qovurg'a cho'poncha")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setOrderId(CompanyContainer.nextId());
            order.setAmount(0);
            order.setBotstate(Botstate.QovurgaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF57 Jo'ja chaxoxbili")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChaxoxbili);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF56 Yumshoq go'sht")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.YumshoqGosht);
            order.setOrderId(CompanyContainer.nextId());
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF56 Qo'y g. chaxoxbili")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.QoyGoshtiChaxoxbili);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF56 Jigar chaxoxbili")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JigarChaxoxbili);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF57 Kurka go'sht")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setOrderId(CompanyContainer.nextId());
            order.setAmount(0);
            order.setBotstate(Botstate.KurkaGosht);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF57 Kurka chaxoxbili")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.KurkaChaxoxbili);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF5F Kartoshka fri")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.KartoshkaFri);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        }

    }

    public void secondFoodRu(User user, Message message, SendMessage sendMessage, List<Order> orderList) {

        String text = message.getText();
        if (text.contains("Jo'ja cho'poncha")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF56 Cho'poncha")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setOrderId(CompanyContainer.nextId());
            order.setAmount(0);
            order.setBotstate(Botstate.Choponcha);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF56 Qovurg'a cho'poncha")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setOrderId(CompanyContainer.nextId());
            order.setAmount(0);
            order.setBotstate(Botstate.QovurgaChoponcha);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF57 Jo'ja chaxoxbili")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChaxoxbili);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF56 Yumshoq go'sht")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.YumshoqGosht);
            order.setOrderId(CompanyContainer.nextId());
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF56 Qo'y g. chaxoxbili")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.QoyGoshtiChaxoxbili);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF56 Jigar chaxoxbili")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JigarChaxoxbili);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF57 Kurka go'sht")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setOrderId(CompanyContainer.nextId());
            order.setAmount(0);
            order.setBotstate(Botstate.KurkaGosht);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF57 Kurka chaxoxbili")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.KurkaChaxoxbili);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83C\uDF5F Kartoshka fri")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.KartoshkaFri);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        }

    }

    public void salatlar(User user, Message message, SendMessage sendMessage, Order currentOrder) {
        List<Order> orderList = CompanyContainer.orderList;
        String text = message.getText();
        if (text.equals("\uD83E\uDD57 Smak")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Grecheskiy salat")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Jenskiy kapriz")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Barf")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Yaponskiy salat")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Sezar salat")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Nejniy salat")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);


        } else if (text.equals("\uD83E\uDD57 Chafani")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Mujskoy kapriz")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Appetit")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Rakford")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        }

    }

    public void shashliklar(User user, Message message, SendMessage sendMessage, Order currentOrder) {
        List<Order> orderList = CompanyContainer.orderList;
        String text = message.getText();
        if (text.equals("\uD83C\uDF62 Qiyma shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.QiymaShashlik);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Barbekyu shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.BarbekuShashlik);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Dumba shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.DumbaShashlik);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 O'rama shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.OramaShashlik);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Kuskovoy mol g. shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.KuskovoyMol);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Kuskovoy qo'y g. shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.KuskovoyQoy);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Jigar shashlik shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.Jigarshashlik);
            orderList.add(order);
            sendMessage.setText("sonini kiriting ");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        }
    }

    public void shashliklarRu(User user, Message message, SendMessage sendMessage, List<Order> orderList) {
        String text = message.getText();
        if (text.equals("\uD83C\uDF62 Qiyma shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.QiymaShashlik);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Barbekyu shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.BarbekuShashlik);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Dumba shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.DumbaShashlik);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 O'rama shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.OramaShashlik);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Kuskovoy mol g. shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.KuskovoyMol);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Kuskovoy qo'y g. shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.KuskovoyQoy);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        } else if (text.equals("\uD83C\uDF62 Jigar shashlik shashlik")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setOrderId(CompanyContainer.nextId());
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setBotstate(Botstate.Jigarshashlik);
            orderList.add(order);
            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() + "\n Выберите количество");
            CompanyContainer.buttons.keybordNumber(sendMessage);
        }
    }

    public void salatlarRu(User user, Message message, SendMessage sendMessage, List<Order> orderList) {

        String text = message.getText();
        if (text.equals("\uD83E\uDD57 Smak")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);
        } else if (text.equals("\uD83E\uDD57 Grecheskiy salat")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Jenskiy kapriz")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Barf")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Yaponskiy salat")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Sezar salat")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Nejniy salat")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);


        } else if (text.equals("\uD83E\uDD57 Chafani")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Mujskoy kapriz")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Appetit")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        } else if (text.equals("\uD83E\uDD57 Rakford")) {
            FoodAmount foodAmount = CompanyContainer.getFoodAmountbyName(text);
            if (foodAmount == null) {
                return;
            }
            Order order = new Order();
            order.setName(text);
            order.setUserID(String.valueOf(user.getId()));
            order.setSumma(foodAmount.getAmount());
            order.setAmount(0);
            order.setOrderId(CompanyContainer.nextId());
            order.setBotstate(Botstate.JojaChoponcha);
            orderList.add(order);

            sendMessage.setText("Имя: " + foodAmount.getFoodName() + "\n" + "Цена: " +
                    foodAmount.getAmount() + "\n Количество: " + foodAmount.getCount() +
                    "\n Выберите количество");
            CompanyContainer.buttons.keybordNumberRu(sendMessage);

        }
    }
}
