package com.lab.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lab.app.validation.AdvanceValidationGroup;
import com.lab.app.validation.ValidationGroup;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude()
public class UserDto {

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private int userId;

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private int userRoleId;

    private String firstName;
    private String lastName;

    @NotBlank(message = "{login.blank}", groups = ValidationGroup.class)
    private String login;

    private String password;

    @Email(message = "{email.correct-email}", groups = ValidationGroup.class)
    private String email;

    private String phone;
    private String passport;
    private boolean isBlocked;
}
