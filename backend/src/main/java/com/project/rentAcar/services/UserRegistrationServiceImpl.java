package com.project.rentAcar.services;

import com.project.rentAcar.dao.UserDao;
import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.dto.UserRegistrationDto;
import com.project.rentAcar.entities.Authorities;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the UserRegistrationService interface.
 */
@Service
public class UserRegistrationServiceImpl implements  UserRegistrationService{
    private static final Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    BasketService basketService;

    private static final String SECRET_KEY = "gk2FOvp5YPpac8f5UslDeUSvKvMtgjNVtNgMYAs6Lgk=";
    private static final String GOOGLE_USERINFO_ENDPOINT = "https://www.googleapis.com/oauth2/v3/userinfo";

    /**
     * Saves a new user and creates a basket for the user.
     *
     * @param userRegistrationDto the user registration data
     * @return the saved UserDto
     * @throws RessourceNotFoundException if the user or basket is not found
     * @throws RessourceAlreadyExistsException if the user already exists
     */
    @Override
    @Transactional
    public UserDto saveUserAndCreateBasket(UserRegistrationDto userRegistrationDto) throws RessourceNotFoundException, RessourceAlreadyExistsException {
        logger.info("Enter into saveUser service method");
        User user = new User(userRegistrationDto);
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(new Authorities("ROLE_USER"));
        user.setAuthorities(authorities);
        user = this.userDao.saveUser(user);
        UserDto userDto = new UserDto(user);
        this.basketService.createBasket(userDto);
        return userDto;
    }


    /**
     * Saves a user with OAuth2 authentication.
     *
     * @param token the OAuth2 token
     * @return the saved user
     * @throws RessourceNotFoundException if the user is not found
     */
    @Override
    @Transactional
    public UserDto saveUserWithOuath2AndCreateBasket(String token) throws RessourceNotFoundException {
        logger.info("Enter into saveUserWithOuath2 service method");
        String tokens = token.substring(7);
        WebClient webClient = WebClient.create();
        Map<String, Object> userInfo = webClient.get()
                .uri(GOOGLE_USERINFO_ENDPOINT)
                .headers(headers -> headers.setBearerAuth(tokens))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        String email = userInfo.get("email").toString();
        logger.info("Processing saving user : " + email);
        User user = new User();
        user.setEmail(email);
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(new Authorities("ROLE_USER"));
        user.setAuthorities(authorities);
        logger.info("User is null, creation of ouath2 user");
        user = this.userDao.saveUser(user);
        UserDto userDto= new UserDto(user);
        return userDto;
    }
}
