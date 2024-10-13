package com.project.rentAcar.config;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This controller handles authentication-related endpoints, including login page requests and
 * redirects for OAuth2 authentication.
 */
@RestController
public class AuthController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthController(){
        logger.info("Enter into : " + AuthController.class);
    }

    /**
     * Handles requests to the login page.
     *
     * @param logout indicates if the user has logged out (optional)
     * @param error indicates if there was an error during login (optional)
     * @param request the HTTP request object
     * @return a response entity containing a message based on the login status
     */
    @GetMapping("/login")
    public ResponseEntity<?> loginPage(@RequestParam(value = "logout", required = false) String logout,
                                       @RequestParam(value = "error", required = false) String error,
                                       HttpServletRequest request) {
        Map<String, String> response = new HashMap<>();
        if (logout != null) {
            logger.info("Logout not null");
            response.put("message", "disconnection sucess.");
            return ResponseEntity.ok(response);
        } else if (error != null) {
            logger.info("Error not  null");
            response.put("message", "unvalid credentials. please try again.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } else {
            logger.info("Logout and error null");
            response.put("message", "please login.");
            return ResponseEntity.ok(response);
        }
    }

    /**
     * Redirects to Google's OAuth2 authorization endpoint.
     * @return a response entity with a redirection header to the Google OAuth2 authorization URL
     */

    @GetMapping("/oauth2/authorization/google")
    public ResponseEntity<?> redirectToGoogle() {
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/oauth2/authorization/google").build();
    }

}