package com.lab.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private int userId;
    private int userRoleId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String passport;
    private boolean isBlocked;
}
