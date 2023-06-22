package com.focus.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessageGeneric {
    private int status;
    private String message;
    private String description;
    private Date timestamp;

    public ErrorMessageGeneric(int status, String message, String description) {
        this.status = status;
        this.message = message;
        this.description = description;
        this.timestamp = new Date();
    }
}
