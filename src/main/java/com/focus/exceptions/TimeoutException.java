package com.focus.exceptions;

public class TimeoutException extends RuntimeException{
    public TimeoutException() {
        super("The request has timed out");
    }

    public TimeoutException(String message) {
        super(message);
    }
}
