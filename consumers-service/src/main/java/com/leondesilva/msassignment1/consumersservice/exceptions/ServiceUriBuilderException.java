package com.leondesilva.msassignment1.consumersservice.exceptions;

public class ServiceUriBuilderException extends Exception {
    public ServiceUriBuilderException(String message) {
        super(message);
    }

    public ServiceUriBuilderException(String message, Throwable cause) {
        super(message, cause);
    }
}
