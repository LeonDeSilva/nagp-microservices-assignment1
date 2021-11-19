package com.leondesilva.msassignment1.consumersservice.exceptions;

public class OrderPlacementException extends Exception {
    public OrderPlacementException(String message) {
        super(message);
    }

    public OrderPlacementException(String message, Throwable cause) {
        super(message, cause);
    }
}
