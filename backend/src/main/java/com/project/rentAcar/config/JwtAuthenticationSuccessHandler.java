package com.project.rentAcar.config;

import com.project.rentAcar.services.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * This SuccessHandler handles OAuth2 authentication when it has succeeded.
 */
@Component
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JwtAuthenticationSuccessHandler.class);

    @Autowired
    private JwtTokenProvider tokenProvider;

    public JwtAuthenticationSuccessHandler() {
        logger.info("Enter into : " + JwtAuthenticationSuccessHandler.class);
    }

    /**
     * Handles successful authentication by generating a JWT token and adding it to the response header.
     *
     * @param request the HTTP request object
     * @param response the HTTP response object
     * @param authentication the authentication object containing user credentials
     * @throws IOException if an input or output exception occurs
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String token;
        logger.info("Enter into onAuthenticationSuccess method");

        if (authentication instanceof OAuth2AuthenticationToken) {
            logger.info("OAuth2AuthenticationToken is an OAuth2 token");
            OAuth2AuthenticationToken oauth2Token = (OAuth2AuthenticationToken) authentication;
            String email = oauth2Token.getPrincipal().getAttribute("email");
            token = tokenProvider.generateToken(email);
            logger.info("Email and token added to response");
            logger.info("Email: " + email);
            response.addHeader("Authorization", "Bearer " + token);
        }
    }
}
