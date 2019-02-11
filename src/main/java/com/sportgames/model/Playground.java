package com.sportgames.model;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "playgrounds")
public class Playground {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "address", unique = true, nullable = false)
    private String address; //Адрес площадки

    @Column (name = "coordinates", unique = true, nullable = false)
    private Point coordinates; //Адрес площадки

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Sport> sports; // Виды спорта, поддерживаемые площадкой

    public Playground(){}

    public Playground(String address){
        this.address = address;
        this.coordinates = new Point(0, 0);
    }

    public Playground(String address, Point coordinates){
        this.address = address;
        this.coordinates = coordinates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Sport> getSports() {
        return sports;
    }

    public void setSports(Set<Sport> sports) {
        this.sports = sports;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }
}
