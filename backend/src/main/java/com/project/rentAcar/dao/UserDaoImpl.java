package com.project.rentAcar.dao;

import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class implements the UserDao interface and provides the implementation for accessing User data.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private EntityManager em;

    public UserDaoImpl() {
        logger.info("Enter into: " + UserDaoImpl.class);
    }

    /**
     * Saves a new user to the database.
     *
     * @param user the user to be saved
     * @return the saved user
     */
    @Override
    public User saveUser(User user) {
        logger.info("Enter into saveUser method");
        this.em.persist(user);
        logger.info("User saved: " + user.getEmail());
        return user;
    }

    /**
     * Finds a user by its ID.
     *
     * @param id the ID of the user to search for
     * @return the user with the specified ID
     */
    @Override
    public User findUserbyId(int id) throws RessourceNotFoundException {
        logger.info("Enter into findUserById method");
        User user = this.em.find(User.class, id);
        if (user == null) {
            throw new RessourceNotFoundException("User not found for id: " + id);
        }
        logger.info("User found: " + user.getEmail());
        return user;
    }

    /**
     * Finds a user by its email.
     *
     * @param mail the email of the user to search for
     * @return the user with the specified email, or null if no user is found
     */
    @Override
    public User findUserByEmail(String mail) throws RessourceNotFoundException {
        logger.info("Enter into findUserByEmail method");
        TypedQuery<User> query = this.em.createQuery("FROM User WHERE email = :mail", User.class);
        query.setParameter("mail", mail);
        try {
            User user = query.getSingleResult();
            logger.info("User found: " + user.getEmail());
            return user;
        } catch (NoResultException e) {
            logger.info("User not found with mail: " + mail);
            throw new RessourceNotFoundException("User not found with mail: " + mail);
        }
    }

    /**
     * Checks if a user exists by its email.
     *
     * @param mail the email to check
     */
    @Override
    public void existsByEmail(String mail) throws RessourceAlreadyExistsException {
        logger.info("Enter into existsByEmail method");
        TypedQuery<Long> query = this.em.createQuery("SELECT COUNT(p) FROM User p WHERE p.email = :mail", Long.class);
        query.setParameter("mail", mail);
        Long count = query.getSingleResult();
        logger.info("Number of mails existing: " + count);
        if (count>0){
            throw new RessourceAlreadyExistsException("User already exists with email : " + mail);
        }
    }

    /**
     * Finds a user ID by the user's email.
     *
     * @param email the email of the user to search for
     * @return the ID of the user with the specified email, or null if no user is found
     */
    @Override
    public int findUserIdByEmail(String email) throws RessourceNotFoundException {
        logger.info("Enter into findUserIdByEmail method");
        TypedQuery<User> query = this.em.createQuery("FROM User WHERE email = :mail", User.class);
        query.setParameter("mail", email);
        try {
            User user = query.getSingleResult();
            logger.info("User found: " + user.getEmail());
            return user.getId();
        } catch (NoResultException e) {
            logger.info("User not found with email: " + email);
            throw new RessourceNotFoundException("User not found with email: " + email);
        }
    }

}
