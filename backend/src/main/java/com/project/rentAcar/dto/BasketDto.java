package com.project.rentAcar.dto;

import com.project.rentAcar.entities.Basket;
import com.project.rentAcar.entities.Reservation;
import com.project.rentAcar.entities.User;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object (DTO) for the Basket entity.
 * This class is used to transfer data between different layers of the application.
 */
public class BasketDto {

    private int id;
    @NotNull(message = "Reservations are required")
    private List<ReservationDto> reservationDtos = new ArrayList<>();
    @NotNull (message="User is required")
    private UserDto userDto;

    /**
     * Constructs a BasketDto from a Basket entity.
     *
     * @param basket the Basket entity
     */
    public BasketDto(Basket basket) {
        this.id = basket.getId();
        for (Reservation reservation : basket.getReservations()) {
            this.reservationDtos.add(new ReservationDto(reservation));
        }
    }

    /**
     * Constructs a BasketDto from a User entity.
     *
     * @param user the User entity
     */
    public BasketDto(User user) {
        this.userDto = new UserDto(user);
    }

    /**
     * Constructs a BasketDto from a Basket entity and a User entity.
     *
     * @param basket the Basket entity
     * @param user the User entity
     */
    public BasketDto(Basket basket, User user) {
        this.id = basket.getId();
        this.userDto = new UserDto(user);
        for (Reservation reservation : basket.getReservations()) {
            this.reservationDtos.add(new ReservationDto(reservation));
        }
    }

    /**
     * Constructs a BasketDto with a user ID.
     *
     * @param userId the user ID
     */
    public BasketDto(int userId) {
        this.id = userId;
    }

    /**
     * Gets the ID of the basket.
     *
     * @return the ID of the basket
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the basket.
     *
     * @param id the new ID of the basket
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the list of ReservationDto objects associated with the basket.
     *
     * @return the list of ReservationDto objects
     */
    public List<ReservationDto> getReservationDtos() {
        return reservationDtos;
    }

    /**
     * Sets the list of ReservationDto objects associated with the basket.
     *
     * @param reservationDtos the new list of ReservationDto objects
     */
    public void setReservationDtos(List<ReservationDto> reservationDtos) {
        this.reservationDtos = reservationDtos;
    }

    /**
     * Gets the UserDto associated with the basket.
     *
     * @return the UserDto
     */
    public UserDto getUserDto() {
        return userDto;
    }

    /**
     * Sets the UserDto associated with the basket.
     *
     * @param userDto the new UserDto
     */
    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    /**
     * Returns a string representation of the BasketDto.
     *
     * @return a string representation of the BasketDto
     */
    @Override
    public String toString() {
        return "BasketDto{" +
                "id=" + id +
                ", reservationDtos=" + reservationDtos +
                ", userDto=" + userDto +
                '}';
    }
}
