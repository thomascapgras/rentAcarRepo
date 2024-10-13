package com.project.rentAcar.services;

import com.project.rentAcar.dto.ContactDto;
import com.project.rentAcar.entities.Contact;

/**
 * This interface defines contact service methods.
 */
public interface ContactService {

    /**
     * Saves a contact message.
     *
     * @param contactDto the contact message to be saved
     */
    public void saveContact(ContactDto contactDto);

    /**
     * Deletes a contact message.
     *
     * @param contactDto the contact message to be deleted
     */
    public void deleteContact(ContactDto contactDto);
}
