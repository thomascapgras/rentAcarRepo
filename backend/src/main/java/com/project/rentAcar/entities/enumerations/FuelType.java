package com.project.rentAcar.entities.enumerations;

/**
 * Enumeration representing different fuel types.
 */
public enum FuelType {

    RegularUnleaded(0, "RegularUnleaded"),
    MidgradeUnleaded(1, "MidgradeUnleaded"),
    PremiumUnleaded(2, "PremiumUnleaded"),
    Diesel(3, "Diesel"),
    E85(4, "E85"),
    Biodiesel(5, "Biodiesel"),
    LPG(6, "LPG"),
    CNG(7, "CNG"),
    None(8, "None");

    private final int code;
    private final String fuelType;

    /**
     * Constructs a fuel type enumeration with the specified code and description.
     *
     * @param code        the code of the fuel type
     * @param description the description of the fuel type
     */
    FuelType(int code, String description) {
        this.code = code;
        this.fuelType = description;
    }

    /**
     * Gets the description of the fuel type.
     *
     * @return the description of the fuel type
     */
    public String getFuelType() {
        return this.fuelType;
    }

    /**
     * Gets the code of the fuel type.
     *
     * @return the code of the fuel type
     */
    public int getCode() {
        return this.code;
    }
}
