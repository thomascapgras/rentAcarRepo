package com.project.rentAcar.config;

import com.project.rentAcar.entities.Authorities;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * This class overrides the Spring Security authentication provider.
 * When a user authenticates with basic authentication, this class verifies the password and the username.
 */
@Component
public class RentACarUsernamePwdAuthenticateProvider implements AuthenticationProvider {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RentACarUsernamePwdAuthenticateProvider.class);
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public RentACarUsernamePwdAuthenticateProvider(){
        logger.info("Enter into : " + RentACarUsernamePwdAuthenticateProvider.class);
    }

    /**
     * Provides authentication for the given credentials.
     * @param authentication user credentials
     * @return an authenticated token if the credentials are valid
     * @throws AuthenticationException if the credentials are invalid
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("Enter into Authentication method" );
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        User user = null;
        try {
            user = userService.findUserByEmail(username);
        } catch (RessourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (user != null && passwordEncoder.matches(pwd, user.getPwd())) {
            logger.info("Password and username are valid" );
            List<GrantedAuthority> authorities = getGrantedAuthorities(user.getAuthorities());
            return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    /**
     * Converts a list of Authorities to a list of GrantedAuthority.
     *
     * @param authorities the list of authorities from the user
     * @return a list of GrantedAuthority
     */
    private List<GrantedAuthority> getGrantedAuthorities(List<Authorities> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authorities authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }

    /**
     * Indicates whether this provider supports the specified authentication token.
     *
     * @param authentication the class of the authentication token
     * @return true if the authentication token is supported, false otherwise
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
