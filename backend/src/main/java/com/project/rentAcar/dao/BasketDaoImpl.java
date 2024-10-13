package com.project.rentAcar.dao;

import com.project.rentAcar.entities.Basket;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class implements the BasketDao interface and provides the implementation for accessing Basket data.
 */
@Repository
public class BasketDaoImpl implements BasketDao {

    private static final Logger logger = LogManager.getLogger(BasketDaoImpl.class);

    @Autowired
    private EntityManager em;

    public BasketDaoImpl() {
        logger.info("Enter into: " + BasketDaoImpl.class);
    }

    /**
     * Creates a new basket in the database.
     *
     * @param basket the basket to be created
     * @return the created basket
     */
    @Override
    public Basket createBasket(Basket basket){
        logger.info("Enter into createBasket dao method");
        em.persist(basket);
        logger.info("Basket saved: " + basket);
        return basket;
    }

    /**
     * Updates an existing basket in the database.
     *
     * @param basket the basket to be updated
     * @return the updated basket
     */
    @Override
    public Basket updateBasket(Basket basket) throws RessourceNotFoundException {
        logger.info("Enter into updateBasket dao method");
        basket = this.em.merge(basket);
        logger.info("Basket updated: " + basket);
        return basket;
    }


    /**
     * Finds a basket by its ID.
     *
     * @param id the ID of the basket to search for
     * @return the basket with the specified ID
     */
    @Override
    public Basket findBasketById(int id) throws RessourceNotFoundException {
        logger.info("Enter into findBasketById dao method");
        Basket basket = this.em.find(Basket.class, id);
        if (basket == null) {
            throw new RessourceNotFoundException("Basket not found with id: " + id);
        }
        logger.info("Basket found: " + basket);
        return basket;
    }

    /**
     * Finds a basket by the user's ID.
     *
     * @param id the ID of the user whose basket to search for
     * @return the basket associated with the specified user ID
     */
    @Override
    public Basket findBasketByUserId(int id) throws RessourceNotFoundException {
        logger.info("Enter into findBasketByUserId dao method");
        TypedQuery<Basket> query = em.createQuery("SELECT b FROM Basket b WHERE b.user.id = :userId", Basket.class);
        query.setParameter("userId", id);
        try {
            Basket basket = query.getSingleResult();
            logger.info("Basket found: " + basket);
            return basket;
        } catch (NoResultException e) {
            throw new RessourceNotFoundException("Basket not found with user id: " + id);
        }
    }
}
