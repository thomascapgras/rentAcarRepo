package com.project.rentAcar.entities;

import com.project.rentAcar.dto.CarDto;
import com.project.rentAcar.dto.ReservationDto;
import com.project.rentAcar.entities.enumerations.Cities;
import com.project.rentAcar.entities.enumerations.CitiesConverter;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Entity representing a reservation.
 */
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city")
    @Enumerated(EnumType.STRING)
    @Convert(converter = CitiesConverter.class)
    private Cities city;

    @Column(name = "departure_date", columnDefinition = "DATE")
    private LocalDate departureDate;

    @Column(name = "return_date", columnDefinition = "DATE")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "isActive")
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "reservations", fetch = FetchType.LAZY)
    private List<Basket> basket;

    /**
     * Default constructor.
     */
    public Reservation() {
    }

    /**
     * Constructs a Reservation with the specified details.
     *
     * @param city          the city of the reservation
     * @param departureDate the departure date of the reservation
     * @param returnDate    the return date of the reservation
     * @param car           the car associated with the reservation
     * @param isActive      the active status of the reservation
     */
    public Reservation(Cities city, LocalDate departureDate, LocalDate returnDate, Car car, boolean isActive) {
        this.city = city;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.car = car;
        this.isActive = isActive;
    }

    /**
     * Constructs a Reservation from a ReservationDto.
     *
     * @param reservationDto the ReservationDto
     */
    public Reservation(ReservationDto reservationDto) {
        this.id = reservationDto.getId();
        this.city = reservationDto.getCity();
        this.departureDate = reservationDto.getDepartureDate();
        this.returnDate = reservationDto.getReturnDate();
        this.car = new Car(reservationDto.getCarDto());
        this.isActive = reservationDto.isActive();
    }

    /**
     * Gets the ID of the reservation.
     *
     * @return the ID of the reservation
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the reservation.
     *
     * @param id the new ID of the reservation
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the city of the reservation.
     *
     * @return the city of the reservation
     */
    public Cities getCity() {
        return city;
    }

    /**
     * Sets the city of the reservation.
     *
     * @param city the new city of the reservation
     */
    public void setCity(Cities city) {
        this.city = city;
    }

    /**
     * Gets the departure date of the reservation.
     *
     * @return the departure date of the reservation
     */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the departure date of the reservation.
     *
     * @param departureDate the new departure date of the reservation
     */
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Gets the return date of the reservation.
     *
     * @return the return date of the reservation
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the return date of the reservation.
     *
     * @param returnDate the new return date of the reservation
     */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Gets the car associated with the reservation.
     *
     * @return the car associated with the reservation
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets the car associated with the reservation.
     *
     * @param car the new car associated with the reservation
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Gets the user associated with the reservation.
     *
     * @return the user associated with the reservation
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the reservation.
     *
     * @param user the new user associated with the reservation
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Checks if the reservation is active.
     *
     * @return true if the reservation is active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active status of the reservation.
     *
     * @param active the new active status of the reservation
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Gets the list of baskets associated with the reservation.
     *
     * @return the list of baskets associated with the reservation
     */
    public List<Basket> getBasket() {
        return basket;
    }

    /**
     * Sets the list of baskets associated with the reservation.
     *
     * @param basket the new list of baskets associated with the reservation
     */
    public void setBasket(List<Basket> basket) {
        this.basket = basket;
    }

    /**
     * Returns a string representation of the Reservation.
     *
     * @return a string representation of the Reservation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation{id=").append(id)
                .append(", city=").append(city != null ? city : "null")
                .append(", departureDate=").append(departureDate != null ? departureDate : "null")
                .append(", returnDate=").append(returnDate != null ? returnDate : "null")
                .append(", carId=").append(car != null ? car.getId() : "null")
                .append(", userId=").append(user != null ? user.getId() : "null")
                .append(", isActive=").append(isActive)
                .append('}');
        return sb.toString();
    }
}
