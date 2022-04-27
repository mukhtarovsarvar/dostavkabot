package com.entity;

import lombok.Data;

@Data
public class FoodAmount {

  private String foodName;
  private double amount;
  private Integer count;

  public FoodAmount(String foodName, double amount, Integer count) {
    this.foodName = foodName;
    this.amount = amount;
    this.count = count;
  }

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
