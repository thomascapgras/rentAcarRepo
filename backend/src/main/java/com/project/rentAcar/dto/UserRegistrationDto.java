package com.project.rentAcar.dto;

import com.project.rentAcar.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Data Transfer Object (DTO) for user registration.
 * This class is used to transfer data between different layers of the application.
 */
public class UserRegistrationDto {

    private int id;
    @Email
    @NotNull(message = "Email is required")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@$!%*?&])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "Password must be between 8 and 20 characters, contain at least one uppercase letter, one special character, and one digit")
    private String pwd;

    /**
     * Default constructor.
     */
    public UserRegistrationDto() {
    }

    /**
     * Constructs a UserRegistrationDto from a User entity.
     *
     * @param user the User entity
     */
    public UserRegistrationDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.pwd = user.getPwd();
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
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Sets the password of the user.
     *
     * @param pwd the new password of the user
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Returns a string representation of the UserRegistrationDto.
     *
     * @return a string representation of the UserRegistrationDto
     */
    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
