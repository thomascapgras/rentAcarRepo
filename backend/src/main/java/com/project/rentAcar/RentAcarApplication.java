package com.project.rentAcar;


import com.project.rentAcar.entities.Basket;
import com.project.rentAcar.entities.Car;
import com.project.rentAcar.entities.Reservation;

import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;
import com.project.rentAcar.services.BasketService;
import com.project.rentAcar.services.CarService;

import com.project.rentAcar.services.ReservationService;
import com.project.rentAcar.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class RentAcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentAcarApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ReservationService reservationService, CarService carService,
											   UserService userService, BasketService basketService){
		return runner->{
			//saveReservation(reservationService,carService,personService);
			//findReservationById(reservationService);
			//deleteReservation(reservationService,carService);
			//saveBasket(basketService,carService,userService);
			//findBasketByUserId(basketService);

		};
	}

	public void findReservationById(ReservationService reservationService) throws RessourceNotFoundException {
		int id =2;
		//Reservation reservation = reservationService.findReservationById(id);
		//System.out.println(reservation);
	}

	private void saveReservation(ReservationService reservationService,CarService carService,UserService userService) {

	}

	public void deleteReservation(ReservationService reservationService,CarService carService) throws RessourceNotFoundException {
		int id=6;
		//Reservation reservation = reservationService.findReservationById(id);
		//System.out.println(reservation);
		//Reservation reservation = reservationService.deleteReservationByid(id);

	}

	public void saveBasket(BasketService basketService, CarService carService, UserService userService) throws RessourceNotFoundException, RessourceAlreadyExistsException {
		int id1=1;
		int idUser =1;
		Car car1 = carService.findCarById(id1);
		User user= new User();
		Reservation reservation = new Reservation();

		user = userService.findUserById(idUser);
		Basket basket = new Basket();
		//basket.setCars(cars);
		//.setUser(user);
		//basketService.createBasket(basket);
	}

	public void findBasketByUserId(BasketService basketService) throws RessourceNotFoundException {
		int id = 1;
		//Basket basket = basketService.findBasketByUserId(id);
		//System.out.println(basket);
	}

}
