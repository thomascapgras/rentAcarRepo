package com.project.rentAcar.services;

import com.project.rentAcar.dto.CarDto;
import com.project.rentAcar.dto.FiltersDto;
import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

import java.util.List;

/**
 * This interface defines car service methods.
 */
public interface CarService {

    /**
     * Finds a car by its ID and returns it as a CarDto.
     *
     * @param id the ID of the car
     * @return the CarDto with the specified ID
     * @throws RessourceNotFoundException if the car is not found
     */
    public CarDto findCarByIDto(int id) throws RessourceNotFoundException;

    /**
     * Finds a car by its ID.
     *
     * @param id the ID of the car
     * @return the car with the specified ID
     * @throws RessourceNotFoundException if the car is not found
     */
    public Car findCarById(int id) throws RessourceNotFoundException;

    /**
     * Finds a car by its license number.
     *
     * @param licenceNumber the license number of the car
     * @return the CarDto with the specified license number
     * @throws RessourceNotFoundException if the car is not found
     */
    public CarDto findCarByLicenceNumber(String licenceNumber) throws RessourceNotFoundException;

    /**
     * Finds cars by brand and availability.
     *
     * @param brand the brand of the cars to search for
     * @return a list of CarDto objects representing available cars of the specified brand
     * @throws RessourceNotFoundException if no available cars of the specified brand are found
     */
    public List<CarDto> findCarsByBrandAndAvailable(String brand) throws RessourceNotFoundException;

    /**
     * Finds all available cars.
     *
     * @return a list of CarDto objects representing all available cars
     * @throws RessourceNotFoundException if no available cars are found
     */
    public List<CarDto> findAvailableCars() throws RessourceNotFoundException;

    /**
     * Finds cars by city and availability.
     *
     * @param city the city to search for available cars
     * @return a list of CarDto objects representing available cars in the specified city
     * @throws RessourceNotFoundException if no available cars in the specified city are found
     */
    public List<CarDto> findCarsByCityAndAvailable(Cities city, FiltersDto filtersDto) throws RessourceNotFoundException;

    /**
     * Checks if a car is available.
     *
     * @param carDto the CarDto to check availability for
     * @return true if the car is available, false otherwise
     */
    public boolean isAvailable(CarDto carDto);

    /**
     * Updates an existing car.
     *
     * @param car the car to be updated
     * @return the updated car
     * @throws RessourceNotFoundException if the car is not found
     */
    public Car updateCar(Car car) throws RessourceNotFoundException;
}
