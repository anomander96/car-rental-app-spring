package com.lab.app.controller;

import com.lab.app.dto.UserDto;
import com.lab.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserDto getUser(@PathVariable String email) {
        log.info("Extracting user with email: {}", email);
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("User: {} successfully created", userDto);
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto) {
        log.info("User: {} successfully updated", userDto);
        return userService.updateUser(email, userDto);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        log.info("User with email: {} successfully deleted", email);
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}
