package com.project.rentAcar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.JwtTokenProvider;
import com.project.rentAcar.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This SuccessHandler handles successful basic authentication by generating a JWT token
 * and returning user information in the response.
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CustomAuthenticationSuccessHandler() {
        logger.info("Enter into : " + CustomAuthenticationSuccessHandler.class);
    }

    /**
     * Handles successful authentication.
     *
     * @param request the HTTP request object
     * @param response the HTTP response object
     * @param authentication contains the user credentials
     * @throws IOException if an input or output exception occurs
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String email;
        String token;
        logger.info("Enter into onAuthenticationSuccess method");
        if (authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
            email = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
        } else {
            email = authentication.getPrincipal().toString();
        }

        int userId = 0;
        try {
            userId = userService.findUserIdByEmail(email);
        } catch (RessourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        token = tokenProvider.generateToken(authentication.getName());

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("email", email);
        responseData.put("id", userId);

        response.setContentType("application/json");
        response.addHeader("Authorization", "Bearer " + token);

        logger.info("Putting email, user ID, and JWT into HTTP response...");
        logger.info("Email: " + email);
        logger.info("UserId: " + userId);

        response.getWriter().write(objectMapper.writeValueAsString(responseData));
    }
}
