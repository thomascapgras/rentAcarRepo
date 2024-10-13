package com.project.rentAcar.dto;

import com.project.rentAcar.entities.Agency;
import com.project.rentAcar.entities.enumerations.Cities;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for the Agency entity.
 * This class is used to transfer data between different layers of the application.
 */
public class AgencyDto {

    private int id;
    @NotNull (message = "Agency name is required")
    private String name;
    @DecimalMin (value = "-180.0",message="Agency longitude must be greater than -180.0")
    @DecimalMax (value = "180.0",message="Agency longitude must be smaller than 180.0")
    private float longitude;
    @DecimalMin (value = "-90.0",message="Agency latitude must be greater than -90.0")
    @DecimalMax (value = "90.0",message="Agency latitude must be smaller than 90.0")
    private float latitude;
    private Cities city;

    /**
     * Constructs an AgencyDto from an Agency entity.
     *
     * @param agency the Agency entity
     */
    public AgencyDto(Agency agency) {
        this.id = agency.getId();
        this.name = agency.getName();
        this.longitude = agency.getLongitude();
        this.latitude = agency.getLatitude();
        this.city = agency.getCity();
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
     * Gets the longitude of the agency.
     *
     * @return the longitude of the agency
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of the agency.
     *
     * @param longitude the new longitude of the agency
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the latitude of the agency.
     *
     * @return the latitude of the agency
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of the agency.
     *
     * @param latitude the new latitude of the agency
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the city of the agency.
     *
     * @return the city of the agency
     */
    public Cities getCity() {
        return city;
    }

    /**
     * Sets the city of the agency.
     *
     * @param city the new city of the agency
     */
    public void setCity(Cities city) {
        this.city = city;
    }

    /**
     * Returns a string representation of the AgencyDto.
     *
     * @return a string representation of the AgencyDto
     */
    @Override
    public String toString() {
        return "AgencyDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", city=" + city +
                '}';
    }
}
