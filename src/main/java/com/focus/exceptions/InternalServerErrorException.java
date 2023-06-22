package com.focus.exceptions;

public class InternalServerErrorException extends RuntimeException{
    public InternalServerErrorException() {
        super("Internal server error");
    }

    public InternalServerErrorException(String message, Exception e) {
        super(message + " " + e.getMessage());
    }
}
