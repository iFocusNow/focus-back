package com.focus.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        super("The request is invalid");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
