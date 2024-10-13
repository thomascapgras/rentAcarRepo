package com.project.rentAcar.entities.enumerations;

/**
 * Enumeration representing different cities.
 */
public enum Cities {

    Paris(0, "Paris"),
    London(1, "London"),
    Barcelona(2, "Barcelona"),
    Roma(3, "Roma"),
    Berlin(4, "Berlin"),
    None(5, "None");

    private final int code;
    private final String city;

    /**
     * Constructs a city enumeration with the specified code and city name.
     *
     * @param code the code of the city
     * @param city the name of the city
     */
    Cities(int code, String city) {
        this.code = code;
        this.city = city;
    }

    /**
     * Gets the code of the city.
     *
     * @return the code of the city
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Gets the name of the city.
     *
     * @return the name of the city
     */
    public String getCity() {
        return this.city;
    }
}
