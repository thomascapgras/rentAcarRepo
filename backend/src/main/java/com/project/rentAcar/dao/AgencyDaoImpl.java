package com.project.rentAcar.dao;

import com.project.rentAcar.entities.Agency;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class implements the AgencyDao interface and provides the implementation for accessing Agency data.
 */
@Repository
public class AgencyDaoImpl implements AgencyDao {
    private static final Logger logger = LogManager.getLogger(AgencyDaoImpl.class);
    @Autowired
    private EntityManager em;

    public AgencyDaoImpl(){
        logger.info("Enter into : " +AgencyDaoImpl.class );
    }
    /**
     * Saves an agency to the database.
     *
     * @param agency the agency to be saved
     * @return the saved agency
     */
    @Override
    public Agency saveAgency(Agency agency) {
        logger.info("Enter into saveAgency dao method");
        this.em.persist(agency);
        logger.info("Agency saved: " + agency);
        return agency;
    }

    /**
     * Finds agencies by city.
     *
     * @param city the city to search agencies by
     * @return a list of agencies in the specified city
     */
    @Override
    public List<Agency> findAgencieByCity(Cities city) throws RessourceNotFoundException {
        logger.info("Enter into findAgencieByCity dao method");
        TypedQuery<Agency> query = this.em.createQuery("from Agency where city=:city", Agency.class);
        query.setParameter("city", city);
        List<Agency> agencies = query.getResultList();
        if (agencies.isEmpty()){
            throw new RessourceNotFoundException("Agencies not found with city : " + city.getCity());
        }
        logger.info("Agencies found with city : " + city.getCity());
        logger.info("List of agencies : " + agencies);
        return agencies;
    }

    /**
     * Finds an agency by its name.
     *
     * @param name the name of the agency to search for
     * @return the agency with the specified name
     */
    @Override
    public Agency findAgencyByName(String name) throws RessourceNotFoundException {
        logger.info("Enter into findAgencyByName dao method");
        TypedQuery<Agency> query = this.em.createQuery("from Agency where name=:name", Agency.class);
        query.setParameter("name", name);
        Agency agency = query.getSingleResult();
        if (agency==null){
            throw new RessourceNotFoundException("Agency not found with name : " + name);
        }
        logger.info("Agency found: " + agency);
        return agency;
    }

    /**
     * Finds an agency by its ID.
     *
     * @param id the ID of the agency to search for
     * @return the agency with the specified ID
     */
    @Override
    public Agency findAgencyById(int id) throws RessourceNotFoundException {
        logger.info("Enter into findAgencyById dao method");
        Agency agency = this.em.find(Agency.class, id);
        if (agency==null){
            throw new RessourceNotFoundException("Agency not found with id : " + id);
        }
        logger.info("Agency found: " + agency);
        return agency;
    }
}
