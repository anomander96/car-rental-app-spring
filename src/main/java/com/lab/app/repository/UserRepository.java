package com.lab.app.repository;

import com.lab.app.model.User;

public interface UserRepository {

    User getUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);

    User findUserByLogin(String login);
}
