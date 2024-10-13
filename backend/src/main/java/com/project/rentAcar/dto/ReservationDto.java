package com.project.rentAcar.dto;

import com.project.rentAcar.entities.Reservation;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.validators.ValidDepartureDate;
import com.project.rentAcar.validators.ValidId;
import com.project.rentAcar.validators.ValidReturnDate;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for the Reservation entity.
 * This class is used to transfer data between different layers of the application.
 */
@ValidReturnDate
public class ReservationDto {

    private int id;

    private int userId;
    @Enumerated(EnumType.STRING)
    private Cities city;
    @NotNull(message = "departureDate is required")
    @ValidDepartureDate()
    private LocalDate departureDate;
    @NotNull(message = "returnDate is required")
    private LocalDate returnDate;
    @NotNull(message = "CarDto is required")
    private CarDto carDto;
    private boolean isActive;

    /**
     * Default constructor.
     */
    public ReservationDto() {
    }

    /**
     * Constructs a ReservationDto from a Reservation entity.
     *
     * @param reservation the Reservation entity
     */
    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.departureDate = reservation.getDepartureDate();
        this.returnDate = reservation.getReturnDate();
        this.carDto = new CarDto(reservation.getCar());
        this.city = reservation.getCity();
        this.isActive = reservation.isActive();
    }

    /**
     * Constructs a ReservationDto from a Reservation entity.
     *
     * @param reservation the Reservation entity
     * @param userId the id of theu user
     */
    public ReservationDto(Reservation reservation,int userId) {
        this.id = reservation.getId();
        this.departureDate = reservation.getDepartureDate();
        this.returnDate = reservation.getReturnDate();
        this.carDto = new CarDto(reservation.getCar());
        this.city = reservation.getCity();
        this.isActive = reservation.isActive();
        this.userId = userId;
    }

    /**
     * Gets the ID of the reservation.
     *
     * @return the ID of the reservation
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the reservation.
     *
     * @param id the new ID of the reservation
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the departure date of the reservation.
     *
     * @return the departure date of the reservation
     */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the departure date of the reservation.
     *
     * @param departureDate the new departure date of the reservation
     */
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Gets the return date of the reservation.
     *
     * @return the return date of the reservation
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the return date of the reservation.
     *
     * @param returnDate the new return date of the reservation
     */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Gets the CarDto associated with the reservation.
     *
     * @return the CarDto associated with the reservation
     */
    public CarDto getCarDto() {
        return carDto;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Sets the CarDto associated with the reservation.
     *
     * @param carDto the new CarDto associated with the reservation
     */
    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    /**
     * Gets the city of the reservation.
     *
     * @return the city of the reservation
     */
    public Cities getCity() {
        return city;
    }

    /**
     * Sets the city of the reservation.
     *
     * @param city the new city of the reservation
     */
    public void setCity(Cities city) {
        this.city = city;
    }

    /**
     * Checks if the reservation is active.
     *
     * @return true if the reservation is active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active status of the reservation.
     *
     * @param active the new active status of the reservation
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Returns a string representation of the ReservationDto.
     *
     * @return a string representation of the ReservationDto
     */
    @Override
    public String toString() {
        return "ReservationDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", city=" + city +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                ", carDto=" + carDto +
                ", isActive=" + isActive +
                '}';
    }
}
