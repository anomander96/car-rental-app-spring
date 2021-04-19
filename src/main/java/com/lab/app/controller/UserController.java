package com.lab.app.controller;

import com.lab.app.api.UserApi;
import com.lab.app.controller.assembler.UserAssembler;
import com.lab.app.controller.model.UserModel;
import com.lab.app.dto.UserDto;
import com.lab.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String email) {
        log.info("|| Controller layer: Extracting user with email: {} ||", email);
        UserDto user = userService.getUser(email);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("|| Controller layer: User: {} successfully created ||", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(String email, UserDto userDto) {
        log.info("|| Controller layer: User: {} successfully updated ||", userDto);
        UserDto user = userService.updateUser(email, userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String email) {
        log.info("|| Controller layer: User with email: {} successfully deleted ||", email);
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
