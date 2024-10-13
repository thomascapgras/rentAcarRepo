package com.project.rentAcar.entities;

import com.project.rentAcar.dto.ContactDto;
import jakarta.persistence.*;
import java.time.Instant;

/**
 * Entity representing a contact message.
 */
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first-name")
    private String firstname;

    @Column(name = "last-name")
    private String lastname;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

    @Column(name = "message", length = 300)
    private String message;

    @Column(name = "timestamp")
    private Instant instant = Instant.now();

    /**
     * Default constructor.
     */
    public Contact() {
    }

    /**
     * Constructs a Contact with the specified details.
     *
     * @param firstname the first name of the contact
     * @param lastname  the last name of the contact
     * @param tel       the telephone number of the contact
     * @param email     the email of the contact
     * @param message   the message from the contact
     * @param instant   the timestamp when the contact was created
     */
    public Contact(String firstname, String lastname, String tel, String email, String message, Instant instant) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.tel = tel;
        this.email = email;
        this.message = message;
        this.instant = instant;
    }


    /**
     * Constructs a Contact with the specified details.
     *
     * @param contactDto the contactDto details

     */
    public Contact (ContactDto contactDto){
        this.id = contactDto.getId();
        this.firstname = contactDto.getFirstname();
        this.lastname = contactDto.getLastname();
        this.tel = contactDto.getTel();
        this.email = contactDto.getEmail();
        this.message = contactDto.getMessage();
    }

    /**
     * Constructs a Contact with the specified details, excluding the timestamp.
     *
     * @param firstname the first name of the contact
     * @param lastname  the last name of the contact
     * @param tel       the telephone number of the contact
     * @param email     the email of the contact
     * @param message   the message from the contact
     */
    public Contact(String firstname, String lastname, String tel, String email, String message) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.tel = tel;
        this.email = email;
        this.message = message;
    }

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
     * Gets the message from the contact.
     *
     * @return the message from the contact
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message from the contact.
     *
     * @param message the new message from the contact
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the timestamp when the contact was created.
     *
     * @return the timestamp when the contact was created
     */
    public Instant getInstant() {
        return instant;
    }

    /**
     * Sets the timestamp when the contact was created.
     *
     * @param instant the new timestamp when the contact was created
     */
    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    /**
     * Returns a string representation of the Contact.
     *
     * @return a string representation of the Contact
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contact{");
        sb.append("id=").append(id);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", instant=").append(instant);
        sb.append('}');
        return sb.toString();
    }
}
