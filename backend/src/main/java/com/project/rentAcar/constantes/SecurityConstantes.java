package com.project.rentAcar.constantes;


/**
 *This class defines constants (endpouints, jwt header and secret key) of the application
 */
public class SecurityConstantes {

    public static final String JWT_HEADER = "Authorization";
    private static final String SECRET_KEY = "gk2FOvp5YPpac8f5UslDeUSvKvMtgjNVtNgMYAs6Lgk=";
    public static final String[] ADMIN_ENDPOINTS = {"/user/getUserById/{id}"};
    public static final String[] USER_ENDPOINTS = {"/user/myProfile","/reservation/deleteReservation/{id}"};
    public static final String[] PUBLIC_ENDPOINTS = {"/login",
            "/error", "/logout"};


    public static final String[] PUBLIC_USER_ENDPOINTS = {"/user/saveUser",
            "/user/saveOauth2User","/user/getUserByEmail/{email}"};

    public static final String[] PUBLIC_CAR_ENDPOINTS = {"/car/getCarById/{id}",
           "/car/getavailableCarsByCity/{city}", "/car/getavailableCarsByBrand/{brand}",
            "/car/getCarById/{id}", "/car/saveCar","/car/getAvailableCars"};

    public static final String[] PUBLIC_RESERVATION_ENDPOINTS = {"/reservation/getReservationById/{id}",
            "/reservation/saveReservation","/reservation/getReservationsByUserId/{id}"};

    public static final String[] PUBLIC_AGENCY_ENDPOINTS = {"/agency/saveAgency"};

    public static final String[] PUBLIC_CONTACT_ENDPOINTS = {"/contact/saveContact"};

    public static final String[] PUBLIC_BASKET_ENDPOINTS = {"/basket/saveBasket","/basket/getBasketByUserId/{id}"};


}