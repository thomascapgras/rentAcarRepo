package com.project.rentAcar.dao;

import com.project.rentAcar.entities.Basket;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

/**
 * This interface defines methods for managing Basket entities.
 */
public interface BasketDao {

    /**
     * Creates a new basket.
     *
     * @param basket the basket to create
     * @return the created basket
     */
    public Basket createBasket(Basket basket);

    /**
     * Updates an existing basket.
     *
     * @param basket the basket to update
     * @return the updated basket
     * @throws RessourceNotFoundException if the basket is not found
     */
    public Basket updateBasket(Basket basket) throws RessourceNotFoundException;

    /**
     * Finds a basket by its ID.
     *
     * @param id the ID of the basket
     * @return the basket with the specified ID
     * @throws RessourceNotFoundException if the basket is not found
     */
    public Basket findBasketById(int id) throws RessourceNotFoundException;

    /**
     * Finds a basket by the user ID.
     *
     * @param id the ID of the user
     * @return the basket associated with the specified user ID
     * @throws RessourceNotFoundException if the basket is not found
     */
    public Basket findBasketByUserId(int id) throws RessourceNotFoundException;
}
