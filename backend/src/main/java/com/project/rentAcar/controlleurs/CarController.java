package com.project.rentAcar.controlleurs;

import com.project.rentAcar.dto.CarDto;
import com.project.rentAcar.dto.FiltersDto;
import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.AgencyService;
import com.project.rentAcar.services.CarService;
import com.project.rentAcar.validators.ValidId;
import com.project.rentAcar.validators.ValidStringSize;
import com.project.rentAcar.validators.ValidStringValue;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * This controller handles car-related endpoints.
 */
@RestController
@RequestMapping("/car")
@Validated
public class CarController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CarController.class);
    @Autowired
    private CarService carService;

    @Autowired
    private AgencyService agencyService;

    public CarController(){
        logger.info("Enter into : " + CarController.class);
    }



    /**
     * Finds a car by its ID.
     *
     * @param id the ID of the car to search for
     * @return a response entity containing the car and HTTP status OK, or a message with HTTP status NOT FOUND if no car is found
     */
    @GetMapping("/getCarById/{id}")
    public ResponseEntity<?> getCarById(@PathVariable  @ValidId(entityClass = Car.class) int id) {
        logger.info("Enter into getCarById endpoint method" );
        try{
            CarDto carDto = this.carService.findCarByIDto(id);
            logger.info("Sending back car");
            return new ResponseEntity<>(carDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
        logger.error("Unexpected error occurred", e);
        return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Finds a car by its license number.
     *
     * @param licenceNumber the license number of the car to search for
     * @return a response entity containing the car and HTTP status OK, or a message with HTTP status NOT FOUND if no car is found
     */
    @GetMapping("/getCarByLicenceNumber/{licenceNumber}")
    public ResponseEntity<?> getCarByLicenceNumber(@PathVariable @ValidStringSize(minSize = 4, maxSize = 12) String licenceNumber){
        logger.info("Enter into getCarByLicenceNumber endpoint method" );
        try {
            CarDto carDto = this.carService.findCarByLicenceNumber(licenceNumber);
            logger.info("Sending back car");
            return new ResponseEntity<>(carDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Finds available cars by city.
     *
     * @param city the city to search available cars in
     * @param filtersDto the car filters
     * @return a response entity containing the list of available cars and HTTP status OK, or a message with HTTP status NOT FOUND if no cars are found
     */
    @PostMapping("/getavailableCarsByCity/{city}")
    public ResponseEntity<?> getavailableCarsByCity(@PathVariable Cities city,  @Valid @RequestBody FiltersDto filtersDto) {
        logger.info("Enter into getavailableCarsByCity endpoint method" );
        logger.info("fitlers : " + filtersDto);
        try{
            List<CarDto> carsDto = this.carService.findCarsByCityAndAvailable(city,filtersDto);
            logger.info("Sending back cars");
            return new ResponseEntity<>(carsDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Finds available cars by brand.
     *
     * @param brand the brand to search available cars by
     * @return a response entity containing the list of available cars and HTTP status OK, or a message with HTTP status NOT FOUND if no cars are found
     */
    @GetMapping("/getavailableCarsByBrand/{brand}")
    public ResponseEntity<?> getavailableCarsByBrand(@PathVariable  @ValidStringValue(entityClass = Car.class, field = "brand") String brand)  {
        logger.info("Enter into getavailableCarsByBrand endpoint method" );
        try {
            List<CarDto> carsDto = this.carService.findCarsByBrandAndAvailable(brand);
            logger.info("Sending back cars");
            return new ResponseEntity<>(carsDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    /**
     * Finds all available cars.
     *
     * @return a response entity containing the list of available cars and HTTP status OK, or a message with HTTP status NOT FOUND if no cars are found
     */
    @GetMapping("/getAvailableCars")
    public ResponseEntity<?> getAvailableCars()  {
        logger.info("Enter into getAvailableCars endpoint method" );
        try {
            List<CarDto> carsDto = this.carService.findAvailableCars();
            logger.info("Sending back cars");
            return new ResponseEntity<>(carsDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
