package com.project.rentAcar.components;

import com.project.rentAcar.entities.Basket;
import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.Reservation;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.BasketService;
import com.project.rentAcar.services.CarService;
import com.project.rentAcar.services.ReservationService;
import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;


/**
 * This class is a Spring component responsible for updating the status of cars
 * in the rental system based on reservations. It performs updates both at server startup
 * and on a daily schedule.
 */
@Component
public class CarUpdateScheduler {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CarUpdateScheduler.class);
    @Autowired
    private CarService carService;

    @Autowired
    private BasketService basketService;


    @Autowired
    private ReservationService reservationService;

    /**
     * Initializes the car update process immediately after the server starts.
     * This method is called once after the bean has been initialized by Spring.
     */
    @PostConstruct
    public void init() throws RessourceNotFoundException, RessourceAlreadyExistsException {
        updateCarsIfNeeded();
    }
    /**
     * Schedules the car update process to run daily at midnight.
     * This method is automatically invoked by the Spring scheduler based on the cron expression.
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleCarUpdates() throws RessourceNotFoundException, RessourceAlreadyExistsException {
        updateCarsIfNeeded();
    }

    /**
     * Updates the status of cars by checking all reservations. If a reservation's return date
     * has passed, the reservation is deleted, and the car's status is updated to available.
     */
    private void updateCarsIfNeeded() throws RessourceNotFoundException, RessourceAlreadyExistsException {
        logger.info("enter into updateCarsIfNeeded method ");
        LocalDate today = LocalDate.now();
        List<Reservation> reservations = reservationService.findAllReservations();
        for (Reservation reservation : reservations) {
            if (today.isAfter(reservation.getReturnDate()) && reservation.isActive()) {
                logger.info("today is after reservation return date");
                Basket basket = reservation.getUser().getBasket();
                logger.info("reservation updating process ... : ");
                reservation.setActive(false);
                reservationService.updateReservation(reservation);
                logger.info("car updating process ... ");
                Car car = reservation.getCar();
                car.setReservation(null);
                car.setAvailable(true);
                carService.updateCar(car);
                logger.info("basket updating process ... ");
                basket.addReservation(reservation);
                basketService.updateBasket(basket);
            }
        }
    }


}
