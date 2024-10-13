package com.project.rentAcar.dao;

import com.project.rentAcar.dto.FiltersDto;
import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class implements the CarDao interface and provides the implementation for accessing Car data.
 */
@Repository
public class CarDaoImpl implements CarDao {
    private static final Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);

    @Autowired
    private EntityManager em;

    /**
     * Constructor that logs the initialization of the DAO.
     */
    public CarDaoImpl() {
        logger.info("Enter into : " + CarDaoImpl.class);
    }

    /**
     * Saves a new car to the database.
     *
     * @param car the car to be saved
     * @return the saved car
     */
    @Override
    public Car saveCar(Car car){
        logger.info("Enter into saveCar dao method");
        em.persist(car);
        logger.info("Car saved " );
        return car;
    }

    /**
     * Updates an existing car in the database.
     *
     * @param car the car to be updated
     * @return the updated car
     */
    @Override
    public Car updateCar(Car car) throws RessourceNotFoundException {
        logger.info("Enter into updateCar dao method");
        car = this.em.merge(car);
        logger.info("Car updated: " + car.getId());
        return car;
    }

    /**
     * Finds a car by its ID.
     *
     * @param id the ID of the car to search for
     * @return the car with the specified ID
     */
    @Override
    public Car findCarById(int id) throws RessourceNotFoundException {
        logger.info("Enter into findCarById dao method");
        Car car = this.em.find(Car.class, id);
        if (car == null) {
            throw new RessourceNotFoundException("Car not found with id: " + id);
        }
        logger.info("Car found: " + car.getId());
        return car;
    }

    /**
     * Finds a car by its license number.
     *
     * @param licenceNumber the license number of the car to search for
     * @return the car with the specified license number
     */
    @Override
    public Car findCarByLicenceNumber(String licenceNumber) throws RessourceNotFoundException {
        logger.info("Enter into findCarByLicenceNumber dao method");
        TypedQuery<Car> query = this.em.createQuery("FROM Car WHERE licenceNumber = :licenceNumber", Car.class);
        query.setParameter("licenceNumber", licenceNumber);
        try {
            Car car = query.getSingleResult();
            logger.info("Car found: " + car);
            return car;
        } catch (NoResultException e) {
            throw new RessourceNotFoundException("Car not found with licence number: " + licenceNumber);
        }
    }

    /**
     * Finds available cars by brand.
     *
     * @param brand the brand to search available cars by
     * @return a list of available cars of the specified brand
     */
    @Override
    public List<Car> findCarsByBrandAndAvailable(String brand) throws RessourceNotFoundException {
        logger.info("Enter into findCarsByBrandAndAvailable dao method");
        TypedQuery<Car> query = this.em.createQuery("FROM Car WHERE brand = :brand AND available = true", Car.class);
        query.setParameter("brand", brand);
        List<Car> cars = query.getResultList();
        if (cars.isEmpty()) {
            throw new RessourceNotFoundException("Cars not found with brand: " + brand);
        }
        logger.info("Cars found: " + cars);
        return cars;
    }

    /**
     * Finds all available cars.
     *
     * @return a list of all available cars
     */
    @Override
    public List<Car> findAvailableCars() throws RessourceNotFoundException {
        logger.info("Enter into findAvailableCars dao method");
        TypedQuery<Car> query = this.em.createQuery("FROM Car WHERE available = true", Car.class);
        List<Car> cars = query.getResultList();
        if (cars.isEmpty()) {
            throw new RessourceNotFoundException("No available cars found");
        }
        logger.info("Cars found: " + cars);
        return cars;
    }

    /**
     * Finds available cars by city.
     *
     * @param city the city to search available cars in
     * @return a list of available cars in the specified city
     */

    @Override
    public List<Car> findCarsByCityAndAvailable(Cities city, FiltersDto filtersDto) throws RessourceNotFoundException {
        logger.info("Enter into findCarsByCityAndAvailable dao method");

        StringBuilder jpql = new StringBuilder("SELECT c FROM Car c WHERE c.agency.city = :city AND c.available = true");

        if (filtersDto.getMinPrice() > 0) {
            jpql.append(" AND c.price >= :minPrice");
        }
        if (filtersDto.getMaxPrice() > 0) {
            jpql.append(" AND c.price <= :maxPrice");
        }
        if (filtersDto.getGps() != null) {
            jpql.append(" AND c.carCaracteristics.gps = :gps");
        }
        if (filtersDto.getBackupCamera() != null) {
            jpql.append(" AND c.carCaracteristics.backupCamera = :backupCamera");
        }
        if (filtersDto.getManualTransmission() != null) {
            jpql.append(" AND c.carCaracteristics.manualTransmission = :manualTransmission");
        }
        if (filtersDto.getBluetooth() != null) {
            jpql.append(" AND c.carCaracteristics.bluetooth = :bluetooth");
        }

        TypedQuery<Car> query = this.em.createQuery(jpql.toString(), Car.class);
        query.setParameter("city", city);

        if (filtersDto.getMinPrice() > 0) {
            query.setParameter("minPrice", filtersDto.getMinPrice());
        }
        if (filtersDto.getMaxPrice() > 0) {
            query.setParameter("maxPrice", filtersDto.getMaxPrice());
        }
        if (filtersDto.getGps() != null) {
            query.setParameter("gps", filtersDto.getGps());
        }
        if (filtersDto.getBackupCamera() != null) {
            query.setParameter("backupCamera", filtersDto.getBackupCamera());
        }
        if (filtersDto.getManualTransmission() != null) {
            query.setParameter("manualTransmission", filtersDto.getManualTransmission());
        }
        if (filtersDto.getBluetooth() != null) {
            query.setParameter("bluetooth", filtersDto.getBluetooth());
        }

        List<Car> cars = query.getResultList();
        if (cars.isEmpty()) {
            throw new RessourceNotFoundException("Cars not found with city: " + city.getCity());
        }
        logger.info("Cars found: " + cars);
        return cars;
    }
}
