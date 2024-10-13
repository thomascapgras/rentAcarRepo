package com.project.rentAcar.entities;
import com.project.rentAcar.dto.CarDto;
import jakarta.persistence.*;
import java.util.List;

/**
 * Entity class representing a Car in the system.
 */
@Entity
@Table(name="car")
public class Car {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="licenceNumber")
    private String licenceNumber;

    @Column(name="price")
    private float price;

    @Column(name="available")
    private boolean available;

    @Column(name="rating")
    private float rating;

    @Column(name="latirude")
    private float latitude;

    @Column(name="longitude")
    private float longitude;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="car_caracteristics_id")
    private CarCaracteristics carCaracteristics;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @OneToMany(mappedBy = "car", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    /**
     * Default constructor.
     */
    public Car() {}

    /**
     * Parameterized constructor.
     *
     * @param brand the brand of the car
     * @param model the model of the car
     * @param licenceNumber the licence number of the car
     * @param price the price of the car
     * @param available the availability status of the car
     * @param rating the rating of the car
     * @param latitude the latitude coordinate of the car
     * @param longitude the longitude coordinate of the car
     * @param carCaracteristics the characteristics of the car
     */
    public Car(String brand, String model, String licenceNumber,
               float price, boolean available, float rating, float latitude, float longitude, CarCaracteristics carCaracteristics) {
        this.brand = brand;
        this.model = model;
        this.licenceNumber = licenceNumber;
        this.price = price;
        this.available = available;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
        this.carCaracteristics = carCaracteristics;
    }


    /**
     * Parameterized constructor.
     *
     * @param carDto a carDtp from the Car
     */
    public Car (CarDto carDto){
        this.brand = carDto.getBrand();
        this.model = carDto.getModel();
        this.licenceNumber = carDto.getLicenceNumber();
        this.price = carDto.getPrice();
        this.available = carDto.isAvailable();
        this.rating = carDto.getRating();
        this.latitude = carDto.getLatitude();
        this.longitude = carDto.getLongitude();
        this.carCaracteristics = new CarCaracteristics(carDto.getCarCaracteristicsDto());
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
     * Gets the availability status of the car.
     *
     * @return true if the car is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability status of the car.
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
     * Gets the latitude coordinate of the car.
     *
     * @return the latitude coordinate of the car
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude coordinate of the car.
     *
     * @param latitude the new latitude coordinate of the car
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the longitude coordinate of the car.
     *
     * @return the longitude coordinate of the car
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude coordinate of the car.
     *
     * @param longitude the new longitude coordinate of the car
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the car characteristics.
     *
     * @return the car characteristics
     */
    public CarCaracteristics getCarCaracteristics() {
        return carCaracteristics;
    }

    /**
     * Sets the car characteristics.
     *
     * @param carCaracteristics the new car characteristics
     */
    public void setCarCaracteristics(CarCaracteristics carCaracteristics) {
        this.carCaracteristics = carCaracteristics;
    }

    /**
     * Gets the agency associated with the car.
     *
     * @return the agency associated with the car
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * Sets the agency associated with the car.
     *
     * @param agency the new agency associated with the car
     */
    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    /**
     * Gets the reservation associated with the car.
     *
     * @return the reservation associated with the car
     */
    public List<Reservation> getReservation() {
        return this.reservations;
    }

    /**
     * Sets the reservation associated with the car.
     *
     * @param reservations the new reservation associated with the car
     */
    public void setReservation(List<Reservation> reservations) {
        this.reservations = reservations;
    }


    /**
     * Returns a string representation of the Car.
     *
     * @return a string representation of the Car
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", licenceNumber='").append(licenceNumber).append('\'');
        sb.append(", price=").append(price);
        sb.append(", available=").append(available);
        sb.append(", rating=").append(rating);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", carCaracteristics=").append(carCaracteristics);
        sb.append(", agency=").append(agency != null ? agency.getId() : "null");
        sb.append('}');
        return sb.toString();
    }
}
