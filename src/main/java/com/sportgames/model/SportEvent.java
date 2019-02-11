package com.sportgames.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.Locale;
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

    @JsonSerialize(as = LocalDateTime.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss", locale="Ru-ru")
    @Column (name = "timeStart", nullable = false)
    private LocalDateTime timeStart; //Время начала события

    @JsonSerialize(as = LocalDateTime.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss", locale="ru-RU")
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

    @JsonSerialize(as = LocalDateTime.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss", locale="Ru-ru")
    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    @JsonSerialize(as = LocalDateTime.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss", locale="ru-Ru")
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
