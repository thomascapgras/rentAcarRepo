package com.project.rentAcar.services;

import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.dto.UserRegistrationDto;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

/**
 * This interface defines user service methods.
 */
public interface UserService {

    /**
     * Finds a user by their ID and returns a UserDto.
     *
     * @param id the ID of the user
     * @return the UserDto with the specified ID
     * @throws RessourceNotFoundException if the user is not found
     */
    public UserDto findUserByIdDto(int id) throws RessourceNotFoundException;

    /**
     * Finds a user by their ID.
     *
     * @param id the ID of the user
     * @return the user with the specified ID
     * @throws RessourceNotFoundException if the user is not found
     */
    public User findUserById(int id) throws RessourceNotFoundException;

    /**
     * Finds a user by their email and returns a UserDto.
     *
     * @param email the email of the user
     * @return the UserDto with the specified email
     * @throws RessourceNotFoundException if the user is not found
     */
    public UserDto findUserByEmailDto(String email) throws RessourceNotFoundException;

    /**
     * Finds a user by their email.
     *
     * @param email the email of the user
     * @return the user with the specified email
     * @throws RessourceNotFoundException if the user is not found
     */
    public User findUserByEmail(String email) throws RessourceNotFoundException;

    /**
     * Checks if a user exists by their email.
     *
     * @param email the email to check
     * @throws RessourceAlreadyExistsException if the user already exists
     */
    public void existsByEmail(String email) throws RessourceAlreadyExistsException;

    /**
     * Finds a user's ID by their email.
     *
     * @param email the email of the user
     * @return the ID of the user with the specified email
     * @throws RessourceNotFoundException if the user is not found
     */
    public int findUserIdByEmail(String email) throws RessourceNotFoundException;
}
