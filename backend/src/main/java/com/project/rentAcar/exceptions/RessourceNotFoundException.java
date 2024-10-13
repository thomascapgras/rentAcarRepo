package com.project.rentAcar.exceptions;

/**
 * Exception thrown when a resource is not found.
 */
public class RessourceNotFoundException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message
     */
    public RessourceNotFoundException(String message) {
        super(message);
    }
}
