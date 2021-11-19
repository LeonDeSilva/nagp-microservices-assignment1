package com.leondesilva.msassignment1.adminsservice.exceptions;

public class ServiceUriBuilderException extends Exception {
    public ServiceUriBuilderException(String message) {
        super(message);
    }

    public ServiceUriBuilderException(String message, Throwable cause) {
        super(message, cause);
    }
}
