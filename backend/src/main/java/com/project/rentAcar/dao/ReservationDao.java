
package com.project.rentAcar.dao;

import com.project.rentAcar.entities.Reservation;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import java.time.LocalDate;
import java.util.List;

/**
 * This interface defines methods for managing Reservation entities.
 */
public interface ReservationDao {

    /**
     * Saves a new reservation.
     *
     * @param reservation the reservation to save
     * @return the saved reservation
     * @throws RessourceAlreadyExistsException if the reservation already exists
     * @throws RessourceNotFoundException if related resources are not found
     */
    public Reservation saveReservation(Reservation reservation) throws RessourceAlreadyExistsException, RessourceNotFoundException;

    /**
     * Deletes an existing reservation.
     *
     * @param reservation the reservation to delete
     * @return the deleted reservation
     * @throws RessourceNotFoundException if the reservation is not found
     */
    public Reservation deleteReservation(Reservation reservation) throws RessourceNotFoundException;

    /**
     * Finds a reservation by its ID.
     *
     * @param id the ID of the reservation
     * @return the reservation with the specified ID
     * @throws RessourceNotFoundException if the reservation is not found
     */
    public Reservation findReservationById(int id) throws RessourceNotFoundException;

    /**
     * Finds all reservations.
     *
     * @return a list of all reservations
     * @throws RessourceNotFoundException if no reservations are found
     */
    public List<Reservation> findAllReservations() throws RessourceNotFoundException;

    /**
     * Finds active reservations by user ID.
     *
     * @param id the ID of the user
     * @return a list of active reservations for the specified user
     * @throws RessourceNotFoundException if no active reservations are found for the user
     */
    public List<Reservation> findActiveReservationByUserId(int id) throws RessourceNotFoundException;

    /**
     * Finds reservations by return date.
     *
     * @param returnDate the return date of the reservations
     * @return a list of reservations with the specified return date
     * @throws RessourceNotFoundException if no reservations are found with the specified return date
     */
    public List<Reservation> findReservationsByReturnDate(LocalDate returnDate) throws RessourceNotFoundException;

    /**
     * Updates an existing reservation.
     *
     * @param reservation the reservation to update
     * @return the updated reservation
     * @throws RessourceNotFoundException if the reservation is not found
     */
    public Reservation updateReservation(Reservation reservation) throws RessourceNotFoundException;


}
