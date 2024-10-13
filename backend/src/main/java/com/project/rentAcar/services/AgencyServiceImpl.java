package com.project.rentAcar.services;

import com.project.rentAcar.dao.AgencyDao;
import com.project.rentAcar.entities.Agency;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing agencies.
 */
@Service
public class AgencyServiceImpl implements AgencyService {
    private static final Logger logger = LoggerFactory.getLogger(AgencyServiceImpl.class);
    @Autowired
    private AgencyDao agencyDao;

    public AgencyServiceImpl(){
        logger.info("Enter into : " + AgencyServiceImpl.class );
    }

    /**
     * Saves a new agency.
     *
     * @param agency the agency to be saved
     * @return the saved agency
     */
    @Override
    @Transactional
    public Agency saveAgency(Agency agency) throws RessourceNotFoundException, RessourceAlreadyExistsException {
        logger.info("Enter into saveAgency service method");
        return this.agencyDao.saveAgency(agency);
    }

    /**
     * Finds agencies by city.
     *
     * @param city the city to search agencies in
     * @return a list of agencies in the specified city
     */
    @Override
    public List<Agency> findAgencieByCity(Cities city) throws RessourceNotFoundException {
        logger.info("Enter into findAgencieByCity service method");
        return this.agencyDao.findAgencieByCity(city);
    }

    /**
     * Finds an agency by name.
     *
     * @param name the name of the agency
     * @return the agency with the specified name, or null if not found
     */
    @Override
    public Agency findAgencyByName(String name) throws RessourceNotFoundException {
        logger.info("Enter into findAgencyByName service method");
        return this.agencyDao.findAgencyByName(name);
    }

    /**
     * Finds an agency by ID.
     *
     * @param id the ID of the agency
     * @return the agency with the specified ID, or null if not found
     */
    @Override
    public Agency findAgencyById(int id) throws RessourceNotFoundException {
        logger.info("Enter into findAgencyById service method");
        return this.agencyDao.findAgencyById(id);
    }
}
