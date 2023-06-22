package com.focus.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException() {
        super("The request is invalid");
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
