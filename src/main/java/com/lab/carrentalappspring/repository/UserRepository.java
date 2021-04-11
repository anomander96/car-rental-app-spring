package com.lab.carrentalappspring.repository;

import com.lab.carrentalappspring.model.User;

public interface UserRepository {
    User getUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);
}
