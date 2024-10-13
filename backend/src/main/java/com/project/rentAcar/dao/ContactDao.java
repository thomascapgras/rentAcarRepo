package com.project.rentAcar.dao;

import com.project.rentAcar.entities.Contact;

/**
 * This interface defines methods for managing Contact entities.
 */
public interface ContactDao {

    /**
     * Saves a new contact.
     *
     * @param contact the contact to save
     */
    public void saveContact(Contact contact);

    /**
     * Deletes an existing contact.
     *
     * @param contact the contact to delete
     */
    public void deleteContact(Contact contact);
}
