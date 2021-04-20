package com.lab.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

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


    // check for work
}
