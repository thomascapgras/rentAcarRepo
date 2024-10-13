package com.project.rentAcar.services;

import com.project.rentAcar.dao.ReservationDao;
import com.project.rentAcar.dto.CarDto;
import com.project.rentAcar.dto.ReservationDto;
import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.Reservation;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for managing reservations.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    public ReservationServiceImpl() {
        logger.info("Enter into : " + ReservationServiceImpl.class);
    }

    /**
     * Saves a new reservation.
     *
     * @param reservationDto the reservation to be saved
     * @param userId the ID of the user
     * @return the saved reservationDto
     */
    @Override
    @Transactional
    public ReservationDto saveReservation(ReservationDto reservationDto, int userId)
            throws RessourceNotFoundException, RessourceAlreadyExistsException {
        logger.info("Enter into saveReservation service method ");
        Reservation reservation = new Reservation(reservationDto);
        User user = this.userService.findUserById(userId);
        Car car = this.carService.findCarById(reservationDto.getCarDto().getId());

        reservation.setUser(user);
        reservation.setCar(car);
        reservation.setActive(true);
        reservation = reservationDao.saveReservation(reservation);
        car.setAvailable(false);
        this.carService.updateCar(car);
        return new ReservationDto(reservation);
    }



    /**
     * Deletes an existing reservation.
     *
     * @param reservationDto the reservation to be deleted
     * @return the deleted reservationDto
     */
    @Override
    @Transactional
    public ReservationDto deleteReservation(ReservationDto reservationDto) throws RessourceNotFoundException {
        logger.info("Enter into deleteReservation service method ");
        Reservation reservation = this.reservationDao.findReservationById(reservationDto.getId());
        Reservation deletedReservation = reservationDao.deleteReservation(reservation);
        Car car = this.carService.findCarById(reservationDto.getCarDto().getId());
        car.setAvailable(true);
        this.carService.updateCar(car);
        return new ReservationDto(deletedReservation);
    }


    /**
     * Finds a reservation by its ID.
     *
     * @param id the ID of the reservation
     * @return the reservationDto with the specified ID, or null if not found
     */
    @Override
    public ReservationDto findReservationById(int id) throws RessourceNotFoundException {
        logger.info("Enter into findReservationById service method ");
        Reservation reservation = reservationDao.findReservationById(id);
        if (reservation==null){
            throw new RessourceNotFoundException("reservation not found with id : " + id);
        }
        ReservationDto reservationDto = new ReservationDto(reservation);
        return reservationDto;
    }

    /**
     * Updates an existing reservation.
     *
     * @param reservation the reservation to be updated
     * @return the updated reservationDto
     */
    @Override
    @Transactional
    public Reservation updateReservation(Reservation reservation) throws RessourceNotFoundException {
        logger.info("Enter into updateReservation service method ");
        return this.reservationDao.updateReservation(reservation);
    }

    /**
     * Finds reservations by the user ID.
     *
     * @param id the ID of the user
     * @return a list of reservationsDto associated with the specified user ID
     */
    @Override
    public List<ReservationDto> findActiveReservationByUserId(int id) throws RessourceNotFoundException {
        logger.info("Enter into findReservationByUserId service method ");
        List<Reservation> reservations = this.reservationDao.findActiveReservationByUserId(id);
        List<ReservationDto> reservationsDto = new ArrayList<>();
        for(Reservation reservation : reservations){
            reservationsDto.add(new ReservationDto(reservation));
        }
        return reservationsDto;
    }

    /**
     * Finds reservations by the return date.
     *
     * @param returnDate the return date of the reservations
     * @return a list of reservationsDto with the specified return date
     */
    @Override
    public List<ReservationDto> findReservationsByReturnDate(LocalDate returnDate) throws RessourceNotFoundException {
        logger.info("Enter into findReservationsByReturnDate service method ");
        List<Reservation> reservations = this.reservationDao.findReservationsByReturnDate(returnDate);
        List<ReservationDto> reservationsDto = new ArrayList<>();
        for(Reservation reservation : reservations){
            reservationsDto.add(new ReservationDto(reservation));
        }
        return reservationsDto;
    }

    /**
     * Finds all reservations.
     *
     * @return a list of all reservationsDto
     */
    @Override
    public List<ReservationDto> findAllReservationsDto() throws RessourceNotFoundException{
        logger.info("Enter into findAllReservations service method ");
        List<Reservation> reservations = this.reservationDao.findAllReservations();
        List<ReservationDto> reservationsDto = new ArrayList<>();
        for(Reservation reservation : reservations){
            reservationsDto.add(new ReservationDto(reservation));
        }
        return reservationsDto;
    }


    /**
     * Finds all reservations.
     *
     * @return a list of all reservations
     */
    public List<Reservation> findAllReservations() throws RessourceNotFoundException{
        logger.info("Enter into findAllReservations service method ");
        List<Reservation> reservations = this.reservationDao.findAllReservations();
        return reservations;
    }
}
