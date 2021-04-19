package com.lab.app.exception;

import com.lab.app.model.enums.ErrorType;

public class CarNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Car is not found!";

    public CarNotFoundException() {
    }

    public CarNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR;
    }
}
