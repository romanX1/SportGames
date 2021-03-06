package com.sportgames.model;


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
    private String address;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pointId")
    private Point coordinates;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Sport> sports;

    public Playground(){}

    public Playground(String address){
        this.address = address;
        this.coordinates = new Point(0.0f, 0.0f);
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
