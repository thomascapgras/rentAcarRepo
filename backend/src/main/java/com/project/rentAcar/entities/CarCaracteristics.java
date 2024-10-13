package com.project.rentAcar.entities;

import com.project.rentAcar.dto.CarCaracteristicsDto;
import com.project.rentAcar.entities.enumerations.FuelType;
import com.project.rentAcar.entities.enumerations.FuelTypeConverter;
import jakarta.persistence.*;

/**
 * Entity representing the characteristics of a car.
 */
@Entity
@Table(name = "car_caracteristics")
public class CarCaracteristics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "rent_number")
    private int rentNumber;

    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    @Convert(converter = FuelTypeConverter.class)
    private FuelType fuelType;

    @Column(name = "manual_transmission")
    private boolean manualTransmission;

    @Column(name = "backup_camera")
    private boolean backupCamera;

    @Column(name = "gps")
    private boolean gps;

    @Column(name = "bluetooth")
    private boolean bluetooth;

    @Column(name = "horsepower")
    private int horsepower;

    @Column(name = "seats")
    private int seats;

    @Column(name = "doors")
    private int doors;

    @Column(name = "img")
    private String img;

    @Column(name = "description")
    private String description;

    /**
     * Default constructor.
     */
    public CarCaracteristics() {
    }

    /**
     * Constructs a CarCaracteristics with the specified details.
     *
     * @param mileage           the mileage of the car
     * @param rentNumber        the number of times the car has been rented
     * @param fuelType          the fuel type of the car
     * @param manualTransmission whether the car has manual transmission
     * @param backupCamera      whether the car has a backup camera
     * @param gps               whether the car has GPS
     * @param bluetooth         whether the car has Bluetooth
     * @param horsepower        the horsepower of the car
     * @param seats             the number of seats in the car
     * @param doors             the number of doors in the car
     * @param description       the description of the car
     * @param img               the image of the car
     */
    public CarCaracteristics(int mileage, int rentNumber, FuelType fuelType, boolean manualTransmission, boolean backupCamera,
                             boolean gps, boolean bluetooth, int horsepower, int seats, int doors, String description, String img) {
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
        this.description = description;
        this.img = img;
    }

    /**
     * Constructs a CarCaracteristics with the specified details.
     *
     * @param carCaracteristicsDto the carCaracteristicsDto of the car

     */
    public CarCaracteristics(CarCaracteristicsDto carCaracteristicsDto){
        this.id=carCaracteristicsDto.getId();
        this.mileage=carCaracteristicsDto.getMileage();
        this.rentNumber = carCaracteristicsDto.getRentNumber();
        this.fuelType=carCaracteristicsDto.getFuelType();
        this.manualTransmission = carCaracteristicsDto.isManualTransmission();
        this.backupCamera = carCaracteristicsDto.isBackupCamera();
        this.gps = carCaracteristicsDto.isGps();
        this.bluetooth=carCaracteristicsDto.isBluetooth();
        this.seats=carCaracteristicsDto.getSeats();
        this.doors = carCaracteristicsDto.getDoors();
        this.img=carCaracteristicsDto.getImg();
        this.description=carCaracteristicsDto.getDescription();
    }
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
     * Gets the fuel type of the car.
     *
     * @return the fuel type of the car
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Sets the fuel type of the car.
     *
     * @param fuelType the new fuel type of the car
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Checks if the car has manual transmission.
     *
     * @return true if the car has manual transmission, false otherwise
     */
    public boolean isManualTransmission() {
        return manualTransmission;
    }

    /**
     * Sets whether the car has manual transmission.
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
     * Checks if the car has GPS.
     *
     * @return true if the car has GPS, false otherwise
     */
    public boolean isGps() {
        return gps;
    }

    /**
     * Sets whether the car has GPS.
     *
     * @param gps the new GPS status
     */
    public void setGps(boolean gps) {
        this.gps = gps;
    }

    /**
     * Checks if the car has Bluetooth.
     *
     * @return true if the car has Bluetooth, false otherwise
     */
    public boolean isBluetooth() {
        return bluetooth;
    }

    /**
     * Sets whether the car has Bluetooth.
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
     * Gets the number of doors in the car.
     *
     * @return the number of doors in the car
     */
    public int getDoors() {
        return doors;
    }

    /**
     * Sets the number of doors in the car.
     *
     * @param doors the new number of doors in the car
     */
    public void setDoors(int doors) {
        this.doors = doors;
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

    /**
     * Gets the image of the car.
     *
     * @return the image of the car
     */
    public String getImg() {
        return img;
    }

    /**
     * Sets the image of the car.
     *
     * @param img the new image of the car
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Returns a string representation of the CarCaracteristics.
     *
     * @return a string representation of the CarCaracteristics
     */


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CarCaracteristics{");
        sb.append("id=").append(id);
        sb.append(", mileage=").append(mileage);
        sb.append(", rentNumber=").append(rentNumber);
        sb.append(", fuelType=").append(fuelType);
        sb.append(", manualTransmission=").append(manualTransmission);
        sb.append(", backupCamera=").append(backupCamera);
        sb.append(", gps=").append(gps);
        sb.append(", bluetooth=").append(bluetooth);
        sb.append(", horsepower=").append(horsepower);
        sb.append(", seats=").append(seats);
        sb.append(", doors=").append(doors);
        sb.append(", description='").append(description).append('\'');
        sb.append(", img='").append(img).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
