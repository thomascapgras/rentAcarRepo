package com.project.rentAcar.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

/**
 * Service for generating JWT tokens.
 */
@Service
public class JwtTokenProvider {

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hours
    private static final String SECRET_KEY = ${SECRET_KEY};

    /**
     * Generates a JWT token for the specified username.
     *
     * @param username the username for which the token is generated
     * @return the generated JWT token
     */
    public String generateToken(String username) {
        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
        SecretKey key = Keys.hmacShaKeyFor(decodedKey);
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRE_DURATION);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }
}
