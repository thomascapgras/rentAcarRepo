package com.project.rentAcar.dao;

import com.project.rentAcar.entities.Contact;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class implements the ContactDao interface and provides the implementation for accessing Contact data.
 */
@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private EntityManager em;

    private static final Logger logger = LogManager.getLogger(ContactDaoImpl.class);

    public ContactDaoImpl(){
        logger.info("Enter into : " +ContactDaoImpl.class );
    }

    /**
     * Saves a new contact to the database.
     *
     * @param contact the contact to be saved
     */
    @Override
    public void saveContact(Contact contact) {
        logger.info("Enter into saveContact dao method");
        this.em.persist(contact);
        logger.info("Contact saved: " + contact);
    }

    /**
     * Deletes an existing contact from the database.
     *
     * @param contact the contact to be deleted
     */
    @Override
    public void deleteContact(Contact contact) {
        logger.info("Enter into deleteContact dao method");
        this.em.remove(contact);
        logger.info("Contact deleted: " + contact);
    }
}
