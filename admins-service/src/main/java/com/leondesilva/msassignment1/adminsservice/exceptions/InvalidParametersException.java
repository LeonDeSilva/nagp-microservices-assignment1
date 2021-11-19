package com.leondesilva.msassignment1.adminsservice.exceptions;

public class InvalidParametersException extends Exception {
    public InvalidParametersException(String message) {
        super(message);
    }

    public InvalidParametersException(String message, Throwable cause) {
        super(message, cause);
    }
}
