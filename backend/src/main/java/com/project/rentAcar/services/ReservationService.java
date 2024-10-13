package com.project.rentAcar.services;

import com.project.rentAcar.dto.ReservationDto;
import com.project.rentAcar.entities.Reservation;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

/**
 * This interface defines reservation service methods.
 */
public interface ReservationService {


    /**
     * Saves a new reservation.
     *
     * @param reservationDto the reservation to be saved
     * @param UserId the ID of the user making the reservation
     * @return the saved ReservationDto
     * @throws RessourceNotFoundException if the user or car is not found
     * @throws RessourceAlreadyExistsException if the reservation already exists
     */
    public ReservationDto saveReservation(ReservationDto reservationDto, int UserId) throws RessourceNotFoundException, RessourceAlreadyExistsException;

    /**
     * Deletes an existing reservation.
     *
     * @param reservationDto the reservation to be deleted
     * @return the deleted ReservationDto
     * @throws RessourceNotFoundException if the reservation is not found
     */
    public ReservationDto deleteReservation(ReservationDto reservationDto) throws RessourceNotFoundException;

    /**
     * Finds a reservation by its ID.
     *
     * @param id the ID of the reservation
     * @return the ReservationDto with the specified ID
     * @throws RessourceNotFoundException if the reservation is not found
     */
    public ReservationDto findReservationById(int id) throws RessourceNotFoundException;

    /**
     * Updates an existing reservation.
     *
     * @param reservation the reservation to be updated
     * @return the updated reservation
     * @throws RessourceNotFoundException if the reservation is not found
     */
    public Reservation updateReservation(Reservation reservation) throws RessourceNotFoundException;

    /**
     * Finds active reservations by user ID.
     *
     * @param id the ID of the user
     * @return a list of active ReservationDto objects for the specified user ID
     * @throws RessourceNotFoundException if no reservations are found for the user
     */
    public List<ReservationDto> findActiveReservationByUserId(int id) throws RessourceNotFoundException;

    /**
     * Finds reservations by return date.
     *
     * @param returnDate the return date to search for reservations
     * @return a list of ReservationDto objects with the specified return date
     * @throws RessourceNotFoundException if no reservations are found for the return date
     */
    public List<ReservationDto> findReservationsByReturnDate(LocalDate returnDate) throws RessourceNotFoundException;

    /**
     * Finds all reservations as DTOs.
     *
     * @return a list of all ReservationDto objects
     * @throws RessourceNotFoundException if no reservations are found
     */
    public List<ReservationDto> findAllReservationsDto() throws RessourceNotFoundException;

    /**
     * Finds all reservations.
     *
     * @return a list of all Reservation objects
     * @throws RessourceNotFoundException if no reservations are found
     */
    public List<Reservation> findAllReservations() throws RessourceNotFoundException;
}
