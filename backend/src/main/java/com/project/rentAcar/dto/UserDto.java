package com.project.rentAcar.dto;

import com.project.rentAcar.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for the User entity.
 * This class is used to transfer data between different layers of the application.
 */
public class UserDto {
    private int id;
    @Email
    @NotNull(message = "Email is required")
    private String email;

    /**
     * Constructs a UserDto from a User entity.
     *
     * @param user the User entity
     */
    public UserDto(User user) {
        this.email = user.getEmail();
        this.id = user.getId();
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the new email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the ID of the user.
     *
     * @return the ID of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the new ID of the user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns a string representation of the UserDto.
     *
     * @return a string representation of the UserDto
     */
    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
