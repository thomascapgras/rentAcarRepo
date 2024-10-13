package com.project.rentAcar.dao;

import com.project.rentAcar.entities.Agency;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import java.util.List;

/**
 * This interface defines methods for managing Agency entities.
 */
public interface AgencyDao {

    /**
     * Saves a new agency.
     *
     * @param agency the agency to save
     * @return the saved agency
     * @throws RessourceNotFoundException if the resource is not found
     * @throws RessourceAlreadyExistsException if the agency already exists
     */
    public Agency saveAgency(Agency agency) throws RessourceNotFoundException, RessourceAlreadyExistsException;

    /**
     * Finds agencies by city.
     *
     * @param city the city to search agencies in
     * @return a list of agencies in the specified city
     * @throws RessourceNotFoundException if no agencies are found in the city
     */
    public List<Agency> findAgencieByCity(Cities city) throws RessourceNotFoundException;

    /**
     * Finds an agency by its name.
     *
     * @param name the name of the agency
     * @return the agency with the specified name
     * @throws RessourceNotFoundException if the agency is not found
     */
    public Agency findAgencyByName(String name) throws RessourceNotFoundException;

    /**
     * Finds an agency by its ID.
     *
     * @param id the ID of the agency
     * @return the agency with the specified ID
     * @throws RessourceNotFoundException if the agency is not found
     */
    public Agency findAgencyById(int id) throws RessourceNotFoundException;
}
