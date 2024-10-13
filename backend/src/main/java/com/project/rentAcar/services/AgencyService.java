package com.project.rentAcar.services;

import com.project.rentAcar.entities.Agency;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

import java.util.List;

/**
 * This interface defines agency service methods.
 */
public interface AgencyService {

    /**
     * Saves an agency.
     *
     * @param agency the agency to be saved
     * @return the saved agency
     * @throws RessourceNotFoundException if the agency is not found
     * @throws RessourceAlreadyExistsException if the agency already exists
     */
    public Agency saveAgency(Agency agency) throws RessourceNotFoundException, RessourceAlreadyExistsException;

    /**
     * Finds agencies by city.
     *
     * @param city the city to search for agencies
     * @return the list of agencies in the specified city
     * @throws RessourceNotFoundException if no agencies are found in the specified city
     */
    public List<Agency> findAgencieByCity(Cities city) throws RessourceNotFoundException;

    /**
     * Finds an agency by name.
     *
     * @param name the name of the agency to search for
     * @return the agency with the specified name
     * @throws RessourceNotFoundException if no agency is found with the specified name
     */
    public Agency findAgencyByName(String name) throws RessourceNotFoundException;

    /**
     * Finds an agency by ID.
     *
     * @param id the ID of the agency to search for
     * @return the agency with the specified ID
     * @throws RessourceNotFoundException if no agency is found with the specified ID
     */
    public Agency findAgencyById(int id) throws RessourceNotFoundException;
}
