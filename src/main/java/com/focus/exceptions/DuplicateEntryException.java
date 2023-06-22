package com.focus.exceptions;

public class DuplicateEntryException extends RuntimeException{
    public DuplicateEntryException() {
        super("The data already exists in the database");
    }

    public DuplicateEntryException(String message) {
        super(message);
    }
}
