package com.sportgames.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "playgrounds")
public class Playground {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "address", unique = true, nullable = false)
    private String address; //type Address. Адрес площадки

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column (name = "sports", nullable = false)
    private Set<Sport> sports; // Виды спорта, поддерживаемые площадкой

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column (name = "events")
    private Set<SportEvent> events; // Сет текущих ивентов площадки

    public Playground(){}

    public Playground(String address){
        this.address = address;
        this.sports = sports;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<SportEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<SportEvent> events) {
        this.events = events;
    }

}
