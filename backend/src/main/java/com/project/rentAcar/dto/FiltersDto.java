package com.project.rentAcar.dto;

import com.project.rentAcar.validators.ValidPriceFilters;

/**
 * Data Transfer Object for Filters.
 */
@ValidPriceFilters
public class FiltersDto {

    private int minPrice;
    private int maxPrice;
    private Boolean gps;
    private Boolean backupCamera;
    private Boolean manualTransmission;
    private Boolean bluetooth;

    /**
     * Default constructor.
     */
    private FiltersDto() {
    }

    /**
     * Constructs a FiltersDto with specified parameters.
     *
     * @param minPrice          the minimum price
     * @param maxPrice          the maximum price
     * @param gps               whether GPS is required
     * @param backupCamera      whether a backup camera is required
     * @param manualTransmission whether a manual transmission is required
     * @param bluetooth         whether Bluetooth is required
     */
    public FiltersDto(int minPrice, int maxPrice, Boolean gps, Boolean backupCamera, Boolean manualTransmission, Boolean bluetooth) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.gps = gps;
        this.backupCamera = backupCamera;
        this.manualTransmission = manualTransmission;
        this.bluetooth = bluetooth;
    }

    // Getters and Setters with Javadoc

    /**
     * Gets the minimum price.
     *
     * @return the minimum price
     */
    public int getMinPrice() {
        return minPrice;
    }

    /**
     * Sets the minimum price.
     *
     * @param minPrice the new minimum price
     */
    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * Gets the maximum price.
     *
     * @return the maximum price
     */
    public int getMaxPrice() {
        return maxPrice;
    }

    /**
     * Sets the maximum price.
     *
     * @param maxPrice the new maximum price
     */
    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * Gets the GPS requirement.
     *
     * @return true if GPS is required, false otherwise
     */
    public Boolean getGps() {
        return gps;
    }

    /**
     * Sets the GPS requirement.
     *
     * @param gps the new GPS requirement
     */
    public void setGps(Boolean gps) {
        this.gps = gps;
    }

    /**
     * Gets the backup camera requirement.
     *
     * @return true if a backup camera is required, false otherwise
     */
    public Boolean getBackupCamera() {
        return backupCamera;
    }

    /**
     * Sets the backup camera requirement.
     *
     * @param backupCamera the new backup camera requirement
     */
    public void setBackupCamera(Boolean backupCamera) {
        this.backupCamera = backupCamera;
    }

    /**
     * Gets the manual transmission requirement.
     *
     * @return true if a manual transmission is required, false otherwise
     */
    public Boolean getManualTransmission() {
        return manualTransmission;
    }

    /**
     * Sets the manual transmission requirement.
     *
     * @param manualTransmission the new manual transmission requirement
     */
    public void setManualTransmission(Boolean manualTransmission) {
        this.manualTransmission = manualTransmission;
    }

    /**
     * Gets the Bluetooth requirement.
     *
     * @return true if Bluetooth is required, false otherwise
     */
    public Boolean getBluetooth() {
        return bluetooth;
    }

    /**
     * Sets the Bluetooth requirement.
     *
     * @param bluetooth the new Bluetooth requirement
     */
    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    @Override
    public String toString() {
        return "FiltersDto{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", gps=" + gps +
                ", backupCamera=" + backupCamera +
                ", manualTransmission=" + manualTransmission +
                ", bluetooth=" + bluetooth +
                '}';
    }
}
