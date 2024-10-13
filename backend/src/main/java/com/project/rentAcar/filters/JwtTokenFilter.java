package com.project.rentAcar.filters;

import com.project.rentAcar.dao.ReservationDaoImpl;
import com.project.rentAcar.entities.Authorities;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.reactive.function.client.WebClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Filter that processes JWT and Google OAuth2 tokens for authentication.
 */
public class JwtTokenFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    private final UserService userService;
    private final JwtDecoder jwtDecoder;
    private static final String SECRET_KEY = ${SECRET_KEY};
    private static final String GOOGLE_USERINFO_ENDPOINT = "https://www.googleapis.com/oauth2/v3/userinfo";

    /**
     * Constructs a JwtTokenFilter with the specified user service and JWT decoder.
     *
     * @param userService the user service
     * @param jwtDecoder  the JWT decoder
     */
    public JwtTokenFilter(UserService userService, JwtDecoder jwtDecoder) {
        this.userService = userService;
        this.jwtDecoder = jwtDecoder;
    }

    /**
     * Filters incoming requests and processes JWT and Google OAuth2 tokens.
     *
     * @param request     the HTTP request
     * @param response    the HTTP response
     * @param filterChain the filter chain
     * @throws ServletException if a servlet error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            try {
                if (isJwt(token)) {
                    logger.info("token is jwt");
                    handleJwtToken(token);
                } else {
                    logger.info("token is google jwt");
                    handleGoogleOAuth2Token(token);
                }
            } catch (Exception e) {
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Checks if the provided token is a JWT token.
     *
     * @param token the token to check
     * @return true if the token is a JWT token, false otherwise
     */
    private boolean isJwt(String token) {
        return token.split("\\.").length == 3;
    }

    /**
     * Handles the processing of a JWT token.
     *
     * @param token the JWT token
     */
    private void handleJwtToken(String token) throws RessourceNotFoundException {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        logger.info("validation jwt");
        String username = claims.getSubject();
        User user = userService.findUserByEmail(username);
        List<GrantedAuthority> authorities = getGrantedAuthorities(user.getAuthorities());

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(username, user.getPwd(), authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * Handles the processing of a Google OAuth2 token.
     *
     * @param token the Google OAuth2 token
     */
    private void handleGoogleOAuth2Token(String token) {
        WebClient webClient = WebClient.create();
        Map<String, Object> userInfo = webClient.get()
                .uri(GOOGLE_USERINFO_ENDPOINT)
                .headers(headers -> headers.setBearerAuth(token))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (userInfo != null && userInfo.get("email") != null) {
            String email = userInfo.get("email").toString();
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(email, null, authorities);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            throw new RuntimeException("Google OAuth2 token validation failed");
        }
    }

    /**
     * Converts a list of `Authorities` to a list of `GrantedAuthority`.
     *
     * @param authorities the list of `Authorities`
     * @return the list of `GrantedAuthority`
     */
    private List<GrantedAuthority> getGrantedAuthorities(List<Authorities> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authorities authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
}
