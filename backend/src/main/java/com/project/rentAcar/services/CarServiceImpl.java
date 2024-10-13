package com.project.rentAcar.services;

import com.project.rentAcar.dao.CarDao;
import com.project.rentAcar.dto.CarDto;
import com.project.rentAcar.dto.FiltersDto;
import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for managing cars.
 */
@Service
public class CarServiceImpl implements CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CarDao carDao;

    /**
     * Constructor for CarServiceImpl.
     * Logs the entry into the CarServiceImpl class.
     */
    public CarServiceImpl() {
        logger.info("Enter into : " + CarServiceImpl.class);
    }


    /**
     * Finds a carDto by its ID.
     *
     * @param id the ID of the car
     * @return the carDto with the specified ID, or null if not found
     */
    @Override
    public CarDto findCarByIDto(int id) throws RessourceNotFoundException {
        logger.info("Enter into findCarByIdDto service method");
        Car car = this.carDao.findCarById(id);
        CarDto carDto = new CarDto(car);
        return carDto;
    }

    /**
     * Finds a car by its ID.
     *
     * @param id the ID of the car
     * @return the car with the specified ID, or null if not found
     */
    @Override
    public Car findCarById(int id) throws RessourceNotFoundException {
        logger.info("Enter into findCarById service method");
        Car car = this.carDao.findCarById(id);
        return car;
    }

    /**
     * Finds a car by its licence number.
     *
     * @param licenceNumber the licence number of the car
     * @return the carDto with the specified licence number, or null if not found
     */
    @Override
    public CarDto findCarByLicenceNumber(String licenceNumber) throws RessourceNotFoundException {
        logger.info("Enter into findCarByLicenceNumber service method");
        Car car = this.carDao.findCarByLicenceNumber(licenceNumber);
        CarDto carDto = new CarDto(car);
        return carDto;
    }

    /**
     * Finds cars by their brand and availability.
     *
     * @param brand the brand of the cars
     * @return a list of carsDto with the specified brand and available status
     */
    @Override
    public List<CarDto> findCarsByBrandAndAvailable(String brand) throws RessourceNotFoundException {
        logger.info("Enter into findCarsByBrandAndAvailable service method");
        List<Car> cars = this.carDao.findCarsByBrandAndAvailable(brand);
        List<CarDto> carsDto = new ArrayList<>();
        for (Car car : cars){
            carsDto.add(new CarDto(car));
        }
        return carsDto;
    }

    /**
     * Finds all available cars.
     *
     * @return a list of all available carsDto
     */
    @Override
    public List<CarDto> findAvailableCars() throws RessourceNotFoundException {
        logger.info("Enter into findAvailableCars service method");
        List<Car> cars = this.carDao.findAvailableCars();
        List<CarDto> carsDto = new ArrayList<>();
        for (Car car : cars){
            carsDto.add(new CarDto(car));
        }
        return carsDto;
    }

    /**
     * Finds cars by city and availability.
     *
     * @param city the city of the cars
     * @return a list of carsDto in the specified city and available status
     */
    @Override
    public List<CarDto> findCarsByCityAndAvailable(Cities city, FiltersDto filtersDto) throws RessourceNotFoundException {
        logger.info("Enter into findCarsByCityAndAvailable service method");
        List<Car> cars = this.carDao.findCarsByCityAndAvailable(city,filtersDto);
        List<CarDto> carsDto = new ArrayList<>();
        for (Car car : cars){
            carsDto.add(new CarDto(car));
        }
        return carsDto;
    }

    /**
     * Checks if a car is available.
     *
     * @param carDto the car to check
     * @return true if the car is available, false otherwise
     */
    @Override
    public boolean isAvailable(CarDto carDto) {
        logger.info("Enter into isAvailable service method");
        return carDto.isAvailable();
    }

    /**
     * Updates an existing car.
     *
     * @param car the car to be updated
     * @return the updated car
     */
    @Override
    @Transactional
    public Car updateCar(Car car) throws RessourceNotFoundException {
        logger.info("Enter into updateCar service method");
        car = this.carDao.updateCar(car);
        return car;
    }

}
