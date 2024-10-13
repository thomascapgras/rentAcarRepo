package com.project.rentAcar.services;

import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.dto.UserRegistrationDto;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

/**
 * Service created to break the circular dependency between user and basket services.
 */
public interface UserRegistrationService {

    /**
     * Saves a new user and creates a basket for the user.
     *
     * @param userRegistrationDto the user registration data
     * @return the saved UserDto
     * @throws RessourceNotFoundException if the user or basket is not found
     * @throws RessourceAlreadyExistsException if the user already exists
     */
    public UserDto saveUserAndCreateBasket(UserRegistrationDto userRegistrationDto) throws RessourceNotFoundException, RessourceAlreadyExistsException;

    /**
     * Saves a new user with OAuth2 and creates a basket for the user.
     *
     * @param token the OAuth2 token
     * @return the saved UserDto
     * @throws RessourceNotFoundException if the user or basket is not found
     */
    public UserDto saveUserWithOuath2AndCreateBasket(String token) throws RessourceNotFoundException;
}
