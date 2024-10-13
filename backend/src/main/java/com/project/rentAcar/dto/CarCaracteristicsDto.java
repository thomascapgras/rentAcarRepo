package com.project.rentAcar.dto;

import com.project.rentAcar.entities.CarCaracteristics;
import com.project.rentAcar.entities.enumerations.FuelType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/**
 * Data Transfer Object for CarCaracteristics.
 */
public class CarCaracteristicsDto {

    private int id;

    @Min(value = 0, message = "Car mileage must be greater or equal than 0")
    private int mileage;

    @Min(value = 0, message = "Car rentNumber must be greater or equal than 0")
    private int rentNumber;

    private FuelType fuelType;

    private boolean manualTransmission;

    private boolean backupCamera;

    private boolean gps;

    private boolean bluetooth;

    @Min(value = 50, message = "Car horsepower must be greater or equal than 50")
    @Max(value = 350, message = "Car horsepower must be smaller or equal than 350")
    private int horsepower;

    @Min(value = 2, message = "Car seats must be greater or equal than 2")
    @Max(value = 10, message = "Car seats must be smaller or equal than 10")
    private int seats;

    @Min(value = 2, message = "Car doors must be greater or equal than 2")
    @Max(value = 10, message = "Car doors must be smaller or equal than 10")
    private int doors;

    private String img;

    private String description;

    /**
     * Default constructor.
     */
    public CarCaracteristicsDto() {
    }

    /**
     * Constructs a CarCaracteristicsDto object from a CarCaracteristics entity.
     *
     * @param carCaracteristics the CarCaracteristics entity
     */
    public CarCaracteristicsDto(CarCaracteristics carCaracteristics) {
        this.id = carCaracteristics.getId();
        this.mileage = carCaracteristics.getMileage();
        this.rentNumber = carCaracteristics.getRentNumber();
        this.fuelType = carCaracteristics.getFuelType();
        this.manualTransmission = carCaracteristics.isManualTransmission();
        this.backupCamera = carCaracteristics.isBackupCamera();
        this.gps = carCaracteristics.isGps();
        this.bluetooth = carCaracteristics.isBluetooth();
        this.seats = carCaracteristics.getSeats();
        this.doors = carCaracteristics.getDoors();
        this.img = carCaracteristics.getImg();
        this.description = carCaracteristics.getDescription();
    }

    /**
     * Constructs a CarCaracteristicsDto with specified parameters.
     *
     * @param id                 the ID of the car characteristics
     * @param mileage            the mileage of the car
     * @param rentNumber         the number of times the car has been rented
     * @param fuelType           the type of fuel the car uses
     * @param manualTransmission whether the car has a manual transmission
     * @param backupCamera       whether the car has a backup camera
     * @param gps                whether the car has a GPS system
     * @param bluetooth          whether the car has Bluetooth capability
     * @param horsepower         the horsepower of the car
     * @param seats              the number of seats in the car
     * @param doors              the number of doors on the car
     * @param img                the image URL of the car
     * @param description        the description of the car
     */
    public CarCaracteristicsDto(int id, int mileage, int rentNumber, FuelType fuelType, boolean manualTransmission, boolean backupCamera, boolean gps, boolean bluetooth, int horsepower, int seats, int doors, String img, String description) {
        this.id = id;
        this.mileage = mileage;
        this.rentNumber = rentNumber;
        this.fuelType = fuelType;
        this.manualTransmission = manualTransmission;
        this.backupCamera = backupCamera;
        this.gps = gps;
        this.bluetooth = bluetooth;
        this.horsepower = horsepower;
        this.seats = seats;
        this.doors = doors;
        this.img = img;
        this.description = description;
    }

    // Getters and Setters with Javadoc

    /**
     * Gets the ID of the car characteristics.
     *
     * @return the ID of the car characteristics
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the car characteristics.
     *
     * @param id the new ID of the car characteristics
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the mileage of the car.
     *
     * @return the mileage of the car
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Sets the mileage of the car.
     *
     * @param mileage the new mileage of the car
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * Gets the number of times the car has been rented.
     *
     * @return the number of times the car has been rented
     */
    public int getRentNumber() {
        return rentNumber;
    }

    /**
     * Sets the number of times the car has been rented.
     *
     * @param rentNumber the new number of times the car has been rented
     */
    public void setRentNumber(int rentNumber) {
        this.rentNumber = rentNumber;
    }

    /**
     * Gets the type of fuel the car uses.
     *
     * @return the type of fuel the car uses
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Sets the type of fuel the car uses.
     *
     * @param fuelType the new type of fuel the car uses
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Checks if the car has a manual transmission.
     *
     * @return true if the car has a manual transmission, false otherwise
     */
    public boolean isManualTransmission() {
        return manualTransmission;
    }

    /**
     * Sets whether the car has a manual transmission.
     *
     * @param manualTransmission the new manual transmission status
     */
    public void setManualTransmission(boolean manualTransmission) {
        this.manualTransmission = manualTransmission;
    }

    /**
     * Checks if the car has a backup camera.
     *
     * @return true if the car has a backup camera, false otherwise
     */
    public boolean isBackupCamera() {
        return backupCamera;
    }

    /**
     * Sets whether the car has a backup camera.
     *
     * @param backupCamera the new backup camera status
     */
    public void setBackupCamera(boolean backupCamera) {
        this.backupCamera = backupCamera;
    }

    /**
     * Checks if the car has a GPS system.
     *
     * @return true if the car has a GPS system, false otherwise
     */
    public boolean isGps() {
        return gps;
    }

    /**
     * Sets whether the car has a GPS system.
     *
     * @param gps the new GPS system status
     */
    public void setGps(boolean gps) {
        this.gps = gps;
    }

    /**
     * Checks if the car has Bluetooth capability.
     *
     * @return true if the car has Bluetooth capability, false otherwise
     */
    public boolean isBluetooth() {
        return bluetooth;
    }

    /**
     * Sets whether the car has Bluetooth capability.
     *
     * @param bluetooth the new Bluetooth status
     */
    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    /**
     * Gets the horsepower of the car.
     *
     * @return the horsepower of the car
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Sets the horsepower of the car.
     *
     * @param horsepower the new horsepower of the car
     */
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    /**
     * Gets the number of seats in the car.
     *
     * @return the number of seats in the car
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the number of seats in the car.
     *
     * @param seats the new number of seats in the car
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * Gets the number of doors on the car.
     *
     * @return the number of doors on the car
     */
    public int getDoors() {
        return doors;
    }

    /**
     * Sets the number of doors on the car.
     *
     * @param doors the new number of doors on the car
     */
    public void setDoors(int doors) {
        this.doors = doors;
    }

    /**
     * Gets the image URL of the car.
     *
     * @return the image URL of the car
     */
    public String getImg() {
        return img;
    }

    /**
     * Sets the image URL of the car.
     *
     * @param img the new image URL of the car
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Gets the description of the car.
     *
     * @return the description of the car
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the car.
     *
     * @param description the new description of the car
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CarCaracteristicsDto{" +
                "id=" + id +
                ", mileage=" + mileage +
                ", rentNumber=" + rentNumber +
                ", fuelType=" + fuelType +
                ", manualTransmission=" + manualTransmission +
                ", backupCamera=" + backupCamera +
                ", gps=" + gps +
                ", bluetooth=" + bluetooth +
                ", horsepower=" + horsepower +
                ", seats=" + seats +
                ", doors=" + doors +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
