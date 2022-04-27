package com.controller;

import com.container.CompanyContainer;
import com.entity.Current;
import com.enums.Botstate;
import com.entity.Customer;
import com.entity.FoodAmount;
import com.entity.Order;
import com.enums.UserStatus;
import com.util.Buttons;
import org.apache.xmlbeans.impl.store.Cur;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainController {
    List<FoodAmount> foodAmountList = CompanyContainer.foodAmountList;
    List<Order> orderList = CompanyContainer.orderList;
    LanguageController langController = CompanyContainer.langController;
    List<Order> listSavat = new LinkedList<>();
    List<Customer> currentCustomerList = new LinkedList<>();
    List<Customer> customerList = new LinkedList<>();
    List<Current> currentList = new LinkedList<>();
    List<Current> curLanguage = new LinkedList<>();

    public void hasText(User user, Message message) {
        CompanyContainer.buttons = new Buttons();
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(user.getId()));
        Order currentOrder = getOrderByUserId(String.valueOf(user.getId()));
        Current currentuser = getCurrentUserByUserid(String.valueOf(user.getId()));
        Current currentLanguage = getCurrentLanguage(String.valueOf(user.getId()));

        if (text.equals("/start")) {
            sendMessage.setText("Assalomu alaykum! Sayrob  yetkazib berish xizmatiga xush kelibsiz.\n" +
                    "\n" +
                    "Здравствуйте! Добро пожаловать в службу доставки Sayrob.\n" +
                    "\n" +
                    "Hello! Welcome to Sayrob delivery service.");
            CompanyContainer.buttons.keybordLanguage(sendMessage, user);
        } else if (text.equals("☎ Sayrob bilan aloqa")) {
            StringBuilder builder = new StringBuilder();
            builder.append("<a href=\"https://www.google.com/maps/place/Sayrob/@37.2393052,67.2667509,18z/data=!4m13!1m7!3m6!1s0x0:0x3f6afbf367f06f31!2zMzfCsDE0JzIxLjQiTiA2N8KwMTYnMDEuNiJF!3b1!8m2!3d37.239286!4d67.267121!3m4!1s0x3f3531d5cab92895:0x6f9911ab9ab0720b!8m2!3d37.2395504!4d67.2677588");
            builder.append("\"");
            builder.append(">Lokatsiya</a>");
            sendMessage.setText("📍 Bizning manzil \n" + builder + "\nBoglanish uchun nomer \n" +
                    "+998900642712");
            sendMessage.setParseMode("HTML");
            CompanyContainer.buttons.Menyukeyboard(sendMessage, user);
        } else if (text.contains("Savatcha")) {
            savatcha(user, sendMessage, message);
        } else if (text.equals("\uD83D\uDED2 Корзинка")) {
            savatchaRu(user, sendMessage, message);
        } else if (text.equals("\uD83C\uDDFA\uD83C\uDDFF O'zbekcha")) {
            sendMessage.setText("Qaysi shaharda yashaysiz? \n" +
                    "Iltimos, shaharni tanlang:");
            CompanyContainer.buttons.ChooseCityUz(sendMessage, user);
        } else if (text.equals("⬅ Orqaga")) {
            sendMessage.setText("Main menu");
            CompanyContainer.buttons.Menyukeyboard(sendMessage, user);

        } else if (text.equals("⬅ Назад")) {
            sendMessage.setText("Главное меню");
            CompanyContainer.buttons.MenyukeyboardRus(sendMessage, user);
        } else if (text.equals("\uD83C\uDDFA\uD83C\uDDF8 English")) {
            sendMessage.setText("Where do you live?\n" +
                    "Please,choose the city");
            CompanyContainer.buttons.ChooseCityEn(sendMessage, user);
        } else if (text.equals("\uD83C\uDDF7\uD83C\uDDFA Русский")) {
            sendMessage.setText("В каком городе Вы живёте? \n" +
                    "Пожалуйста, выберите город:");
            Current current = new Current();
            current.setUserId(String.valueOf(user.getId()));
            current.setUserStatus(UserStatus.Rus);
            curLanguage.add(current);
            CompanyContainer.buttons.ChooseCityRu(sendMessage, user);
        } else if (text.equals("Toshkent") || text.equals("Andijon") || text.equals("Termiz") ||
                text.equals("Samarqand") || text.equals("Buxoro") || text.equals("Xorazm")) {
            sendMessage.setText("Bosh menyu");
            CompanyContainer.buttons.Menyukeyboard(sendMessage, user);
        } else if (text.equals("Tashkent") || text.equals("Andijan") || text.equals("Termez") ||
                text.equals("Samarkand") || text.equals("Bukhara") || text.equals("Khorezm")) {
            sendMessage.setText("Main menu");
            CompanyContainer.buttons.MenyukeyboardEng(sendMessage, user);
        } else if (text.equals("Ташкент") || text.equals("Андижан") || text.equals("Термез") ||
                text.equals("Самарканд") || text.equals("Бухара") || text.equals("Хоразм")) {
            sendMessage.setText("Главное меню");
            CompanyContainer.buttons.MenyukeyboardRus(sendMessage, user);
        } else if (text.equals("☎ Обратная связь")) {
            StringBuilder builder = new StringBuilder();
            builder.append("<a href=\"https://www.google.com/maps/place/Sayrob/@37.2393052,67.2667509,18z/data=!4m13!1m7!3m6!1s0x0:0x3f6afbf367f06f31!2zMzfCsDE0JzIxLjQiTiA2N8KwMTYnMDEuNiJF!3b1!8m2!3d37.239286!4d67.267121!3m4!1s0x3f3531d5cab92895:0x6f9911ab9ab0720b!8m2!3d37.2395504!4d67.2677588");
            builder.append("\"");
            builder.append(">Lokatsiya</a>");
            sendMessage.setText("📍 Наш адрес \n" + builder + " \n Контактный номер " +
                    "+998900642712");
            sendMessage.setParseMode("HTML");
            CompanyContainer.buttons.MenyukeyboardRus(sendMessage, user);
        } else if (text.equals("\uD83D\uDECD Buyurtma berish")) {
            initFoodAmount(foodAmountList);
            CompanyContainer.orderController.hasOrder(user, message, sendMessage);
        } else if (text.equals("\uD83D\uDECD Order")) {
            initFoodAmount(foodAmountList);
            CompanyContainer.orderController.hasOrder(user, message, sendMessage);
        } else if (text.equals("\uD83C\uDF72 Birinchi taomlar")) {
            Current current = new Current();
            current.setUserId(String.valueOf(user.getId()));
            current.setUserStatus(UserStatus.FirstFood);
            currentList.add(current);
            sendMessage.setText("Taomni tanlang");
            CompanyContainer.buttons.firstFoodMenuUz(sendMessage, user);
        } else if (text.equals("\uD83C\uDF57 Ikkinchi taomlar")) {
            Current current = new Current();
            current.setUserId(String.valueOf(user.getId()));
            current.setUserStatus(UserStatus.SecondFood);
            currentList.add(current);
            sendMessage.setText("Taomni tanlang");
            CompanyContainer.buttons.secondFoodMenuUz(sendMessage, user);
        } else if (text.equals("\uD83E\uDD57 Salatlar")) {
            Current current = new Current();
            current.setUserId(String.valueOf(user.getId()));
            current.setUserStatus(UserStatus.Salatlar);
            currentList.add(current);
            sendMessage.setText("Taomni tanlang");
            CompanyContainer.buttons.saladFoodMenuUz(sendMessage, user);
        } else if (text.equals("\uD83C\uDF62 Shashliklar")) {
            Current current = new Current();
            current.setUserId(String.valueOf(user.getId()));
            current.setUserStatus(UserStatus.Shahliklar);
            currentList.add(current);
            sendMessage.setText("Tanlang");
            CompanyContainer.buttons.shashlikFoodMenuUz(sendMessage, user);
        } else if (text.equals("⚙ Sozlash ℹ Ma'lumotlar") || text.equals("⚙ Настройки ℹ Информация")) {
            sendMessage.setText("Tanalang");
            CompanyContainer.buttons.keybordLanguage(sendMessage, user);
        } else if (currentuser != null) {
            if (currentuser.getUserStatus().equals(UserStatus.FirstFood)) {
                currentList.remove(currentuser);
                CompanyContainer.firstController.firstFood(user, message, sendMessage, currentOrder);
            } else if (currentuser.getUserStatus().equals(UserStatus.SecondFood)) {
                currentList.remove(currentuser);
                CompanyContainer.firstController.secondFood(user, message, sendMessage, currentOrder);
            } else if (currentuser.getUserStatus().equals(UserStatus.Salatlar)) {
                currentList.remove(currentuser);
                CompanyContainer.firstController.salatlar(user, message, sendMessage, currentOrder);
            } else if (currentuser.getUserStatus().equals(UserStatus.Shahliklar)) {
                currentList.remove(currentuser);
                CompanyContainer.firstController.shashliklar(user, message, sendMessage, currentOrder);
            }
        }
        else if (currentOrder != null) {
            if (currentOrder.getBotstate().equals(Botstate.Koza)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.Biqtirma)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                //   Order checkOr = getListSavtbyFoodName(String.valueOf(user.getId()), currentOrder.getName());
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.Bostirma)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.JojaChoponcha)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.Choponcha)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.QovurgaChoponcha)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.JojaChaxoxbili)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.YumshoqGosht)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.QoyGoshtiChaxoxbili)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.JigarChaxoxbili)) {
                if (Integer.valueOf(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.valueOf(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KurkaGosht)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KurkaChaxoxbili)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KartoshkaFri)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.QiymaShashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.BarbekuShashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.DumbaShashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.OramaShashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KuskovoyQoy)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.KuskovoyMol)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            } else if (currentOrder.getBotstate().equals(Botstate.Jigarshashlik)) {
                if (Integer.parseInt(text) < 1) {
                    return;
                }
                sendMessage.setText("Buyurtmangiz kabul kilindi! ");
                currentOrder.setAmount(currentOrder.getAmount() + Integer.parseInt(text));
                listSavat.add(currentOrder);
                orderList.remove(0);
                CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            }

        }
        else if (currentLanguage != null) {
            if (currentLanguage.getUserStatus().equals(UserStatus.Rus)) {
                if (foodAmountList.size() == 0) {
                    initFoodAmount(foodAmountList);
                }
                langController.menyuRus(sendMessage, user, message, listSavat);

            }

        }
    }

    private Current getCurrentUserByUserid(String userID) {
        for (Current current : currentList) {
            if (current.getUserId().equals(userID)) {
                return current;
            }
        }
        return null;
    }

    private Current getCurrentLanguage(String userID) {
        for (Current current : curLanguage) {
            if (current.getUserId().equals(userID)) {
                return current;
            }
        }
        return null;
    }

    private Customer getCustomerByUserID(String userId) {
        for (Customer customer : currentCustomerList) {
            if (customer.getUserId().equals(userId)) {
                return customer;
            }
        }
        return null;
    }

    public void hasCallbackQuery(User user, Message message, String date) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(user.getId()));
        if (date.startsWith("delete_")) {
            String name = date.substring(7, date.length());
            int count = 0;
            for (Order order : listSavat) {
                if (order.getName().equals(name)) {
                    listSavat.remove(count);
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(String.valueOf(user.getId()));
                    deleteMessage.setMessageId(message.getMessageId());
                    sendMessage.setText(order.getName() + " O'chirildi");
                    CompanyContainer.MY_TELEGRAM_BOT.send(deleteMessage);
                    savatcha(user, sendMessage, message);
                    return;
                }
                count++;
            }
        } else if (date.equals("очисть")) {
            Iterator<Order> iterator = listSavat.iterator();

            while (iterator.hasNext()) {
                Order or = iterator.next();
                if (or.getUserID().equals(String.valueOf(user.getId()))) {
                    iterator.remove();
                }
            }
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(String.valueOf(user.getId()));
            deleteMessage.setMessageId(message.getMessageId());
            sendMessage.setText("Ваша корзина очищена!");
            CompanyContainer.buttons.foodMenyuRus(sendMessage, user);
            CompanyContainer.MY_TELEGRAM_BOT.send(deleteMessage);
        } else if (date.startsWith("plus_")) {
            String plus = date.substring(5, date.length());
            int count = 0;
            for (Order order : listSavat) {
                if (order.getName().equals(plus)) {
                    order.setAmount(order.getAmount() + 1);
                    listSavat.add(order);
                    listSavat.remove(count);
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(String.valueOf(user.getId()));
                    deleteMessage.setMessageId(message.getMessageId());
                    savatcha(user, sendMessage, message);
                    CompanyContainer.MY_TELEGRAM_BOT.send(deleteMessage);
                    return;
                }
                count++;
            }
        } else if (date.startsWith("minus_")) {
            String minus = date.substring(6, date.length());
            int count = 0;
            for (Order order : listSavat) {
                if (order.getName().equals(minus)) {
                    if (order.getAmount() < 2) {
                        listSavat.remove(count);
                        DeleteMessage deleteMessage = new DeleteMessage();
                        deleteMessage.setChatId(String.valueOf(user.getId()));
                        deleteMessage.setMessageId(message.getMessageId());
                        sendMessage.setText(order.getName() + " ni ochirvordiz");
                        savatcha(user, sendMessage, message);
                        CompanyContainer.MY_TELEGRAM_BOT.send(deleteMessage);
                        return;
                    }
                    order.setAmount(order.getAmount() - 1);
                    listSavat.add(order);
                    listSavat.remove(count);
                    DeleteMessage deleteMessage = new DeleteMessage();
                    deleteMessage.setChatId(String.valueOf(user.getId()));
                    deleteMessage.setMessageId(message.getMessageId());
                    savatcha(user, sendMessage, message);
                    CompanyContainer.MY_TELEGRAM_BOT.send(deleteMessage);
                    return;
                }
                count++;
            }
        } else if (date.contains("clear")) {
            Iterator<Order> iterator = listSavat.iterator();
            while (iterator.hasNext()) {
                Order or = iterator.next();
                if (or.getUserID().equals(String.valueOf(user.getId()))) {
                    iterator.remove();
                }
            }
            DeleteMessage deleteMessage = new DeleteMessage();
            deleteMessage.setChatId(String.valueOf(user.getId()));
            deleteMessage.setMessageId(message.getMessageId());
            sendMessage.setText("Sizning savatingiz tozalandi!");
            CompanyContainer.buttons.foodMenyuUz(sendMessage, user);
            CompanyContainer.MY_TELEGRAM_BOT.send(deleteMessage);
        } else if (date.contains("buyurtma")) {
            Customer customer = new Customer();
            customer.setUserId(String.valueOf(user.getId()));
            customer.setStatus(UserStatus.Location);
            currentCustomerList.add(customer);
            sendMessage.setText("Sizning manzilingizni aniqlashimiz uchun, joylashuvingizni yuboring.");
            CompanyContainer.buttons.location(sendMessage);
        } else if (date.contains("Заказ")) {
            Customer customer = new Customer();
            customer.setUserId(String.valueOf(user.getId()));
            customer.setStatus(UserStatus.Location);
            currentCustomerList.add(customer);
            sendMessage.setText("Отправьте нам свое местоположение, чтобы мы могли определить ваше местоположение.");
            CompanyContainer.buttons.locationRu(sendMessage);
        }
    }

    public void savatcha(User user, SendMessage sendMessage, Message message) {
        StringBuilder builder = new StringBuilder();
        List<String> foodList = new LinkedList<>();
        double summa = 0;
        for (Order order : listSavat) {
            if (order.getUserID().equals(String.valueOf(user.getId()))) {
                builder.append("Buyurtma id: ");
                builder.append(order.getOrderId() + "\n");
                builder.append("Nomi: ");
                builder.append(order.getName());
                builder.append("\n");
                builder.append("Soni: ");
                builder.append(order.getAmount());
                builder.append("\n summasi: ");
                builder.append(order.getAmount() * order.getSumma() + "\n");
                builder.append("--------------\n");
                foodList.add(order.getName());
                summa += order.getAmount() * order.getSumma();
            }
        }

        if (builder.isEmpty()) {
            builder.append("Sizda hech narsa yoq \n");
            sendMessage.setText(builder.toString());
            CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
            return;
        } else {
            builder.append("Jami summasi: ");
            builder.append(summa + "\n");
        }


        sendMessage.setText(builder.toString());
        CompanyContainer.buttons.deleteOrder(sendMessage, message, foodList);
    }

    public void savatchaRu(User user, SendMessage sendMessage, Message message) {
        StringBuilder builder = new StringBuilder();
        List<String> foodList = new LinkedList<>();
        double summa = 0;
        for (Order order : listSavat) {
            if (order.getUserID().equals(String.valueOf(user.getId()))) {
                builder.append("Заказ id: ");
                builder.append(order.getOrderId() + "\n");
                builder.append("Имя: ");
                builder.append(order.getName());
                builder.append("\n");
                builder.append("количество: ");
                builder.append(order.getAmount());
                builder.append("\n стоимость: ");
                builder.append(order.getAmount() * order.getSumma() + "\n");
                builder.append("--------------\n");
                foodList.add(order.getName());
                summa += order.getAmount() * order.getSumma();
            }
        }

        if (builder.isEmpty()) {
            builder.append("у вас нет  \n");
            sendMessage.setText(builder.toString());
            CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
            return;
        } else {
            builder.append("Общая сумма: ");
            builder.append(summa + "\n");
        }
        sendMessage.setText(builder.toString());
        CompanyContainer.buttons.deleteOrderRu(sendMessage, message, foodList);
    }

    public void savatchaEng(User user, SendMessage sendMessage, Message message) {
        StringBuilder builder = new StringBuilder();
        List<String> foodList = new LinkedList<>();
        double summa = 0;
        for (Order order : listSavat) {
            if (order.getUserID().equals(String.valueOf(user.getId()))) {
                builder.append("Buyurtma id: ");
                builder.append(order.getOrderId() + "\n");
                builder.append("Nomi: ");
                builder.append(order.getName());
                builder.append("\n");
                builder.append("Soni: ");
                builder.append(order.getAmount());
                builder.append("\n summasi: ");
                builder.append(order.getAmount() * order.getSumma() + "\n");
                builder.append("--------------\n");
                foodList.add(order.getName());
                summa += order.getAmount() * order.getSumma();
            }
        }

        if (builder.isEmpty()) {
            builder.append("Sizda hech narsa yoq \n");
            sendMessage.setText(builder.toString());
            CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
            return;
        } else {
            builder.append("Jami summasi: ");
            builder.append(summa + "\n");
        }


        sendMessage.setText(builder.toString());
        CompanyContainer.buttons.deleteOrder(sendMessage, message, foodList);
    }

    public Order getOrderByUserId(String userId) {
        for (Order order : orderList) {
            if (order.getUserID().equals(userId)) {
                return order;
            }
        }
        return null;
    }

    public void initFoodAmount(List<FoodAmount> foodAmountList) {

        foodAmountList.add(new FoodAmount("\uD83C\uDF72 Ko'za sho'rva", 22000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF72 Biqtirma sho'rva", 22000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF72 Bostirma sho'rva", 27000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF57 Jo'ja cho'poncha", 75000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF56 Cho'poncha", 110000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF57 Jo'ja chaxoxbili", 85000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF56 Qovurg'a cho'poncha", 120000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF56 Yumshoq go'sht", 120000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF56 Qo'y g. chaxoxbili", 130000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF56 Jigar chaxoxbili", 85000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF57 Kurka go'sht", 85000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF57 Kurka chaxoxbili", 95000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF5F Kartoshka fri", 10000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF62 Qiyma shashlik", 11000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF62 Barbekyu shashlik", 60000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF62 Dumba shashlik", 15000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF62 O'rama shashlik", 12000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF62 Kuskovoy mol g. shashlik", 12000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF62 Kuskovoy qo'y g. shashlik", 15000, 1));
        foodAmountList.add(new FoodAmount("\uD83C\uDF62 Jigar shashlik shashlik", 10000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Smak", 20000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Grecheskiy salat", 15000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Jenskiy kapriz", 15000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Barf", 20000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Yaponskiy salat", 20000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Sezar salat", 20000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Nejniy salat", 20000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Chafani", 15000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Mujskoy kapriz", 15000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Appetit", 15000, 1));
        foodAmountList.add(new FoodAmount("\uD83E\uDD57 Rakford", 15000, 1));

    }

    public void hasLocation(User user, Message message) {
        Current currentLanguage = getCurrentLanguage(String.valueOf(user.getId()));
        if(currentLanguage != null) {
            if (currentLanguage.getUserStatus().equals(UserStatus.Rus)) {
                Location location = message.getLocation();
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Чтобы мы знали ваш номер  Нажмите ☎ Отправить номер телефона");
                sendMessage.setChatId(String.valueOf(user.getId()));

                String locationStr = "https://maps.google.com/?q=" + location.getLatitude() +
                        "," + location.getLongitude();
                CompanyContainer.buttons.phoneNumberRu(sendMessage);

                Customer currentCustomer = getCustomerByUserID(String.valueOf(user.getId()));
                currentCustomer.setLatitude(String.valueOf(location.getLatitude()));
                currentCustomer.setLongitude(String.valueOf(location.getLongitude()));
                currentCustomer.setLocationUrl(locationStr);

                currentCustomerList.add(currentCustomer);
                currentCustomerList.remove(0);

                StringBuilder builder = new StringBuilder();
                builder.append("<a href=\"https://maps.google.com/?q=");
                builder.append(location.getLatitude());
                builder.append(",");
                builder.append(location.getLongitude());
                builder.append("\"");
                builder.append(">User Location</a>");
            }
        }
        else {
            Location location = message.getLocation();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Sizni nomeringizni bilishimiz uchun ☎ Telefon nomerni jonatish ni usriga bosin");
            sendMessage.setChatId(String.valueOf(user.getId()));
            String locationStr = "https://maps.google.com/?q=" + location.getLatitude() +
                    "," + location.getLongitude();
            CompanyContainer.buttons.phoneNumber(sendMessage);
            Customer currentCustomer = getCustomerByUserID(String.valueOf(user.getId()));
            currentCustomer.setLatitude(String.valueOf(location.getLatitude()));
            currentCustomer.setLongitude(String.valueOf(location.getLongitude()));
            currentCustomer.setLocationUrl(locationStr);

            currentCustomerList.add(currentCustomer);
            currentCustomerList.remove(0);

            StringBuilder builder = new StringBuilder();
            builder.append("<a href=\"https://maps.google.com/?q=");
            builder.append(location.getLatitude());
            builder.append(",");
            builder.append(location.getLongitude());
            builder.append("\"");
            builder.append(">User Location</a>");
        }
    }

    public void hasContact(User user, Message message) {
        Current currentLanguage = getCurrentLanguage(String.valueOf(user.getId()));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(user.getId()));
        SendMessage toAdmin = new SendMessage();
        toAdmin.setChatId(String.valueOf(CompanyContainer.CURER1));
        if(currentLanguage != null) {
            if (currentLanguage.getUserStatus().equals(UserStatus.Rus)) {
                Customer customerByUserID = getCustomerByUserID(String.valueOf(user.getId()));
                customerByUserID.setPhoneNumber(message.getContact().getPhoneNumber());
                customerList.add(customerByUserID);

                sendMessage.setText("Ваш заказ принят");
                CompanyContainer.buttons.MenyukeyboardRus(sendMessage, user);

                StringBuilder adminNessage = new StringBuilder();
                adminNessage.append("Telefon nomeri: " + message.getContact().getPhoneNumber() + "\n");
                double jamiSumma = 0;
                for (Order order : listSavat) {
                    if (order.getUserID().equals(String.valueOf(user.getId()))) {
                        adminNessage.append("Name: ");
                        adminNessage.append(order.getName() + "\n");
                        adminNessage.append("Soni: ");
                        adminNessage.append(order.getAmount() + "\n");
                        adminNessage.append("Narxi: ");
                        adminNessage.append(order.getSumma() * order.getAmount());
                        adminNessage.append("\n");
                        adminNessage.append("------------- \n");
                        jamiSumma += order.getSumma() * order.getAmount();
                    }
                }

                if (adminNessage.isEmpty()) {
                    sendMessage.setText("Ничего нет");
                    CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
                    return;
                } else {
                    adminNessage.append("Jami summa: " + jamiSumma);
                }
                StringBuilder builder = new StringBuilder();
                builder.append("<a href=\"https://maps.google.com/?q=");
                builder.append(customerByUserID.getLatitude());
                builder.append(",");
                builder.append(customerByUserID.getLongitude());
                builder.append("\"");
                builder.append(">User Location</a>");
                toAdmin.setText("User: " + user.getFirstName() + " " + user.getLastName() + "\n" +
                        "User Location:\n" + builder.toString() + "\n" + adminNessage.toString()
                );
                toAdmin.setParseMode("HTML");
                CompanyContainer.MY_TELEGRAM_BOT.send(toAdmin);
                SendMessage sendCurer = new SendMessage();
                sendCurer.setChatId(CompanyContainer.ADMIN);
                sendCurer.setParseMode("HTML");
                sendCurer.setText("User: " + user.getFirstName() + " " + user.getLastName() + "\n" +
                        "User Location:\n" + builder.toString() + "\n" + adminNessage.toString());

                Iterator<Order> iterator = listSavat.iterator();
                while (iterator.hasNext()) {
                    Order or = iterator.next();
                    if (or.getUserID().equals(String.valueOf(user.getId()))) {
                        iterator.remove();
                    }
                }
                CompanyContainer.MY_TELEGRAM_BOT.send(sendCurer);
            }
        }else {
            Customer customerByUserID = getCustomerByUserID(String.valueOf(user.getId()));
            customerByUserID.setPhoneNumber(message.getContact().getPhoneNumber());
            customerList.add(customerByUserID);

            sendMessage.setText("Buyurtmangiz qabul qilindi ");
            CompanyContainer.buttons.Menyukeyboard(sendMessage, user);

            StringBuilder adminNessage = new StringBuilder();
            adminNessage.append("Telefon nomeri: " + message.getContact().getPhoneNumber() + "\n");
            double jamiSumma = 0;
            for (Order order : listSavat) {
                if (order.getUserID().equals(String.valueOf(user.getId()))) {
                    adminNessage.append("Name: ");
                    adminNessage.append(order.getName() + "\n");
                    adminNessage.append("Soni: ");
                    adminNessage.append(order.getAmount() + "\n");
                    adminNessage.append("Narxi: ");
                    adminNessage.append(order.getSumma() * order.getAmount());
                    adminNessage.append("\n");
                    adminNessage.append("------------- \n");
                    jamiSumma += order.getSumma() * order.getAmount();
                }
            }

            if (adminNessage.isEmpty()) {
                sendMessage.setText("Sizda hech narsa yo'q");
                CompanyContainer.MY_TELEGRAM_BOT.send(sendMessage);
                return;
            } else {
                adminNessage.append("Jami summa: " + jamiSumma);
            }

            StringBuilder builder = new StringBuilder();
            builder.append("<a href=\"https://maps.google.com/?q=");
            builder.append(customerByUserID.getLatitude());
            builder.append(",");
            builder.append(customerByUserID.getLongitude());
            builder.append("\"");
            builder.append(">User Location</a>");
            toAdmin.setText("User: " + user.getFirstName() + " " + user.getLastName() + "\n" +
                    "User Location:\n" + builder.toString() + "\n" + adminNessage.toString()
            );

            toAdmin.setParseMode("HTML");
            CompanyContainer.MY_TELEGRAM_BOT.send(toAdmin);

            SendMessage sendCurer = new SendMessage();
            sendCurer.setChatId(CompanyContainer.ADMIN);
            sendCurer.setParseMode("HTML");
            sendCurer.setText("User: " + user.getFirstName() + " " + user.getLastName() + "\n" +
                    "User Location:\n" + builder.toString() + "\n" + adminNessage.toString());

            Iterator<Order> iterator = listSavat.iterator();
            while (iterator.hasNext()) {
                Order or = iterator.next();
                if (or.getUserID().equals(String.valueOf(user.getId()))) {
                    iterator.remove();
                }
            }
            CompanyContainer.MY_TELEGRAM_BOT.send(sendCurer);
        }
    }
    
}



