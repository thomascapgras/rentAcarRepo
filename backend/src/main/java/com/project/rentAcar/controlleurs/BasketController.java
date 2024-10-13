package com.project.rentAcar.controlleurs;

import com.project.rentAcar.dto.BasketDto;
import com.project.rentAcar.entities.Basket;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.BasketService;
import com.project.rentAcar.validators.ValidId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * This controller handles basket-related endpoints.
 */
@RestController
@RequestMapping("/basket")
@Validated
public class BasketController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AgencyController.class);
    @Autowired
    private BasketService basketService;

    public BasketController(){
        logger.info("Enter into : " + BasketController.class);
    }

    /**
     * Finds a basket by its ID.
     *
     * @param id the ID of the basket to search for
     * @return a response entity containing the basket and HTTP status OK, or a message with HTTP status NOT FOUND if no basket is found
     */
    @GetMapping("/getBasketById/{id}")
    public ResponseEntity<?> getasketById(@PathVariable @ValidId(entityClass = Basket.class) int id) {
        logger.info("enter into findBasketById endpoint method" );
        try {
            BasketDto basketDto = this.basketService.findBasketById(id);
            logger.info("Sending back basket");
            return new ResponseEntity<>(basketDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Finds a basket by the user's ID.
     *
     * @param id the ID of the user to search for
     * @return a response entity containing the basket and HTTP status OK, or a message with HTTP status NOT FOUND if no basket is found
     */
    @GetMapping("/getBasketByUserId/{id}")
    public ResponseEntity<?> getBasketByUserId(@PathVariable @ValidId(entityClass = User.class) int id) throws RessourceNotFoundException {
        logger.info("enter into findBasketByUserId endpoint method" );
        try {
            BasketDto basketDto = this.basketService.findBasketByUserId(id);
            logger.info("Sending back basket");
            return new ResponseEntity<>(basketDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
