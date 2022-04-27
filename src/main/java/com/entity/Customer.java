package com.entity;

import com.enums.UserStatus;
import lombok.Data;

@Data
public class Customer{
   private String userId;
   private String latitude;
   private String longitude;
   private String locationUrl;
   private String phoneNumber;
   private UserStatus status;

}
