package com.project.rentAcar.config;

import com.project.rentAcar.constantes.SecurityConstantes;
import com.project.rentAcar.filters.JwtTokenFilter;
import com.project.rentAcar.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;
import java.util.Collections;

/**
 * This class handles the config of the server
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProjectSecurityConfig {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    /**
     * Configures the security filter chain.
     *
     * @param http the HttpSecurity object
     * @return the SecurityFilterChain object
     * @throws Exception in case of any error
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.authenticationEntryPoint(
                                (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("https://localhost:4200"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                }))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(SecurityConstantes.ADMIN_ENDPOINTS).hasRole("ADMIN")
                        .requestMatchers(SecurityConstantes.USER_ENDPOINTS).hasRole("USER")
                        .requestMatchers(SecurityConstantes.PUBLIC_ENDPOINTS).permitAll()
                        .requestMatchers(SecurityConstantes.PUBLIC_CAR_ENDPOINTS).permitAll()
                        .requestMatchers(SecurityConstantes.PUBLIC_CONTACT_ENDPOINTS).permitAll()
                        .requestMatchers(SecurityConstantes.PUBLIC_USER_ENDPOINTS).permitAll()
                        .requestMatchers(SecurityConstantes.PUBLIC_AGENCY_ENDPOINTS).permitAll()
                        .requestMatchers(SecurityConstantes.PUBLIC_BASKET_ENDPOINTS).permitAll()
                        .requestMatchers(SecurityConstantes.PUBLIC_RESERVATION_ENDPOINTS).permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .successHandler(customAuthenticationSuccessHandler))
                .oauth2Login(oauth2Login -> oauth2Login
                        .successHandler(customAuthenticationSuccessHandler)
                )


                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler((request, response, authentication) -> response.sendRedirect("/login?logout"))
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true))
                .addFilterBefore(jwtTokenFilter(userService, jwtDecoder()), UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /**
     * Bean definition for PasswordEncoder.
     *
     * @return the PasswordEncoder object
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean definition for AuthenticationManager.
     *
     * @param authenticationConfiguration the AuthenticationConfiguration object
     * @return the AuthenticationManager object
     * @throws Exception in case of any error
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    /**
     * Bean definition for JwtDecoder.
     *
     * @return the JwtDecoder object
     */
    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri("https://www.googleapis.com/oauth2/v3/certs").build();
    }

    /**
     * Bean definition for WebClient.
     *
     * The WebClient is used to perform HTTP requests and can be used to call external APIs.
     * It is a non-blocking, reactive client that provides a higher-level API over the HttpClient.
     * This bean creates a WebClient instance that can be injected and used throughout the application
     * to perform HTTP requests in a reactive manner.
     *
     * @return the WebClient object
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    /**
     * Bean definition for JwtTokenFilter.
     *
     * @param userService the UserService object
     * @param jwtDecoder the JwtDecoder object
     * @return the JwtTokenFilter object
     */
    @Bean
    public JwtTokenFilter jwtTokenFilter(UserService userService, JwtDecoder jwtDecoder) {
        return new JwtTokenFilter(userService, jwtDecoder);
    }
}
