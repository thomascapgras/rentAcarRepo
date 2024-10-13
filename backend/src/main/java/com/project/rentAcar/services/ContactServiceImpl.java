package com.project.rentAcar.services;

import com.project.rentAcar.dao.ContactDao;
import com.project.rentAcar.dto.ContactDto;
import com.project.rentAcar.entities.Contact;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing contacts.
 */
@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
    @Autowired
    private ContactDao contactDao;

    public ContactServiceImpl(){
        logger.info("Enter into : " +ContactServiceImpl.class );
    }

    /**
     * Saves a new contact.
     *
     * @param contactDto the contact to be saved
     */
    @Override
    @Transactional
    public void saveContact(ContactDto contactDto) {
        logger.info("Enter into saveContact service method");
        Contact contact = new Contact(contactDto);
        this.contactDao.saveContact(contact);
    }

    /**
     * Deletes an existing contact.
     *
     * @param contactDto the contact to be deleted
     */
    @Override
    @Transactional
    public void deleteContact(ContactDto contactDto) {
        logger.info("Enter into deleteContact service method");
        Contact contact = new Contact(contactDto);
        this.contactDao.deleteContact(contact);
    }
}
