package com.project.rentAcar.entities;

import com.project.rentAcar.dto.BasketDto;
import com.project.rentAcar.dto.ReservationDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Entity representing a basket.
 */
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "basket_reservation",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    private List<Reservation> reservations;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Default constructor.
     */
    public Basket() {
    }

    /**
     * Constructs a Basket from a BasketDto.
     *
     * @param basketDto the BasketDto
     */
    public Basket(BasketDto basketDto) {
        this.id = basketDto.getId();
        for (ReservationDto reservationDto : basketDto.getReservationDtos()) {
            this.reservations.add(new Reservation(reservationDto));
        }
    }

    /**
     * Gets the list of reservations in the basket.
     *
     * @return the list of reservations in the basket
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Sets the list of reservations in the basket.
     *
     * @param reservations the new list of reservations in the basket
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Gets the ID of the basket.
     *
     * @return the ID of the basket
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the basket.
     *
     * @param id the new ID of the basket
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user associated with the basket.
     *
     * @return the user associated with the basket
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the basket.
     *
     * @param user the new user associated with the basket
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Adds a reservation to the basket.
     *
     * @param reservation the reservation to be added
     */
    public void addReservation(Reservation reservation) {
        if (this.reservations == null) {
            this.reservations = new ArrayList<>();
        }
        this.reservations.add(reservation);
    }

    /**
     * Returns a string representation of the Basket.
     *
     * @return a string representation of the Basket
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Basket{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user != null ? user.getId() : "null");
        sb.append('}');
        return sb.toString();
    }
}
