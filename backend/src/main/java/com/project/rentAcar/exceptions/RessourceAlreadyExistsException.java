package com.project.rentAcar.exceptions;

/**
 * Exception thrown when a resource already exists.
 */
public class RessourceAlreadyExistsException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message
     */
    public RessourceAlreadyExistsException(String message) {
        super(message);
    }
}
