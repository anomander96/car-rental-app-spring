package com.lab.app.exception;

public class UserNotFoundException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "User is not found";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
