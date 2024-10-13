package com.project.rentAcar.services;

import com.project.rentAcar.dao.BasketDao;
import com.project.rentAcar.dto.BasketDto;
import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.entities.Basket;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Service implementation for managing baskets.
 */
@Service
public class BasketServiceImpl implements BasketService {
    private static final Logger logger = LoggerFactory.getLogger(BasketServiceImpl.class);
    @Autowired
    private BasketDao basketDao;

    @Autowired
    private UserService userService;

    public BasketServiceImpl(){
        logger.info("Enter into : " +BasketServiceImpl.class );
    }

    /**
     * Creates a new basket.
     *
     * @param userDto the user
     * @return the created basketDto
     */
    @Override
    @Transactional
    public BasketDto createBasket(UserDto userDto) throws RessourceNotFoundException {
        logger.info("Enter into createBasket service method");
        Basket basket = new Basket();
        User user = this.userService.findUserById(userDto.getId());
        basket.setUser(user);
        this.basketDao.createBasket(basket);
        BasketDto basketDto=new BasketDto(user);
        return basketDto;
    }

    /**
     * Updates an existing basket.
     *
     * @param basket the basket to be updated
     * @return the updated basket
     */
    @Override
    @Transactional
    public Basket updateBasket(Basket basket) throws RessourceNotFoundException {
        logger.info("Enter into updateBasket service method");
        this.basketDao.findBasketById(basket.getId());
        Basket basketUpdated = this.basketDao.updateBasket(basket);
        return basketUpdated;
    }

    /**
     * Finds a basket by its ID.
     *
     * @param id the ID of the basket
     * @return the basketDto with the specified ID, or null if not found
     */
    @Override
    public BasketDto findBasketById(int id) throws RessourceNotFoundException {
        logger.info("Enter into findBasketById service method");
        Basket basket = this.basketDao.findBasketById(id);
        BasketDto basketDto = new BasketDto(basket);
        return basketDto;
    }

    /**
     * Finds a basket by the user ID.
     *
     * @param id the ID of the user
     * @return the basket associated with the specified user ID, or null if not found
     */
    @Override
    public BasketDto findBasketByUserId(int id) throws RessourceNotFoundException {
        logger.info("Enter into findBasketByUserId service method");
        Basket basket = this.basketDao.findBasketByUserId(id);
        BasketDto basketDto = new BasketDto(basket);
        return basketDto;
    }
}
