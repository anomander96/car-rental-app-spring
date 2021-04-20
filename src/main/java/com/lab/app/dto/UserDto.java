package com.lab.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long userRoleId;

    private String firstName;
    private String lastName;

    @NotBlank
//    @UniqueLogin my custom annotation
    private String login;

    private String password;

    @Email(message = "{email.correct-email}")
    private String email;

    private String phone;
    private String passport;
    private boolean isBlocked;
}
