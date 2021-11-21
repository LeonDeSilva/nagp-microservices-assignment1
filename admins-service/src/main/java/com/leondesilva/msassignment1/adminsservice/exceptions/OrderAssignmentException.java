package com.leondesilva.msassignment1.adminsservice.exceptions;

/**
 * Class to represent the order assignment exception.
 */
public class OrderAssignmentException extends Exception {
    /**
     * Constructor to instantiate exception with the message.
     *
     * @param message the message to include
     */
    public OrderAssignmentException(String message) {
        super(message);
    }

    /**
     * Constructor to instantiate exception with the message and cause.
     *
     * @param message the message to include
     * @param cause   the cause to include
     */
    public OrderAssignmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
