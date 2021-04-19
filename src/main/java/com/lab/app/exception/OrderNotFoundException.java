package com.lab.app.exception;

import com.lab.app.model.enums.ErrorType;

public class OrderNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Order is not found!";

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR;
    }
}
