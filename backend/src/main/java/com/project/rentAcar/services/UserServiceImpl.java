package com.project.rentAcar.services;

import com.project.rentAcar.dao.UserDao;
import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.dto.UserRegistrationDto;
import com.project.rentAcar.entities.Authorities;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Service implementation for managing users.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    public UserServiceImpl(){
        logger.info("Enter into : " +UserServiceImpl.class );
    }


    /**
     * Finds a user by its ID.
     *
     * @param id the ID of the user
     * @return the userDto with the specified ID, or null if not found
     */
    @Override
    public UserDto findUserByIdDto(int id) throws RessourceNotFoundException {
        logger.info("Enter into findUserByIdDto service method");
        User user = this.userDao.findUserbyId(id);
        UserDto userDto = new UserDto(user);
        return userDto;
    }

    /**
     * Finds a user by its ID.
     *
     * @param id the ID of the user
     * @return the user with the specified ID, or null if not found
     */
    @Override
    public User findUserById(int id) throws RessourceNotFoundException {
        logger.info("Enter into findUserById service method");
        User user = this.userDao.findUserbyId(id);
        return user;
    }

    /**
     * Finds a user by its email.
     *
     * @param mail the email of the user
     * @return the userDto with the specified email, or null if not found
     */
    @Override
    public UserDto findUserByEmailDto(String mail) throws RessourceNotFoundException {
        logger.info("Enter into findUserByEmailDto service method");
        User user = this.userDao.findUserByEmail(mail);
        UserDto userDto = new UserDto(user);
        return userDto;
    }

    /**
     * Finds a user by its email.
     *
     * @param mail the email of the user
     * @return the user with the specified email, or null if not found
     */
    @Override
    public User findUserByEmail(String mail) throws RessourceNotFoundException {
        logger.info("Enter into findUserByEmail service method");
        User user = this.userDao.findUserByEmail(mail);
        return user;
    }

    /**
     * Checks if a user exists by its email.
     *
     * @param mail the email to check
     */
    @Override
    public void existsByEmail(String mail) throws RessourceAlreadyExistsException {
        logger.info("Enter into existsByEmail service method");
        this.userDao.existsByEmail(mail);
    }


    /**
     * Finds a user ID by its email.
     *
     * @param email the email of the user
     * @return the ID of the user with the specified email
     */
    @Override
    public int findUserIdByEmail(String email) throws RessourceNotFoundException {
        logger.info("enter into findUserIdByEmail service method");
        return this.userDao.findUserIdByEmail(email);
    }


}
