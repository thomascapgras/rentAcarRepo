package com.project.rentAcar.entities;

import jakarta.persistence.*;

/**
 * Entity representing an authority.
 */
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    /**
     * Constructs an Authorities instance with the specified name.
     *
     * @param name the name of the authority
     */
    public Authorities(String name) {
        this.name = name;
    }

    /**
     * Default constructor.
     */
    public Authorities() {
    }

    /**
     * Gets the ID of the authority.
     *
     * @return the ID of the authority
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the authority.
     *
     * @param id the new ID of the authority
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the authority.
     *
     * @return the name of the authority
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the authority.
     *
     * @param name the new name of the authority
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the Authorities.
     *
     * @return a string representation of the Authorities
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Authorities{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
