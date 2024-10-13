package com.project.rentAcar.controlleurs;

import com.project.rentAcar.dto.UserDto;
import com.project.rentAcar.dto.UserRegistrationDto;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.JwtTokenProvider;
import com.project.rentAcar.services.UserRegistrationServiceImpl;
import com.project.rentAcar.services.UserService;
import com.project.rentAcar.validators.ValidId;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



/**
 * This controller handles user-related endpoints.
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegistrationServiceImpl userRegistrationService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JwtTokenProvider tokenProvider;

    public UserController(){
        logger.info("Enter into : " + UserController.class);
    }

    /**
     * Saves a new user with the given email and password.
     *
     * @param userRegistrationDto the user to be registered
     * @return a response entity with a confirmation message and HTTP status CREATED, or a message with HTTP status CONFLICT if the email already exists
     */
    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserRegistrationDto userRegistrationDto)  {
        logger.info("Enter into saveUser endpoint method" );
        try {
            this.userService.existsByEmail(userRegistrationDto.getEmail());
            String encodedPwd = this.passwordEncoder.encode(userRegistrationDto.getPwd());
            userRegistrationDto.setPwd(encodedPwd);
            UserDto userDto = this.userRegistrationService.saveUserAndCreateBasket(userRegistrationDto);
            String token = tokenProvider.generateToken(userDto.getEmail());
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            logger.info("sending back token and user");
            return ResponseEntity.status(HttpStatus.CREATED)
                    .headers(headers)
                    .body(userDto);
        } catch (RessourceNotFoundException e) {
             return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (RessourceAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Finds a user by their email address.
     *
     * @param email the email address to search for
     * @return a response entity containing the user and HTTP status OK, or a message with HTTP status NOT_FOUND if no user is found
     */
    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable @Email String email) {
        logger.info("Enter into findUserByEmail endpoint method" );
        try {
            UserDto userDto = this.userService.findUserByEmailDto(email);
            logger.info("Sending back user");
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Finds a user by their ID.
     *
     * @param id the ID of the user to search for
     * @return a response entity containing the user and HTTP status OK, or a message with HTTP status NOT_FOUND if no user is found
     */
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable @ValidId(entityClass = User.class) int id)  {
        logger.info("Enter into findUserById endpoint method" );
        try {
            UserDto userDto = this.userService.findUserByIdDto(id);
            logger.info("Sending back user");
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Saves a new OAuth2 user using the provided authorization token.
     *
     * @param request the HTTP request containing the authorization token
     * @return a response entity containing the saved user and HTTP status OK
     */
    @PostMapping("/saveOauth2User")
    public ResponseEntity<?> saveOauth2User(HttpServletRequest request)  {
        logger.info("Enter into saveOauth2User endpoint method" );
        try {
            String token = request.getHeader("Authorization");
            UserDto userdto = this.userRegistrationService.saveUserWithOuath2AndCreateBasket(token);
            logger.info("Sending back user");
            return new ResponseEntity<>(userdto, HttpStatus.OK);
        } catch (RessourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return new ResponseEntity<>("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
