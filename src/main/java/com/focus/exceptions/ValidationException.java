package com.focus.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException() {
        super("The validation of the data failed for fields");
    }

    public ValidationException(String message) {
        super(message);
    }
}
