package com.focus.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("The user is not authorized to perform this action");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
