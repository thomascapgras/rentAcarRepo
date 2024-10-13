package com.project.rentAcar.dto;

import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.enumerations.Cities;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) for the Car entity.
 * This class is used to transfer data between different layers of the application.
 */
public class CarDto {

    private int id;
    @NotNull(message = "Car brand is required")
    private String brand;
    @NotNull (message = "Car model is required")
    private String model;
    @NotNull (message = "Car licenceNumber is required")
    @Size(min=4,max=12,message = "Licencenumber must be between 4 and 12 caracters")
    private String licenceNumber;

    @DecimalMin(value="10.0", message="Car price must be greater or equal than 10.0")
    @DecimalMax(value="150.0", message="Car price must be smaller or equal than 150.0")
    private float price;
    private boolean available;

    private float rating;
    @DecimalMin (value = "-90.0",message="Car latitude must be greater than -90.0")
    @DecimalMax (value = "90.0",message="Car latitude must be smaller than 90.0")
    private float latitude;
    @DecimalMin (value = "-180.0",message="Car longitude must be greater than -180.0")
    @DecimalMax (value = "180.0",message="Car longitude must be smaller than 180.0")
    private float longitude;

    @NotNull (message = "Car caracteristics is required")
    private CarCaracteristicsDto carCaracteristicsDto;
    private Cities city;

    /**
     * Constructs a CarDto from a Car entity.
     *
     * @param car the Car entity
     */
    public CarDto(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.licenceNumber = car.getLicenceNumber();
        this.price = car.getPrice();
        this.available = car.isAvailable();
        this.rating = car.getRating();
        this.latitude = car.getLatitude();
        this.longitude = car.getLongitude();
        this.carCaracteristicsDto = new CarCaracteristicsDto(car.getCarCaracteristics());
        this.city = car.getAgency().getCity();
    }

    /**
     * Default constructor.
     */
    public CarDto() {
    }

    /**
     * Gets the ID of the car.
     *
     * @return the ID of the car
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the car.
     *
     * @param id the new ID of the car
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the brand of the car.
     *
     * @return the brand of the car
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of the car.
     *
     * @param brand the new brand of the car
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the model of the car.
     *
     * @return the model of the car
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the car.
     *
     * @param model the new model of the car
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the licence number of the car.
     *
     * @return the licence number of the car
     */
    public String getLicenceNumber() {
        return licenceNumber;
    }

    /**
     * Sets the licence number of the car.
     *
     * @param licenceNumber the new licence number of the car
     */
    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    /**
     * Gets the price of the car.
     *
     * @return the price of the car
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the car.
     *
     * @param price the new price of the car
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Checks if the car is available.
     *
     * @return true if the car is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability of the car.
     *
     * @param available the new availability status of the car
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Gets the rating of the car.
     *
     * @return the rating of the car
     */
    public float getRating() {
        return rating;
    }

    /**
     * Sets the rating of the car.
     *
     * @param rating the new rating of the car
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * Gets the car characteristics.
     *
     * @return the car characteristicsDto
     */
    public CarCaracteristicsDto getCarCaracteristicsDto() {
        return carCaracteristicsDto;
    }

    /**
     * Sets the car characteristics.
     *
     * @param carCaracteristicsDto the new car characteristics
     */
    public void setCarCaracteristics(CarCaracteristicsDto carCaracteristicsDto) {
        this.carCaracteristicsDto = carCaracteristicsDto;
    }

    /**
     * Gets the latitude of the car's location.
     *
     * @return the latitude of the car's location
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of the car's location.
     *
     * @param latitude the new latitude of the car's location
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the longitude of the car's location.
     *
     * @return the longitude of the car's location
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of the car's location.
     *
     * @param longitude the new longitude of the car's location
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the city of the car.
     *
     * @return the city of the car
     */
    public Cities getCity() {
        return city;
    }

    /**
     * Sets the city of the car.
     *
     * @param city the new city of the car
     */
    public void setCity(Cities city) {
        this.city = city;
    }

    /**
     * Returns a string representation of the CarDto.
     *
     * @return a string representation of the CarDto
     */
    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licenceNumber='" + licenceNumber + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", rating=" + rating +
                ", carCaracteristics=" + carCaracteristicsDto +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city=" + city +
                '}';
    }
}
