package com.project.rentAcar.dao;

import com.project.rentAcar.entities.Reservation;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Implementation of the ReservationDao interface for managing Reservation entities.
 */
@Repository
public class ReservationDaoImpl implements ReservationDao {

    private static final Logger logger = LoggerFactory.getLogger(ReservationDaoImpl.class);

    @Autowired
    private EntityManager em;

    public ReservationDaoImpl() {
        logger.info("Enter into: " + ReservationDaoImpl.class);
    }

    /**
     * Saves a new reservation.
     *
     * @param reservation the reservation to save
     * @return the saved reservation
     * @throws RessourceAlreadyExistsException if the reservation already exists
     */
    @Override
    public Reservation saveReservation(Reservation reservation) throws RessourceAlreadyExistsException {
        logger.info("Enter into saveReservation method");
        em.persist(reservation);
        logger.info("Reservation saved");
        return reservation;
    }

    /**
     * Updates an existing reservation.
     *
     * @param reservation the reservation to update
     * @return the updated reservation
     * @throws RessourceNotFoundException if the reservation is not found
     */
    @Override
    public Reservation updateReservation(Reservation reservation) throws RessourceNotFoundException {
        logger.info("Enter into updateReservation dao method");
        this.findReservationById(reservation.getId());
        logger.info("Updated reservation: " + reservation.getId());
        return reservation;
    }

    /**
     * Deletes an existing reservation.
     *
     * @param reservation the reservation to delete
     * @return the deleted reservation
     * @throws RessourceNotFoundException if the reservation is not found
     */
    @Override
    public Reservation deleteReservation(Reservation reservation) throws RessourceNotFoundException {
        logger.info("Enter into deleteReservation method");
        this.findReservationById(reservation.getId());
        em.remove(reservation);
        logger.info("Reservation deleted: " + reservation.getId());
        return reservation;
    }

    /**
     * Finds a reservation by its ID.
     *
     * @param id the ID of the reservation
     * @return the reservation with the specified ID
     * @throws RessourceNotFoundException if the reservation is not found
     */
    @Override
    public Reservation findReservationById(int id) throws RessourceNotFoundException {
        Reservation reservation = em.find(Reservation.class, id);
        if (reservation == null) {
            throw new RessourceNotFoundException("Reservation not found with id: " + id);
        }
        logger.info("Reservation find with id : " + reservation.getId());
        return reservation;
    }

    /**
     * Finds active reservations by user ID.
     *
     * @param userId the ID of the user
     * @return a list of active reservations for the specified user
     * @throws RessourceNotFoundException if no active reservations are found for the user
     */
    @Override
    public List<Reservation> findActiveReservationByUserId(int userId) throws RessourceNotFoundException {
        logger.info("Enter into findReservationByUserId method");
        String hql = "SELECT r FROM Reservation r WHERE r.user.id = :userId and r.isActive = :active";
        TypedQuery<Reservation> query = em.createQuery(hql, Reservation.class);
        query.setParameter("userId", userId);
        query.setParameter("active", true);
        List<Reservation> reservations = query.getResultList();
        if (reservations.isEmpty()) {
            throw new RessourceNotFoundException("Reservations not found with user id: " + userId);
        }
        logger.info("Reservations found: " + reservations);
        for (Reservation reservation : reservations){
            logger.info("reservation id : " + reservation.getId());
        }
        return reservations;
    }

    /**
     * Finds reservations by return date.
     *
     * @param returnDate the return date of the reservations
     * @return a list of reservations with the specified return date
     * @throws RessourceNotFoundException if no reservations are found with the specified return date
     */
    @Override
    public List<Reservation> findReservationsByReturnDate(LocalDate returnDate) throws RessourceNotFoundException {
        logger.info("Enter into findReservationsByReturnDate method");
        TypedQuery<Reservation> query = this.em.createQuery("From Reservation where returnDate = :returnDate", Reservation.class);
        query.setParameter("returnDate", returnDate);
        List<Reservation> reservations = query.getResultList();
        if (reservations.isEmpty()) {
            throw new RessourceNotFoundException("Reservations not found with return date: " + returnDate);
        }
        logger.info("Reservations found with id : ");
        for (Reservation reservation : reservations){
            logger.info("reservation id : " + reservation.getId());
        }
        return reservations;
    }

    /**
     * Finds all reservations.
     *
     * @return a list of all reservations
     * @throws RessourceNotFoundException if no reservations are found
     */
    @Override
    public List<Reservation> findAllReservations() throws RessourceNotFoundException {
        logger.info("Enter into findAllReservations dao method");
        TypedQuery<Reservation> query = this.em.createQuery("From Reservation", Reservation.class);
        List<Reservation> reservations = query.getResultList();
        if (reservations.isEmpty()) {
            throw new RessourceNotFoundException("Available reservations not found");
        }
        logger.info("Reservations found: " + reservations);
        return reservations;
    }
}
