package com.sportgames.model;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "sportevents")
public class SportEvent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @Column (name = "sport", nullable = false)
    private Sport sport; // Вид спорта события

    @Column (name = "time", nullable = false)
    private String timeEvent; //Время проведения события

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column (name = "users")
    private Set<User> users; // Сет игроков, учавствующих в событии

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(String timeEvent) {
        this.timeEvent = timeEvent;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
