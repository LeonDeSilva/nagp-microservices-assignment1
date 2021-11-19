package com.leondesilva.msassignment1.adminsservice.exceptions;

public class OrderAssignmentException extends Exception {
    public OrderAssignmentException(String message) {
        super(message);
    }

    public OrderAssignmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
