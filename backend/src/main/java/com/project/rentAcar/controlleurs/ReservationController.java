package com.project.rentAcar.controlleurs;

import com.project.rentAcar.components.MessagesConfig;
import com.project.rentAcar.dto.ReservationDto;
import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.entities.Reservation;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.CarService;
import com.project.rentAcar.services.EmailService;
import com.project.rentAcar.services.ReservationService;
import com.project.rentAcar.services.UserService;
import com.project.rentAcar.validators.ValidId;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * This controller handles reservation-related endpoints.
 */
@RestController
@RequestMapping("/reservation")
@Validated
public class ReservationController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReservationController.class);
    @Autowired
    private  MessagesConfig messagesConfig;

    public ReservationController(){
        logger.info("Enter into : " + ReservationController.class);
    }
    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ReservationService reservationService;

    /**
     * Finds a reservation by its ID.
     *
     * @param id the ID of the reservation to search for
     * @return a response entity containing the reservation and HTTP status OK, or a message with HTTP status NOT FOUND if no reservation is found
     */
    @GetMapping("/getReservationById/{id}")
    public ResponseEntity<?> getReservationById(   @PathVariable @ValidId(entityClass = Reservation.class) int id) throws RessourceNotFoundException {
        logger.info("Enter into findReservationById endpoint method" );
        try{
            ReservationDto reservationDto = reservationService.findReservationById(id);
            logger.info("Sending back reservation");
            return new ResponseEntity<>(reservationDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Finds reservations by the user's ID.
     *
     * @param id the ID of the user to search reservations for
     * @return a response entity containing the list of reservations and HTTP status OK, or a message with HTTP status NOT FOUND if no reservations are found
     */
    @GetMapping("/getReservationsByUserId/{id}")
    public ResponseEntity<?> getReservationsByUserId(@PathVariable @ValidId(entityClass = User.class) int id) {
        logger.info("Enter into findReservationsByUserId endpoint method" );
        try{
            List<ReservationDto> reservationsDto = reservationService.findActiveReservationByUserId(id);
            logger.info("Sending back reservations");
            return new ResponseEntity<>(reservationsDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Saves a new reservation for a car and a user.
     *
     * @param reservationDto the reservation to be saved
     * @param userId the ID of the user making the reservation
     * @return a response entity containing the saved reservation and HTTP status CREATED, or a message with appropriate HTTP status if the car is not found or not available
     */
    @PostMapping("/saveReservation")
    public ResponseEntity<?> saveReservation(@RequestBody @Valid ReservationDto reservationDto,
                                             @RequestParam @ValidId(entityClass = User.class) int  userId) {
        logger.info("enter into saveReservation endpoint method");
        try {
            ReservationDto savedReservationDto= this.reservationService.saveReservation(reservationDto, userId);
            logger.info("Sending back reservation");
            String confirmationMessageTitle = this.messagesConfig.getConfirmationMessageTitle()
                    .replace("{departureDate}", savedReservationDto.getDepartureDate().toString())
                    .replace("{returnDate}", savedReservationDto.getReturnDate().toString());
            String confirmationMessageText = this.messagesConfig.getConfirmationMessageText();
            UserDto userDto= this.userService.findUserByIdDto(userId);
            this.emailService.sendSimpleMessage(userDto.getEmail(),confirmationMessageTitle,confirmationMessageText);
            return new ResponseEntity<>(savedReservationDto, HttpStatus.CREATED);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (RessourceAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a reservation by its ID and sends a cancellation email to the user.
     *
     * @param id the ID of the reservation to be deleted
     * @param userId the ID of the user who owns the reservation
     * @return a ResponseEntity containing the deleted reservation and HTTP status OK,
     *         or a message with HTTP status NOT FOUND if no reservation is found,
     *         or a message with HTTP status INTERNAL_SERVER_ERROR if an unexpected error occurs
     */
    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<?> deleteReservationById(@PathVariable int id,
                                                   @RequestParam @ValidId(entityClass = User.class) int userId){
        logger.info("enter into deleteReservationById endpoint method");
       try {
           ReservationDto reservationDto = this.reservationService.findReservationById(id);
           ReservationDto deletedReservationDto=this.reservationService.deleteReservation(reservationDto);
           logger.info("sending back reservation");
           String cancelationMessageTitle = this.messagesConfig.getCancellationMessageTitle()
                   .replace("{departureDate}", deletedReservationDto.getReturnDate().toString())
                   .replace("{returnDate}", deletedReservationDto.getReturnDate().toString());
           String cancellationMessageText = this.messagesConfig.getCancellationMessageText();
           UserDto userDto= this.userService.findUserByIdDto(userId);
           this.emailService.sendSimpleMessage(userDto.getEmail(),cancelationMessageTitle,cancellationMessageText);
           return new ResponseEntity<ReservationDto>(deletedReservationDto, HttpStatus.OK);
       } catch (RessourceNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       } catch (Exception e) {
        logger.error("Unexpected error occurred", e);
        return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

}
