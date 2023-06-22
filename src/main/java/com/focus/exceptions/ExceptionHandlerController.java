package com.focus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(IncompleteDataException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessageGeneric incompleteDataExceptionHandler(IncompleteDataException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.NOT_ACCEPTABLE.value(),
                ex.getMessage(),
                "Incomplete data",
                new Date()
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ErrorMessageGeneric unauthorizedExceptionHandler(UnauthorizedException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                "Unauthorized access",
                new Date()
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessageGeneric notFoundExceptionHandler(ResourceNotFoundException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                "Resource not found",
                new Date()
        );
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessageGeneric validationExceptionHandler(ValidationException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Validation failed",
                new Date()
        );
    }

    @ExceptionHandler(DuplicateEntryException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessageGeneric duplicateEntryExceptionHandler(DuplicateEntryException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                "Duplicate entry",
                new Date()
        );
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessageGeneric invalidRequestExceptionHandler(InvalidRequestException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Invalid request",
                new Date()
        );
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageGeneric internalServerErrorExceptionHandler(InternalServerErrorException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                "Internal server error",
                new Date()
        );
    }

    @ExceptionHandler(TimeoutException.class)
    @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
    public ErrorMessageGeneric timeoutExceptionHandler(TimeoutException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.REQUEST_TIMEOUT.value(),
                ex.getMessage(),
                "Request timed out",
                new Date()
        );
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessageGeneric badRequestExceptionHandler(BadRequestException ex) {
        return new ErrorMessageGeneric(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Bad request",
                new Date()
        );
    }
}
