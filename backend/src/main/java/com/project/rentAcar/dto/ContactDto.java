package com.project.rentAcar.dto;

import com.project.rentAcar.entities.Contact;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

/**
 * Data Transfer Object for Contact.
 */
public class ContactDto {

    private int id;

    @NotNull(message = "Contact firstName is required")
    @Size(min = 2, max = 20, message = "Firstname must be between 2 and 20 characters")
    private String firstname;

    @NotNull(message = "Contact lastName is required")
    @Size(min = 2, max = 20, message = "Lastname must be between 2 and 20 characters")
    private String lastname;

    @NotNull(message = "Contact tel is required")
    @Size(min = 6, max = 12, message = "Tel must be between 6 and 12 characters")
    private String tel;

    @Email
    private String email;

    @NotNull(message = "Contact Message is required")
    @Size(min = 8, max = 300, message = "Message must be between 8 and 300 characters")
    private String message;

    private Instant instant = Instant.now();

    /**
     * Default constructor.
     */
    public ContactDto() {
    }

    /**
     * Constructs a ContactDto object from a Contact entity.
     *
     * @param contact the Contact entity
     */
    public ContactDto(Contact contact) {
        this.id = contact.getId();
        this.firstname = contact.getFirstname();
        this.lastname = contact.getLastname();
        this.tel = contact.getTel();
        this.email = contact.getEmail();
        this.message = contact.getMessage();
        this.instant = contact.getInstant();
    }

    // Getters and Setters with Javadoc

    /**
     * Gets the ID of the contact.
     *
     * @return the ID of the contact
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the contact.
     *
     * @param id the new ID of the contact
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the contact.
     *
     * @return the first name of the contact
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the contact.
     *
     * @param firstname the new first name of the contact
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the last name of the contact.
     *
     * @return the last name of the contact
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the contact.
     *
     * @param lastname the new last name of the contact
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the telephone number of the contact.
     *
     * @return the telephone number of the contact
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets the telephone number of the contact.
     *
     * @param tel the new telephone number of the contact
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Gets the email of the contact.
     *
     * @return the email of the contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the contact.
     *
     * @param email the new email of the contact
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the message of the contact.
     *
     * @return the message of the contact
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message of the contact.
     *
     * @param message the new message of the contact
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the instant of the contact.
     *
     * @return the instant of the contact
     */
    public Instant getInstant() {
        return instant;
    }

    /**
     * Sets the instant of the contact.
     *
     * @param instant the new instant of the contact
     */
    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", instant=" + instant +
                '}';
    }
}
