package com.project.rentAcar.dao;

import com.project.rentAcar.dto.FiltersDto;
import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

import java.util.List;

/**
 * This interface defines methods for managing Car entities.
 */
public interface CarDao {

    /**
     * Saves a new car.
     *
     * @param car the car to save
     * @return the saved car
     */
    public Car saveCar(Car car);

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
     * @return the car with the specified license number
     * @throws RessourceNotFoundException if the car is not found
     */
    public Car findCarByLicenceNumber(String licenceNumber) throws RessourceNotFoundException;

    /**
     * Finds cars by brand and checks their availability.
     *
     * @param brand the brand of the cars to find
     * @return a list of available cars of the specified brand
     * @throws RessourceNotFoundException if no available cars of the specified brand are found
     */
    public List<Car> findCarsByBrandAndAvailable(String brand) throws RessourceNotFoundException;

    /**
     * Finds all available cars.
     *
     * @return a list of all available cars
     * @throws RessourceNotFoundException if no available cars are found
     */
    public List<Car> findAvailableCars() throws RessourceNotFoundException;

    /**
     * Finds available cars in a specific city.
     *
     * @param city the city to search for available cars
     * @return a list of available cars in the specified city
     * @throws RessourceNotFoundException if no available cars in the specified city are found
     */
    public List<Car> findCarsByCityAndAvailable(Cities city, FiltersDto filtersDto) throws RessourceNotFoundException;

    /**
     * Updates an existing car.
     *
     * @param car the car to update
     * @return the updated car
     * @throws RessourceNotFoundException if the car is not found
     */
    public Car updateCar(Car car) throws RessourceNotFoundException;
}
