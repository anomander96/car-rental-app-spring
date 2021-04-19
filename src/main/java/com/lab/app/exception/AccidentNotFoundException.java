package com.lab.app.exception;

import com.lab.app.model.enums.ErrorType;

public class AccidentNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Accident is not found!";

    public AccidentNotFoundException() {
    }

    public AccidentNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR;
    }
}
