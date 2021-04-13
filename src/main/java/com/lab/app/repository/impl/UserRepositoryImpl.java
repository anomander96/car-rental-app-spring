package com.lab.app.repository.impl;

import com.lab.app.model.User;
import com.lab.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private final List<User> userList = new ArrayList<>();

    @Override
    public User getUser(String email) {
        log.info("Getting user with email: {} from database", email);
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User createUser(User user) {
        userList.add(user);
        log.info("Creating a new user in database");
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = userList.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            userList.add(user);
        } else {
            throw new RuntimeException("User doesn't exist");
        }
        log.info("Updating user in database");
        return user;
    }

    @Override
    public void deleteUser(String email) {
        log.info("Deleting user with email: {} from database", email);
        userList.removeIf(user -> user.getEmail().equals(email));
    }
}
