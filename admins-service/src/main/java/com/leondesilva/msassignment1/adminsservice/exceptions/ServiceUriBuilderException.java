package com.leondesilva.msassignment1.adminsservice.exceptions;

/**
 * Class to represent the service URI builder errors.
 */
public class ServiceUriBuilderException extends Exception {
    /**
     * Constructor to instantiate exception with the message.
     *
     * @param message the message to include
     */
    public ServiceUriBuilderException(String message) {
        super(message);
    }

    /**
     * Constructor to instantiate exception with the message and cause.
     *
     * @param message the message to include
     * @param cause   the cause to include
     */
    public ServiceUriBuilderException(String message, Throwable cause) {
        super(message, cause);
    }
}
