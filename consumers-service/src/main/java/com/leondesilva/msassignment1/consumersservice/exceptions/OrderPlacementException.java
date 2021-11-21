package com.leondesilva.msassignment1.consumersservice.exceptions;

/**
 * Class to represent the order placement errors.
 */
public class OrderPlacementException extends Exception {
    /**
     * Constructor to instantiate exception with the message.
     *
     * @param message the message to include
     */
    public OrderPlacementException(String message) {
        super(message);
    }

    /**
     * Constructor to instantiate exception with the message and cause.
     *
     * @param message the message to include
     * @param cause   the cause to include
     */
    public OrderPlacementException(String message, Throwable cause) {
        super(message, cause);
    }
}
