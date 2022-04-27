package com.container;


import com.MyTelegramBot;
import com.controller.FirstFoodController;
import com.controller.LanguageController;
import com.controller.OrderController;
import com.entity.FoodAmount;
import com.entity.Order;
import com.reposity.UserReposity;
import com.util.Buttons;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class CompanyContainer {
    public static MyTelegramBot MY_TELEGRAM_BOT;
    public static Buttons buttons;
    public static UserReposity userReposity = new UserReposity();
    public static OrderController orderController = new OrderController();
    public static FirstFoodController firstController = new FirstFoodController();
    public static List<Order> orderList = new LinkedList<>();
    public static LanguageController langController = new LanguageController();
    public static FirstFoodController foodController = new FirstFoodController();

    public static String ADMIN = "1748183791";
    public static String CURER1 = "1748183791";
    public static String CURER2 = "1038373978";
    public static String CURER3 = "401460671";
    public static String CURER4 = "1124476120";
    public static Map<String, String> userStatusMap = new HashMap<>();


    public static List<FoodAmount> foodAmountList = new LinkedList<>();

    private static int generalId = 1;

    public static int nextId() {
        return generalId++;
    }

    public static FoodAmount getFoodAmountbyName(String foodName) {
        for (FoodAmount foodAmount : foodAmountList) {
            if (foodAmount.getFoodName().equals(foodName)) {
                return foodAmount;
            }
        }
        return null;
    }


}
