package com.controller;

import com.container.CompanyContainer;
import com.entity.Order;
import com.enums.Botstate;
import com.enums.UserStatus;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.LinkedList;
import java.util.List;

public class LanguageController {

    UserStatus currentUser;
    List<Order> orderList = new LinkedList<>();

    public void menyuRus(SendMessage sendMessage, User user, Message message,  List<Order> listSavat) {
        String text = message.getText();
        Order currentOrder = getOrderByUserId(String.valueOf(user.getId()));
        if (text.equals("\uD83D\uDECD Заказать")){
            StringBuilder builder = new StringBuilder();
            builder.append("<a href=\"https://telegra.ph/Sayrob-Restaurant-Menu-02-19\"");
            builder.append(">Sayrob меню</a>");
            sendMessage.setText("Выберите \n" + builder.toString());
            sendMessage.setParseMode("HTML");
            CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
        }else if(text.equals("\uD83C\uDF72 Первые блюда")){
            sendMessage.setText("Выберите блюда ");
            currentUser = UserStatus.FirstFood;
            CompanyContainer.buttons.firstFoodMenuRu(sendMessage, user);
        }else if(text.equals("\uD83C\uDF57 Вторые бляда")){
            sendMessage.setText("Выберите блюда ");
            currentUser = UserStatus.SecondFood;
            CompanyContainer.buttons.secondFoodMenuRu(sendMessage, user);
        }else if(text.equals("\uD83C\uDF62 Шашликы")){
            sendMessage.setText("Выберите блюда ");
            currentUser = UserStatus.Shahliklar;
            CompanyContainer.buttons.shashlikFoodMenuRu(sendMessage, user);
        }else if(text.equals("\uD83E\uDD57 Салаты")){
            sendMessage.setText("Выберите салат ");
            currentUser = UserStatus.Salatlar;
            CompanyContainer.buttons.saladFoodMenuRu(sendMessage, user);
        }
        else if(currentUser != null){
            if(currentUser.equals(UserStatus.FirstFood)){
             CompanyContainer.foodController.firstFoodRu(user,message,sendMessage,orderList);
             currentUser =null;
            }else if(currentUser.equals(UserStatus.SecondFood)){
                CompanyContainer.foodController.secondFoodRu(user,message,sendMessage,orderList);
                currentUser =null;
            }else if(currentUser.equals(UserStatus.Shahliklar)){
                CompanyContainer.foodController.shashliklarRu(user,message,sendMessage,orderList);
                currentUser =null;
            }else if(currentUser.equals(UserStatus.Salatlar)){
                CompanyContainer.foodController.salatlarRu(user,message,sendMessage,orderList);
                currentUser =null;
            }
        }else if (currentOrder != null) {
            if (currentOrder.getBotstate().equals(Botstate.Koza)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.Biqtirma)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.Bostirma)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.JojaChoponcha)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.Choponcha)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.QovurgaChoponcha)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.JojaChaxoxbili)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.YumshoqGosht)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.QoyGoshtiChaxoxbili)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.JigarChaxoxbili)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KurkaGosht)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KurkaChaxoxbili)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KartoshkaFri)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.QiymaShashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.BarbekuShashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.DumbaShashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.OramaShashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KuskovoyQoy)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KuskovoyMol)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.Jigarshashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("добавлено в корзину ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            }
        }
    }

    private Order getOrderByUserId(String userId) {
        for (Order order : orderList) {
            if (order.getUserID().equals(userId)) {
                return order;
            }
        }
        return null;
    }

    public void menyuEnd(SendMessage sendMessage, User user, Message message) {

    }
}
