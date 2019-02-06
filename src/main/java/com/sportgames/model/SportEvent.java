package com.sportgames.model;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "sportevents")
public class SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
    private Sport sport; // Вид спорта события

    @Column (name = "timeStart", nullable = false)
    private LocalDateTime timeStart; //Время начала события

    @Column (name = "timeEnd", nullable = false)
    private LocalDateTime timeEnd; //Время окончания события

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<User> users; // Сет игроков, учавствующих в событии

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="playgrounds_sports", referencedColumnName="id", nullable=false)
    private Playground playground;

    public SportEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public SportEvent(Sport sport, LocalDateTime timeStart, LocalDateTime timeEnd, Playground playground) {
        this.sport = sport;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.playground = playground;
    }
}
