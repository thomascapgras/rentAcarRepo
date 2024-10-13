package com.project.rentAcar.services;

import com.project.rentAcar.dto.BasketDto;
import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.entities.Basket;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

/**
 * This interface defines basket service methods.
 */
public interface BasketService {

    /**
     * Creates a new basket for a user.
     *
     * @param userDto the user for whom the basket is being created
     * @return the created BasketDto
     * @throws RessourceNotFoundException if the user is not found
     * @throws RessourceAlreadyExistsException if the basket already exists
     */
    public BasketDto createBasket(UserDto userDto) throws RessourceNotFoundException, RessourceAlreadyExistsException;

    /**
     * Updates an existing basket.
     *
     * @param basket the basket to be updated
     * @return the updated basket
     * @throws RessourceNotFoundException if the basket is not found
     */
    public Basket updateBasket(Basket basket) throws RessourceNotFoundException;

    /**
     * Finds a basket by its ID.
     *
     * @param id the ID of the basket
     * @return the BasketDto with the specified ID
     * @throws RessourceNotFoundException if the basket is not found
     */
    public BasketDto findBasketById(int id) throws RessourceNotFoundException;

    /**
     * Finds a basket by the user ID.
     *
     * @param id the ID of the user
     * @return the BasketDto for the specified user ID
     * @throws RessourceNotFoundException if the basket is not found
     */
    public BasketDto findBasketByUserId(int id) throws RessourceNotFoundException;
}
