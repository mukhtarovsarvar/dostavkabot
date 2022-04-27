package com.entity;

import com.enums.UserStatus;
import lombok.Data;

@Data
public class Current {
    private String userId;
    private UserStatus userStatus;
}
