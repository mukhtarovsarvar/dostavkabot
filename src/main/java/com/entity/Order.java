package com.entity;

import com.enums.Botstate;
import lombok.Data;

@Data
public class Order {
    private Integer orderId;
    private String name;
    private double summa;
    private Integer amount;
    private String userID;
    private Botstate botstate;
}
