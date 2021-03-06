package com.lab.app.repository.impl;

import com.lab.app.exception.UserNotFoundException;
import com.lab.app.model.User;
import com.lab.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private final List<User> userList = new ArrayList<>();

    @Override
    public User getUser(String email) {
        log.info("|| Repository layer: Getting user with email: {} ||", email);
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(User user) {
        userList.add(user);
        log.info("|| Repository layer: Creating a new user ||");
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = userList.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            userList.add(user);
        } else {
            throw new UserNotFoundException();
        }
        log.info("|| Repository layer: Updating user with email: {} ||", email);
        return user;
    }

    @Override
    public void deleteUser(String email) {
        log.info("|| Repository layer: Deleting user with email: {} ||", email);
        userList.removeIf(user -> user.getEmail().equals(email));
    }

    @Override
    public User findUserByLogin(String login) {
        log.info("|| Repository layer: Getting user with login: {} ||", login);
        return userList.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }
}
