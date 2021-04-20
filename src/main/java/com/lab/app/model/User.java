package com.lab.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private Long userRoleId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    @Column(unique = true)
    private String email;
    private String phone;
    private String passport;
    private boolean isBlocked;

}
