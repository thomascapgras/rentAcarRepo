package com.project.rentAcar.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.entities.enumerations.CitiesConverter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Entity representing an agency.
 */
@Table(name = "agency")
@Entity
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "longitude")
    private float longitude;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "city")
    @Enumerated(EnumType.STRING)
    @Convert(converter = CitiesConverter.class)
    private Cities city;

    @OneToMany(mappedBy = "agency", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Car> cars;

    /**
     * Default constructor.
     */
    public Agency() {
    }

    /**
     * Constructs an Agency with the specified details.
     *
     * @param name      the name of the agency
     * @param longitude the longitude of the agency location
     * @param latitude  the latitude of the agency location
     * @param city      the city where the agency is located
     */
    public Agency(String name, float longitude, float latitude, Cities city) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
    }

    /**
     * Gets the ID of the agency.
     *
     * @return the ID of the agency
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the agency.
     *
     * @param id the new ID of the agency
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the agency.
     *
     * @return the name of the agency
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the agency.
     *
     * @param name the new name of the agency
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the longitude of the agency location.
     *
     * @return the longitude of the agency location
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of the agency location.
     *
     * @param longitude the new longitude of the agency location
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the latitude of the agency location.
     *
     * @return the latitude of the agency location
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of the agency location.
     *
     * @param latitude the new latitude of the agency location
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the city where the agency is located.
     *
     * @return the city where the agency is located
     */
    public Cities getCity() {
        return city;
    }

    /**
     * Sets the city where the agency is located.
     *
     * @param city the new city where the agency is located
     */
    public void setCity(Cities city) {
        this.city = city;
    }

    /**
     * Gets the list of cars associated with the agency.
     *
     * @return the list of cars associated with the agency
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * Sets the list of cars associated with the agency.
     *
     * @param cars the new list of cars associated with the agency
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * Adds a car to the list of cars associated with the agency.
     *
     * @param car the car to be added
     */
    public void addCar(Car car) {
        if (this.cars == null) {
            this.cars = new ArrayList<>();
        }
        this.cars.add(car);
    }

    /**
     * Returns a string representation of the Agency.
     *
     * @return a string representation of the Agency
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agency{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", city='").append(city).append('\'');
        sb.append(", cars=").append(cars != null ? cars.stream().map(Car::getId).collect(Collectors.toList()) : "null");
        sb.append('}');
        return sb.toString();
    }
}
