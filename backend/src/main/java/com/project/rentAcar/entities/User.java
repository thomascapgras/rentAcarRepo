package com.project.rentAcar.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.rentAcar.dto.UserRegistrationDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Entity representing a user.
 */
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email", unique = true)
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Size(min = 6, max = 25, message = "Email length must be between 6 and 25")
    private String email;

    @Column(name = "pwd")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Password length must be greater than 8")
    private String pwd;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Authorities> authorities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Basket basket;

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructs a User with the specified details.
     *
     * @param email the email of the user
     * @param pwd   the password of the user
     */
    public User(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    /**
     * Constructs a User from a UserRegistrationDto.
     *
     * @param userRegistrationDto the UserRegistrationDto
     */
    public User(UserRegistrationDto userRegistrationDto) {
        this.id = userRegistrationDto.getId();
        this.email = userRegistrationDto.getEmail();
        this.pwd = userRegistrationDto.getPwd();
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
     * Gets the list of authorities of the user.
     *
     * @return the list of authorities of the user
     */
    public List<Authorities> getAuthorities() {
        return authorities;
    }

    /**
     * Sets the list of authorities of the user.
     *
     * @param authorities the new list of authorities of the user
     */
    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    /**
     * Gets the basket associated with the user.
     *
     * @return the basket associated with the user
     */
    public Basket getBasket() {
        return basket;
    }

    /**
     * Sets the basket associated with the user.
     *
     * @param basket the new basket associated with the user
     */
    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    /**
     * Adds a reservation to the user's list of reservations.
     *
     * @param reservation the reservation to be added
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setUser(this);
    }

    /**
     * Removes a reservation from the user's list of reservations.
     *
     * @param reservation the reservation to be removed
     */
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setUser(null);
    }

    /**
     * Returns a string representation of the User.
     *
     * @return a string representation of the User
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", reservations=").append(reservations != null ? reservations.stream().map(Reservation::getId).collect(Collectors.toList()) : "null");
        sb.append(", basket=").append(basket != null ? basket.getId() : "null");
        sb.append('}');
        return sb.toString();
    }
}
